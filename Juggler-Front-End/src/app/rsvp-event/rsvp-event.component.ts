import { Component, OnInit } from "@angular/core";
import {
  FormControl,
  FormControlName,
  FormGroup,
  FormBuilder,
  Validators
} from "@angular/forms";
import { Router, ActivatedRoute, ParamMap } from "@angular/router";
import { MatDialog } from "@angular/material";
import { Event } from "../event";
import { RsvpService } from "../rsvp.service";
import { Alert } from "selenium-webdriver";
@Component({
  selector: "app-rsvp-event",
  templateUrl: "./rsvp-event.component.html",
  styleUrls: ["./rsvp-event.component.scss"]
})
export class RSVPEventComponent implements OnInit {
  showFiller = false;
  isLinear = true;
  rsvpForm1: FormGroup;
  rsvpForm2: FormGroup;
  rsvpForm3: FormGroup;
  myControl = new FormControl();
  event = new Event();
  event2 = new Event();
  guestArray: string[];
  guests: string;
  invitemail: string;
  emailInvite: string[];
  email: string;
  constructor(
    private rsvpService: RsvpService,
    private _formBuilder: FormBuilder,
    private router: Router,
    // public dialog: MatDialog,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.rsvpForm1 = this._formBuilder.group({
      eventName: ["", Validators.required],
      creatorName: ["", Validators.required],
      eventType: ["", Validators.required],
      Description: ["", Validators.required]
      
    });

    this.rsvpForm2 = this._formBuilder.group({
      eventDate: ["", Validators.required],
      eventTime: ["", Validators.required],
      eventDays: ["", Validators.required],
      eventDuration: ["", Validators.required],
      eventGuest: ["", Validators.required]
    });

    this.rsvpForm3 = this._formBuilder.group({
      eventLocation: ["", Validators.required],
      // emailId: ["", Validators.required],
      invitiesMail: ["", Validators.required],
      phoneNo: ["", Validators.required]
    });
    this.rsvpService.sendEmail();
  }
  get f() {
    return this.rsvpForm1.controls;
  }
  get f1() {
    return this.rsvpForm2.controls;
  }
  get f2() {
    return this.rsvpForm3.controls;
  }

  saveEvent() {
    this.event.creatorOfEvent = this.f.creatorName.value;
    this.event.eventName = this.f.eventName.value;
    this.event.eventType = this.f.eventType.value;
    this.event.eventSynopsis = this.f.Description.value;
    
    this.guests = this.f1.eventGuest.value;
    this.guestArray = this.guests.split(",");
    this.event.guestsofEvent = this.guestArray;
    this.event.eventDate = this.f1.eventDate.value;
    this.event.eventTime = this.f1.eventTime.value;
    this.event.duration = this.f1.eventDuration.value;
    this.event.noOfDays = this.f1.eventDays.value;
    
    //this.event.emailId = this.f2.emailId.value;
    this.email = localStorage.getItem("currentUserEmail");
    this.event.emailId = this.email;
    console.log(this.email);
    this.invitemail = this.f2.invitiesMail.value;
    this.emailInvite = this.invitemail.split(",");
    this.event.invitiesMail = this.emailInvite;
    this.event.phoneNo = this.f2.phoneNo.value;
    this.event.eventLocation = this.f2.eventLocation.value;


    this.rsvpService
      .saveEvent(this.event)
      .subscribe(res => console.log("Saved event"));
    this.router.navigate(["/rsvp/events"]);

    console.log(this.event);
   
  }

  // this.rsvpService.saveEvent(this.event).subscribe(data => {
  //   this.event2 = data;
  // });
}
