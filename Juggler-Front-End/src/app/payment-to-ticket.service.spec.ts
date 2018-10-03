import { TestBed, inject } from '@angular/core/testing';

import { PaymentToTicketService } from './payment-to-ticket.service';

describe('PaymentToTicketService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PaymentToTicketService]
    });
  });

  it('should be created', inject([PaymentToTicketService], (service: PaymentToTicketService) => {
    expect(service).toBeTruthy();
  }));
});
