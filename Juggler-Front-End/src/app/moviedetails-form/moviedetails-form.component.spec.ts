import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MoviedetailsFormComponent } from './moviedetails-form.component';

describe('MoviedetailsFormComponent', () => {
  let component: MoviedetailsFormComponent;
  let fixture: ComponentFixture<MoviedetailsFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MoviedetailsFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MoviedetailsFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
