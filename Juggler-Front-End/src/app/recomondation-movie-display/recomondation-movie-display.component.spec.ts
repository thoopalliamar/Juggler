import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecomondationMovieDisplayComponent } from './recomondation-movie-display.component';

describe('RecomondationMovieDisplayComponent', () => {
  let component: RecomondationMovieDisplayComponent;
  let fixture: ComponentFixture<RecomondationMovieDisplayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecomondationMovieDisplayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecomondationMovieDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
