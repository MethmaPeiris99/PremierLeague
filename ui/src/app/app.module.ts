import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {allRoutingComponents, AppRoutingModule} from './app-routing.module';
import { AppComponent } from './app.component';
import { PremierLeagueTopicContainerComponent } from './premier-league-topic-container/premier-league-topic-container.component';
import { PremierLeagueImageContainerComponent } from './premier-league-image-container/premier-league-image-container.component';
import { GenerateRandomMatchComponent } from './generate-random-match/generate-random-match.component';
import { SortByPointsTableComponent } from './sort-by-points-table/sort-by-points-table.component';
import { SortByMatchDateTableComponent } from './sort-by-match-date-table/sort-by-match-date-table.component';
import { SortByScoreTableComponent } from './sort-by-score-table/sort-by-score-table.component';
import { SortByWinsTableComponent } from './sort-by-wins-table/sort-by-wins-table.component';
import { SearchMatchByMatchDateComponent } from './search-match-by-match-date/search-match-by-match-date.component';
import {HttpClientModule} from "@angular/common/http";
import {PremierLeagueService} from "./premier-league.service";


@NgModule({
  declarations: [
    AppComponent,
    PremierLeagueTopicContainerComponent,
    PremierLeagueImageContainerComponent,
    GenerateRandomMatchComponent,
    SortByPointsTableComponent,
    SortByMatchDateTableComponent,
    SortByScoreTableComponent,
    SortByWinsTableComponent,
    SearchMatchByMatchDateComponent,
    allRoutingComponents
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [PremierLeagueService],
  bootstrap: [AppComponent]
})
export class AppModule { }
