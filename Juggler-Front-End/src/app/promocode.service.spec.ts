import { TestBed, inject } from '@angular/core/testing';

import { PromocodeService } from './promocode.service';

describe('PromocodeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PromocodeService]
    });
  });

  it('should be created', inject([PromocodeService], (service: PromocodeService) => {
    expect(service).toBeTruthy();
  }));
});
