import { Component, OnInit } from '@angular/core';
import {PremierLeagueService} from "../premier-league.service";

@Component({
  selector: 'app-generate-random-match',
  template: `
    <h1>-- TABLE OF GENERATED RANDOM MATCHES --</h1>
  <button (click)="generateMatch()" id="random-button">CLICK TO GENERATE A RANDOM MATCH</button>
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
  styleUrls: ['./generate-random-match.component.css']
})
export class GenerateRandomMatchComponent implements OnInit {

  public league_matches : any = [];

  constructor(private _premierLeagueService : PremierLeagueService) { }

  ngOnInit(){
  }
  public generateMatch(){
    this._premierLeagueService.getGenerateMatch()
      .subscribe(data => this.league_matches = data);
  }

}
