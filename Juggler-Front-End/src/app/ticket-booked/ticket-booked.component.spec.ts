import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketBookedComponent } from './ticket-booked.component';

describe('TicketBookedComponent', () => {
  let component: TicketBookedComponent;
  let fixture: ComponentFixture<TicketBookedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TicketBookedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TicketBookedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
