import { TestBed } from '@angular/core/testing';

import { CarRegisterService } from './car-register.service';

describe('CarRegisterService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CarRegisterService = TestBed.get(CarRegisterService);
    expect(service).toBeTruthy();
  });
});
