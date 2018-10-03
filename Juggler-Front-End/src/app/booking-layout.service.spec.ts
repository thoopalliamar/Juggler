import { TestBed, inject } from '@angular/core/testing';

import { BookingLayoutService } from './booking-layout.service';

describe('BookingLayoutService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BookingLayoutService]
    });
  });

  it('should be created', inject([BookingLayoutService], (service: BookingLayoutService) => {
    expect(service).toBeTruthy();
  }));
});
