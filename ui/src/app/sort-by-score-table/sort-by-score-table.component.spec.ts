import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortByScoreTableComponent } from './sort-by-score-table.component';

describe('SortByScoreTableComponent', () => {
  let component: SortByScoreTableComponent;
  let fixture: ComponentFixture<SortByScoreTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortByScoreTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SortByScoreTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
