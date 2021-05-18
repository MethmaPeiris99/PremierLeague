import { Component, OnInit } from '@angular/core';
import {PremierLeagueService} from "../premier-league.service";

@Component({
  selector: 'app-sort-by-wins-table',
  templateUrl: './sort-by-wins-table.component.html',
  styleUrls: ['./sort-by-wins-table.component.css']
})
export class SortByWinsTableComponent implements OnInit {

  public leagueFootballClubs : any =[];
  constructor(private _premierLeagueService : PremierLeagueService) { }

  ngOnInit(): void {
    this._premierLeagueService.getFootballClubsSortedByWinCount()
      .subscribe(data => this.leagueFootballClubs = data);
  }

}
