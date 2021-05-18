import { Component, OnInit } from '@angular/core';
import {PremierLeagueService} from "../premier-league.service";

@Component({
  selector: 'app-sort-by-points-table',
  templateUrl: './sort-by-points-table.component.html',
  styleUrls: ['./sort-by-points-table.component.css']
})
export class SortByPointsTableComponent implements OnInit {

  public leagueFootballClubs : any =[];
  constructor(private _premierLeagueService : PremierLeagueService) { }

  ngOnInit(): void {
    this._premierLeagueService.getFootballClubsSortedByPoints()
      .subscribe(data => this.leagueFootballClubs = data);
  }

}
