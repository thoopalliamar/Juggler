import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RsvpEventsListComponent } from './rsvp-events-list.component';

describe('RsvpEventsListComponent', () => {
  let component: RsvpEventsListComponent;
  let fixture: ComponentFixture<RsvpEventsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RsvpEventsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RsvpEventsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
