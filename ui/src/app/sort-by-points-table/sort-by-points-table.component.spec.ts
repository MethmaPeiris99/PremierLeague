import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortByPointsTableComponent } from './sort-by-points-table.component';

describe('SortByPointsTableComponent', () => {
  let component: SortByPointsTableComponent;
  let fixture: ComponentFixture<SortByPointsTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortByPointsTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SortByPointsTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
