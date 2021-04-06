import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserExerciseComponent } from './user-exercise.component';

describe('UserExerciseComponent', () => {
  let component: UserExerciseComponent;
  let fixture: ComponentFixture<UserExerciseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserExerciseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserExerciseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
