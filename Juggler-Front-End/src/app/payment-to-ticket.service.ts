import { Injectable } from '@angular/core';
import { FullBookingDetails } from './FullBookingDetails';

@Injectable({
  providedIn: 'root'
})
export class PaymentToTicketService {
payObject:FullBookingDetails;
  constructor() { }
  sendtoTicketing(payDetail){
this.payObject=payDetail;
  }
  receiveInTicket(){
    return this.payObject;
  }
}
