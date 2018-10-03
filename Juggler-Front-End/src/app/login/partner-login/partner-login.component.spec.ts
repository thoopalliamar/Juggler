import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PartnerLoginComponent } from './partner-login.component';

describe('PartnerLoginComponent', () => {
  let component: PartnerLoginComponent;
  let fixture: ComponentFixture<PartnerLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PartnerLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PartnerLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
