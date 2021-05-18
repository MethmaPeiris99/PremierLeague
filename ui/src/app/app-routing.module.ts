import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SortByPointsTableComponent} from "./sort-by-points-table/sort-by-points-table.component";
import {GenerateRandomMatchComponent} from "./generate-random-match/generate-random-match.component";
import {SortByScoreTableComponent} from "./sort-by-score-table/sort-by-score-table.component";
import {SortByWinsTableComponent} from "./sort-by-wins-table/sort-by-wins-table.component";
import {SortByMatchDateTableComponent} from "./sort-by-match-date-table/sort-by-match-date-table.component";
import {PremierLeagueImageContainerComponent} from "./premier-league-image-container/premier-league-image-container.component";
import {SearchMatchByMatchDateComponent} from "./search-match-by-match-date/search-match-by-match-date.component";

const routes: Routes = [
  {path: '', component:PremierLeagueImageContainerComponent},
  {path: 'generate_random_match', component:GenerateRandomMatchComponent},
  {path: 'premier-league-table-sorted-by-points', component:SortByPointsTableComponent},
  {path: 'premier-league-table-sorted-by-scoredgoals', component:SortByScoreTableComponent},
  {path: 'premier-league-table-sorted-by-wincount', component:SortByWinsTableComponent},
  {path: 'premier-league-match-table-sorted-by-matchdate', component:SortByMatchDateTableComponent},
  {path: 'premier-league-search-match', component:SearchMatchByMatchDateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const allRoutingComponents = [SortByPointsTableComponent,GenerateRandomMatchComponent,SortByScoreTableComponent,
                                     SortByWinsTableComponent,SortByMatchDateTableComponent,SearchMatchByMatchDateComponent]
