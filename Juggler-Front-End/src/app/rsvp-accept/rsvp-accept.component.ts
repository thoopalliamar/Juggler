import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
@Component({
  selector: 'app-rsvp-accept',
  templateUrl: './rsvp-accept.component.html',
  styleUrls: ['./rsvp-accept.component.scss']
})
export class RsvpAcceptComponent implements OnInit {
 flagAccept:boolean=false;
 flagReject:boolean=false;
 flagAcceptLoop:boolean=false;
 flagRejectLoop:boolean=false;

 flagReaccept:boolean;
 countAccept:number=0;
 countReject:number=0;
 countReaccept:number=0;

  constructor(private router: Router) { }

  ngOnInit() {
  }
  accept(){
    this.flagAccept =true;
    // this.countAccept++;
    // console.log(this.countAccept);
    // this.flagAcceptLoop=true;
  }
  reject(){
this.flagReject=true;
//this.countReject++;
// console.log(this.countReject);
// this.flagRejectLoop=true;
  }
 submit(){
   if(this.flagAccept==true){
    this.countAccept++;
    console.log("Accepted "+this.countAccept);
   } else
   {
    this.countReject++;
    console.log("Rejected "+this.countReject);
   }
   this.router.navigate(["/"]);
 }
 

}
