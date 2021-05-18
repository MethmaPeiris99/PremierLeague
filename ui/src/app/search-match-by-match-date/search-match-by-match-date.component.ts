import { Component, OnInit } from '@angular/core';
import {PremierLeagueService} from "../premier-league.service";

@Component({
  selector: 'app-search-match-by-match-date',
  template: `<h1>-- SEARCH MATCH BY DATE --</h1>
<input #inputMatchDate type="text" placeholder="Enter the date in DD/MM/YYYY format" id="text-search">,
  <button (click)="getMatchDate(inputMatchDate.value)" id="search-button">Search</button>,
  <table id = "table-container">
    <tr>
      <th>First Club</th>
      <th>Second Club</th>
      <th>Match Location</th>
      <th>Match Day</th>
      <th>Match Month</th>
      <th>Match Year</th>
      <th>First Club GS</th>
      <th>Second Club GS</th>
    </tr>
    <tr *ngFor = "let league_match of league_matches">
      <td>{{league_match.playedFootballClub_One.sportsClubName}}</td>
      <td>{{league_match.playedFootballClub_Two.sportsClubName}}</td>
      <td>{{league_match.playedMatchLocation}}</td>
      <td>{{league_match.playedMatchDate.matchDay}}</td>
      <td>{{league_match.playedMatchDate.matchMonth}}</td>
      <td>{{league_match.playedMatchDate.matchYear}}</td>
      <td>{{league_match.numberOfGoalsScoredByFootballClub_One}}</td>
      <td>{{league_match.numberOfGoalsScoredByFootballClub_Two}}</td>
    </tr>
  </table>`,
  styleUrls: ['./search-match-by-match-date.component.css']
})
export class SearchMatchByMatchDateComponent implements OnInit {

  constructor(private _premierLeagueService : PremierLeagueService) { }

  public league_matches : any =[];
  public date:any = "";

  public getMatchDate(dateValue:any){
    this.date = dateValue;
    this._premierLeagueService.getSearchMatch(this.date)
  .subscribe(data => this.league_matches = data);
  }

  ngOnInit(): void {
  }

}
