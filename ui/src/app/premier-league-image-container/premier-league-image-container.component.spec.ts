import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PremierLeagueImageContainerComponent } from './premier-league-image-container.component';

describe('PremierLeagueImageContainerComponent', () => {
  let component: PremierLeagueImageContainerComponent;
  let fixture: ComponentFixture<PremierLeagueImageContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PremierLeagueImageContainerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PremierLeagueImageContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
