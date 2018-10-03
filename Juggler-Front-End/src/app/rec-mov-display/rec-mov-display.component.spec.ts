import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecMovDisplayComponent } from './rec-mov-display.component';

describe('RecMovDisplayComponent', () => {
  let component: RecMovDisplayComponent;
  let fixture: ComponentFixture<RecMovDisplayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecMovDisplayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecMovDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
