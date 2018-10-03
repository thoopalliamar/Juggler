import { Component, OnInit } from '@angular/core';
import { FullBookingDetails } from '../FullBookingDetails';
import { LayoutToBillingService } from '../layout-to-billing.service';

@Component({
 selector: 'app-ticket-booked',
 templateUrl: './ticket-booked.component.html',
 styleUrls: ['./ticket-booked.component.scss']
})
export class TicketBookedComponent implements OnInit {
 bookingDetails: FullBookingDetails;
 constructor(private layouttobilling: LayoutToBillingService) {  }

 ngOnInit() {

   this.bookingDetails = this.layouttobilling.getAtBilling();
   console.log(this.bookingDetails.nameOfMovie + "anmisha");

 }

}