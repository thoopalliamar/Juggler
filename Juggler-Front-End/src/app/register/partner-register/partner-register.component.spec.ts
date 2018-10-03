import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PartnerRegisterComponent } from './partner-register.component';

describe('PartnerRegisterComponent', () => {
  let component: PartnerRegisterComponent;
  let fixture: ComponentFixture<PartnerRegisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PartnerRegisterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PartnerRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
