import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RsvpAcceptComponent } from './rsvp-accept.component';

describe('RsvpAcceptComponent', () => {
  let component: RsvpAcceptComponent;
  let fixture: ComponentFixture<RsvpAcceptComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RsvpAcceptComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RsvpAcceptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
