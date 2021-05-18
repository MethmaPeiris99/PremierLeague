import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortByMatchDateTableComponent } from './sort-by-match-date-table.component';

describe('SortByMatchDateTableComponent', () => {
  let component: SortByMatchDateTableComponent;
  let fixture: ComponentFixture<SortByMatchDateTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortByMatchDateTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SortByMatchDateTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
