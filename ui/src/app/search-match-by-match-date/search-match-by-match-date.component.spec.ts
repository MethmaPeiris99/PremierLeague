import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchMatchByMatchDateComponent } from './search-match-by-match-date.component';

describe('SearchMatchByMatchDateComponent', () => {
  let component: SearchMatchByMatchDateComponent;
  let fixture: ComponentFixture<SearchMatchByMatchDateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchMatchByMatchDateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchMatchByMatchDateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
