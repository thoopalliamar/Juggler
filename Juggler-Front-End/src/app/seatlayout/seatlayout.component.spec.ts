import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeatlayoutComponent } from './seatlayout.component';

describe('SeatlayoutComponent', () => {
  let component: SeatlayoutComponent;
  let fixture: ComponentFixture<SeatlayoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeatlayoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeatlayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});


