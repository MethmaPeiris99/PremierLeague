import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortByWinsTableComponent } from './sort-by-wins-table.component';

describe('SortByWinsTableComponent', () => {
  let component: SortByWinsTableComponent;
  let fixture: ComponentFixture<SortByWinsTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortByWinsTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SortByWinsTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
