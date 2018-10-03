import { Component, OnInit } from "@angular/core";
import { RsvpService } from "../rsvp.service";
import { Router } from '@angular/router';

import {Event} from "../event";
@Component({
  selector: "app-rsvp-events-list",
  templateUrl: "./rsvp-events-list.component.html",
  styleUrls: ["./rsvp-events-list.component.scss"]
})
export class RsvpEventsListComponent implements OnInit {
  search_result1;
  email: string;
  isvalid:Boolean=true;
  //event=new Event();
  //data:Event;
  constructor(private router: Router,private rsvpService: RsvpService) {}

  ngOnInit() {
 
    this.email = localStorage.getItem("currentUserEmail");
    console.log("current email is in ts"+this.email);


     this.rsvpService.searchEvent(this.email).subscribe(data => {
       console.log("data is in ts "+data);
      this.search_result1 = data;
      console.log(this.search_result1+"result getting")
     
     },
     error => {
       this.isvalid=false;
     }   );
    console.log(this.search_result1+" abc");
  
}
}   

 
