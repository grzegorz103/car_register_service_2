import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarRegisterListComponent } from './car-register-list.component';

describe('CarRegisterListComponent', () => {
  let component: CarRegisterListComponent;
  let fixture: ComponentFixture<CarRegisterListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarRegisterListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarRegisterListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
