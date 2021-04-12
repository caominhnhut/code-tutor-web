import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserBookmarkComponent } from './user-bookmark.component';

describe('UserBookmarkComponent', () => {
  let component: UserBookmarkComponent;
  let fixture: ComponentFixture<UserBookmarkComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserBookmarkComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserBookmarkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
