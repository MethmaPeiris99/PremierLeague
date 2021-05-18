import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PremierLeagueTopicContainerComponent } from './premier-league-topic-container.component';

describe('PremierLeagueTopicContainerComponent', () => {
  let component: PremierLeagueTopicContainerComponent;
  let fixture: ComponentFixture<PremierLeagueTopicContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PremierLeagueTopicContainerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PremierLeagueTopicContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
