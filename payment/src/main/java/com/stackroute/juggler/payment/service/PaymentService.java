package com.stackroute.juggler.payment.service;

import com.stackroute.juggler.kafka.domain.TicketDetails;
import com.stripe.exception.CardException;
import com.stripe.model.Charge;
import com.stripe.model.Refund;

public interface PaymentService {
	
	public Charge chargeNewCard(String token, double amount)throws CardException;
	
	public Refund cardRefund() throws Exception;
	
	public TicketDetails saveTicket(TicketDetails ticket);
	
	public TicketDetails addTicket(TicketDetails ticketDetails);
	
	public TicketDetails getTicket(String email);

}
