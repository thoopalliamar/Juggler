import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DistributionRegisterFormComponent } from './distribution-registerform.component';

describe('DistributionRegisterFormComponent', () => {
  let component: DistributionRegisterFormComponent;
  let fixture: ComponentFixture<DistributionRegisterFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DistributionRegisterFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DistributionRegisterFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
