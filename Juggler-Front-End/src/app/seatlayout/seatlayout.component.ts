import { Component, OnInit, DoCheck, OnChanges } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { BookingDetailsService } from "../booking-details.service";
import { FullBookingDetails } from "../FullBookingDetails";
import { TicketEngineService } from "../ticket-engine.service";
import * as Stomp from "@stomp/stompjs";
import * as SockJS from "sockjs-client";
import * as $ from "jquery";
import { Layout } from "../layout";
import { Blocking } from "../blocking";
import { Observable } from "rxjs/Rx";
import { count } from "rxjs/operators";
import { LayoutToBillingService } from "../layout-to-billing.service";
import { Location } from "@angular/common";
import { Router } from "@angular/router";
// declare var $: any;

@Component({
  selector: "app-seatlayout",
  templateUrl: "./seatlayout.component.html",
  styleUrls: ["./seatlayout.component.scss"]
})
export class SeatlayoutComponent implements OnInit, DoCheck {
  selectedvalue;
  seatingValue = [];
  totalRow = [];
  totalCol = [];
  jsonRow: any[];
  blocked;
  blockedSeatsArray;
  passage = [];
  buttonColor: string;
  x = [];
  y = [];
  data: any;
  rowPassage;
  division = [];
  blockedSeats = [];
  bookedSeats = [];
  seating = [];
  seatname = [];
  bookingDetail: FullBookingDetails;
  layoutobj: Layout;
  json: any;
  local = [];
  userblockedseats = [];
  count = 0;
  userbookedseats = [];
  showId;
  socket;
  test2;
  serverUrl = "http://13.232.51.70:9079/websocket";
  stompClient;

  constructor(
    private router: Router,
    private http: HttpClient,
    private detailService: BookingDetailsService,
    private ticketengineService: TicketEngineService,
    private layouttobilling: LayoutToBillingService,
    private location: Location
  ) {
    this.webSocketConnect();
  }

  ngOnInit() {
    // this.router.navigate([""]);
    this.bookingDetail = this.detailService.receive();
    console.log("booking details are---", this.bookingDetail);
    console.log("showId is ----------", this.bookingDetail.showId);
    if (this.showId == undefined) {
      this.showId = this.bookingDetail.showId;
    }
    console.log("showId is ----------", this.showId);
    this.blockedSeatsArray = [];
    this.seatname = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];
    this.ticketengineService.getseatDetails(this.showId).subscribe(data => {
      console.log("seatDetails data is ----", data);
      this.json = data;
      this.totalRow.length = this.json.totalRow;
      this.totalCol.length = this.json.totalCol;
      this.totalRow = this.json.rowValues;
      this.totalCol = this.json.colValues;
      this.blockedSeats = this.json.blockedSeats;
      this.bookedSeats = this.json.bookedSeats;
      this.createseating();
    });
  }
  ngDoCheck(): void {}

  webSocketConnect() {
    // setTimeout(() => {
    //   this.ticketengineService
    //     .getData(this.bookingDetail.showId, this.blockedSeatsArray)
    //     .subscribe();
    //   this.stompClient.disconnect();
    // }, 60000 * 5);
    // }, 10000);
    this.socket = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(this.socket);
    let that = this;
    this.stompClient.connect(
      {},
      function(frame) {
        console.log("Connected: " + frame);
        that.stompClient.subscribe("/movie", function(message) {
          console.log("complete message is ", message);
          // that.test1 = message;
          that.test2 = JSON.parse(message.body);
          that.blockedSeats = that.test2.blockedSeats;
          that.bookedSeats = that.test2.bookedSeats;
          // this.blockedSeats=data.body
          console.log("222222222222", that.blocked);
        });
      },
      function(error) {
        console.log("getting error in socket");
        this.ticketengineService
          .getData(this.bookingDetail.showId, this.blockedSeatsArray)
          .subscribe();
        // alert('STOMP error ' + error);
      }
    );
  }
  sendMessage(message) {
    let data = JSON.stringify({
      showId: this.bookingDetail.showId,
      blockedSeats: this.blockedSeatsArray
    });
    this.stompClient.send("/app/message", {}, data);
  }
  // add the seat number to array when clicked
  onclick(x, y) {
    let selected = x * 10 + y + 1;
    var count;
    var flag = this.blockedSeatsArray.every(find);
    if (flag) {
      this.blockedSeatsArray.push(selected);
      this.count++;
    } else {
      let index = this.blockedSeatsArray.indexOf(selected);
      this.blockedSeatsArray.splice(index, 1);
    }
    console.log(this.blockedSeatsArray);

    function find(element) {
      return selected != element;
    }
    this.bookingDetail.selectedSeats = this.blockedSeatsArray;
    this.bookingDetail.totalNoOfTickets = this.count;
    this.bookingDetail.totalAmount = this.count * 250;
    this.bookingDetail.selectedSeatType = "platinum";
    // console.log(this.bookingDetail.showId + "madhusri");
    this.layouttobilling.sendToBilling(this.bookingDetail);
  }

  createseating() {
    console.log(this.totalRow.length);
    for (let i = 0; i < this.totalRow.length; i++) {
      for (let j = 0; j < this.totalCol.length; j++) {
        const seatingStyle = '<div class="seat available"></div>';
        this.seatingValue.push(seatingStyle);
        // console.log(this.seatingValue);
        if (j === this.totalCol.length - 1) {
          console.log("Inside the break line loop");
        }
      }
    }

    $(function() {
      $(".seat").on("click", function() {
        if ($(this).hasClass("selected")) {
          $(this).removeClass("selected");
          // console.log("css removed");
          // console.log("Seat Id: " + this.id + " is removed");
        } else {
          $(this).addClass("selected");
          console.log("css added");
        }
      });
    });
  }
  // CHECKING WHETHER SEAT IS BLOCKED
  seatStatus(row, col) {
    var flag = true;
    // console.log(this.blockedSeats);
    var seatId = row * 10 + col + 1;
    for (var i = 0; i < this.blockedSeats.length; i++) {
      if (this.blockedSeats[i] == seatId ) {
        flag = false;
      }
    }

    for (var i = 0; i < this.bookedSeats.length; i++) {
      if (this.bookedSeats[i] == seatId) {
        flag = false;
      }
    }
    return flag;
  }
  // CHECKING WHETHER SEAT is booked
  seatBook(row, col) {
    var flag = false;
    var seatId = row * 10 + col + 1;
    for (var i = 0; i < this.bookedSeats.length; i++) {
      if (this.bookedSeats[i] == seatId) {
        console.log(this.bookedSeats[i]);
        flag = true;
      }
    }
    return flag;
  }

  // CHECKING WHETHER SEAT is booked
  seatBlocked(row, col) {
    var flag = false;
    var seatId = row * 10 + col + 1;
    for (var i = 0; i < this.blockedSeats.length; i++) {
      if (this.blockedSeats[i] == seatId) {
        flag = true;
      }
    }
    return flag;
  }

  disconnect() {
    this.stompClient.disconnect();
    console.log("disconnecteds");
    // this.ticketengineService.sendseatDetails(
    //   this.bookingDetail.showId,
    //   this.blockedSeatsArray
    // );
  }
}
