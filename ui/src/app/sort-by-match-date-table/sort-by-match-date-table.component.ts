import { Component, OnInit } from '@angular/core';
import {PremierLeagueService} from "../premier-league.service";

@Component({
  selector: 'app-sort-by-match-date-table',
  templateUrl: './sort-by-match-date-table.component.html',
  styleUrls: ['./sort-by-match-date-table.component.css']
})
export class SortByMatchDateTableComponent implements OnInit {

  public league_matches : any = [];
  constructor(private _premierLeagueService : PremierLeagueService) { }

  ngOnInit(): void {
    this._premierLeagueService.getMatchesSortedByPoints()
      .subscribe(data => this.league_matches = data);
  }

}
