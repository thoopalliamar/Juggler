import { TestBed, inject } from '@angular/core/testing';

import { SharingDataService } from './sharing-data.service';

describe('SharingDataService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SharingDataService]
    });
  });

  it('should be created', inject([SharingDataService], (service: SharingDataService) => {
    expect(service).toBeTruthy();
  }));
});
