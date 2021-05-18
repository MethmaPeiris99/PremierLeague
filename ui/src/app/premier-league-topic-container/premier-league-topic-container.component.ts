import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-premier-league-topic-container',
  templateUrl: './premier-league-topic-container.component.html',
  styleUrls: ['./premier-league-topic-container.component.css']
})
export class PremierLeagueTopicContainerComponent implements OnInit {

  tableTopic:string = "Premier League";

  constructor() { }

  ngOnInit(): void {
  }

}
