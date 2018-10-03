import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecommondationThetareDisplayComponent } from './recommondation-thetare-display.component';

describe('RecommondationThetareDisplayComponent', () => {
  let component: RecommondationThetareDisplayComponent;
  let fixture: ComponentFixture<RecommondationThetareDisplayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecommondationThetareDisplayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecommondationThetareDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
