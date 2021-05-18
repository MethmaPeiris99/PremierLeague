import { Component, OnInit } from '@angular/core';
import {PremierLeagueService} from "../premier-league.service";

@Component({
  selector: 'app-sort-by-score-table',
  templateUrl: './sort-by-score-table.component.html',
  styleUrls: ['./sort-by-score-table.component.css']
})
export class SortByScoreTableComponent implements OnInit {

  public leagueFootballClubs : any =[];
  constructor(private _premierLeagueService : PremierLeagueService) { }

  ngOnInit(): void {
    this._premierLeagueService.getFootballClubsSortedByScore()
      .subscribe(data => this.leagueFootballClubs = data);
  }

}
