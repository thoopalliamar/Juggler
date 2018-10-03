import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TheatreRegistrationComponent } from './theatre-registration.component';

describe('TheatreRegistrationComponent', () => {
  let component: TheatreRegistrationComponent;
  let fixture: ComponentFixture<TheatreRegistrationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TheatreRegistrationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TheatreRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
