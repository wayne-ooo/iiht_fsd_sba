import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisableCourseComponent } from './disable-course.component';

describe('DisableCourseComponent', () => {
  let component: DisableCourseComponent;
  let fixture: ComponentFixture<DisableCourseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisableCourseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisableCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
