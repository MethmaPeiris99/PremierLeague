import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {FootballClub} from "./footballClub_interface";
import {Played_Match} from "./played_match_interface"

@Injectable({
  providedIn: 'root'
})
export class PremierLeagueService {

  private _url_sort_by_points:string = "http://localhost:9000/premier-league-table-sorted-by-points";
  private _url_sort_by_score:string = "http://localhost:9000/premier-league-table-sorted-by-scoredgoals";
  private _url_sort_by_win_count:string = "http://localhost:9000/premier-league-table-sorted-by-wincount";
  private _url_sort_by_match_date:string = "http://localhost:9000/premier-league-match-table-sorted-by-matchdate";
  private _url_generate_random_match:string = "http://localhost:9000/premier-league-random-match";
  private _url_search_match:string = "http://localhost:9000/premier-league-search-match";

  constructor(private  http : HttpClient) {}

  getFootballClubsSortedByPoints() : Observable<FootballClub[]>{
    return this.http.get<FootballClub[]>(this._url_sort_by_points);
  }

  getFootballClubsSortedByScore() :Observable<FootballClub[]>{
    return this.http.get<FootballClub[]>(this._url_sort_by_score);
  }

  getFootballClubsSortedByWinCount() :Observable<FootballClub[]>{
    return this.http.get<FootballClub[]>(this._url_sort_by_win_count);
  }

  getMatchesSortedByPoints() : Observable<Played_Match[]>{
    return this.http.get<Played_Match[]>(this._url_sort_by_match_date);
  }

  getGenerateMatch() : Observable<Played_Match[]>{
    return this.http.get<Played_Match[]>(this._url_generate_random_match);
  }

  getSearchMatch(date:any) : Observable<Played_Match[]>{
    return this.http.get<Played_Match[]>(this._url_search_match+"?inputOfDateValue="+date);
  }
}
