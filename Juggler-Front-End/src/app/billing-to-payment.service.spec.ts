import { TestBed, inject } from '@angular/core/testing';

import { BillingToPaymentService } from './billing-to-payment.service';

describe('BillingToPaymentService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BillingToPaymentService]
    });
  });

  it('should be created', inject([BillingToPaymentService], (service: BillingToPaymentService) => {
    expect(service).toBeTruthy();
  }));
});
