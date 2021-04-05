import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LessionDetailComponent } from './lession-detail.component';

describe('LessionDetailComponent', () => {
  let component: LessionDetailComponent;
  let fixture: ComponentFixture<LessionDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LessionDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LessionDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
