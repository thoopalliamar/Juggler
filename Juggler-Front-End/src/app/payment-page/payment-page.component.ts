import { Router } from "@angular/router";
import { LayoutToBillingService } from "./../layout-to-billing.service";
import { Component, OnInit } from "@angular/core";
import { PaymentService } from "../paymentservice";
import { MatDialog } from "@angular/material";
import { PromocodeService } from "../promocode.service";
import { NgxSpinnerService } from "ngx-spinner";
import { FullBookingDetails } from "../FullBookingDetails";

@Component({
  selector: "app-payment-page",
  templateUrl: "./payment-page.component.html",
  styleUrls: ["./payment-page.component.scss"]
})
export class PaymentPageComponent implements OnInit {
  cardNumber: string;
  expiryMonth: string;
  expiryYear: string;
  cvc: string;
  // amount = this.amt.amount;
  amount: number = 50;
  token: string;
  msg: string;
  msg1: string;
  //  bookingStatus: string;
  //  theatreName: string = "PVR";
  //  showId: string = "pvr701:00bangalore";
  //  movieName: string = "hi";
  //  bookedSeats: number[] = [1, 2, 3];
  //  showTiming: string = "01:00";
  //  bookingDetails: FullBookingDetails;

  bookingDetails: FullBookingDetails;

  theatreName: string;
  //  amount: number = 50;

  showId: string;
  movieName: string;
  bookedSeats: number[];
  showTiming: string;
  email: string = "amar@gmail.com";
  //  bookingDetails = new BookingDetails();

  // fileNameRef: MatDialogRef<PaymentDialogComponent>;
  constructor(
    private paymentService: PaymentService,
    private amt: PromocodeService,
    public dialog: MatDialog,
    private ngxSpinner: NgxSpinnerService,
    private route: Router,
    // private bookingDetails: FullBookingDetails,
    private layouttobilling: LayoutToBillingService
  ) {}
  chargeCreditCard() {
    (<any>window).Stripe.card.createToken(
      {
        number: this.cardNumber,
        exp_month: this.expiryMonth,
        exp_year: this.expiryYear,
        cvc: this.cvc
      },
      (status: number, response: any) => {
        if (status === 200) {
          this.token = response.id;
          //  this.amount = this.bookingDetails.Finalamount;
          console.log(this.amount);
          this.theatreName = this.bookingDetails.theaterName;
          console.log(this.theatreName);

          this.showId = this.bookingDetails.showId;
          this.movieName = this.bookingDetails.nameOfMovie;
          this.bookedSeats = this.bookingDetails.selectedSeats;
          this.showTiming = this.bookingDetails.screeningTime;
          // this.bookingDetails.movieName = 'ABCD';
          // this.bookingDetails.showId = 'pvr701:00bangalore';
          // this.movieName = "ABCD";
          // this.showId = "pvr701:00bangalore";
          // this.theatreName = "pvr";
          // this.showTiming = "01:00";
          // this.bookedSeats = [1, 2, 3];
          // this.movieName, this.showId
          this.paymentService.chargeCard(
            this.token,
            this.amount,
            this.bookedSeats,
            this.showId,
            this.theatreName,
            this.movieName,
            this.showTiming,
            this.email
          );
          console.log(this.theatreName);

          this.msg = "Transaction Success";
          console.log(this.token);
          if (this.token == null) {
            this.msg =
              "Transaction failure! Plase Check Your Internet Connection";
          }
        } else {
          this.paymentService.chargeCard(
            this.token,
            this.amount,
            this.bookedSeats,
            this.showId,
            this.theatreName,
            this.movieName,
            this.showTiming,
            this.email
          );
          console.log(response.error.message);

          setTimeout(() => {
            this.route.navigate([""]);
          }, 5000);
          this.msg1 = "Transaction Failed Because " + response.error.message;
        }
      }
    );
    this.ngxSpinner.show();
    setTimeout(() => {
      this.ngxSpinner.hide();
    }, 3000);
  }

  refundCreditCard() {
    this.paymentService.refundCard();
  }

  ngOnInit() {
    this.bookingDetails = this.layouttobilling.getAtBilling();
    console.log(this.bookingDetails.nameOfMovie + "anmisha");
  }
}
