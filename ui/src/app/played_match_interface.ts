export interface Played_Match{
  playedFootballClub_One: {
    sportsClubName: string,
    sportsClubLocation: string,
    sportsClubMembershipId : string,
    footballClubNumberOfWins : number,
    footballClubNumberOfDraws : number,
    footballClubNumberOfDefeats : number,
    footballClubNumberOfGoalsReceived : number,
    footballClubNumberOfGoalsScored : number,
    footballClubNumberOfPoints : number,
    footballClubNumberOfMatchesPlayed : number,
    footballClubGoalDifference : number
  },
  playedFootballClub_Two : {
    sportsClubName : string,
    sportsClubLocation : string,
    sportsClubMembershipId : string,
    footballClubNumberOfWins : number,
    footballClubNumberOfDraws : number,
    footballClubNumberOfDefeats : number,
    footballClubNumberOfGoalsReceived : number,
    footballClubNumberOfGoalsScored : number,
    footballClubNumberOfPoints : number,
    footballClubNumberOfMatchesPlayed : number,
    footballClubGoalDifference : number
  },
  playedMatchLocation : string,
  playedMatchDate: {
    matchDay: number,
    matchMonth : number,
    matchYear : number
  },
  numberOfGoalsScoredByFootballClub_One : number,
  numberOfGoalsScoredByFootballClub_Two : number,
  listOfPlayedMatchesInPremierLeague : []
}
