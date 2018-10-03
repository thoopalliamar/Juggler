import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RSVPEventComponent } from './rsvp-event.component';

describe('RSVPEventComponent', () => {
  let component: RSVPEventComponent;
  let fixture: ComponentFixture<RSVPEventComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RSVPEventComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RSVPEventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
