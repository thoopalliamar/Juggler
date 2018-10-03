import { Injectable } from '@angular/core';
import { FullBookingDetails } from './FullBookingDetails';

@Injectable({
  providedIn: 'root'
})
export class BillingToPaymentService {
paymentObject:FullBookingDetails;
  constructor() { }
  sendToPayment(payDetail){
    this.paymentObject=payDetail;
  }
  getAtPayment(){
    return this.paymentObject;
  }

}
