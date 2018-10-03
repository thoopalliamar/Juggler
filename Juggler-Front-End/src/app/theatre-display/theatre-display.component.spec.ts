import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TheatreDisplayComponent } from './theatre-display.component';

describe('TheatreDisplayComponent', () => {
  let component: TheatreDisplayComponent;
  let fixture: ComponentFixture<TheatreDisplayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TheatreDisplayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TheatreDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
