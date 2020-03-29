import { TestBed } from '@angular/core/testing';

import { SeatDataService } from './seat-data.service';

describe('SeatDataService', () => {
  let service: SeatDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SeatDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
