package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.entities.FootballClub;
import models.entities.MatchDate;
import models.entities.PlayedMatchInPremierLeague;
import models.entities.SportsClub;
import models.manager.*;

import play.mvc.Controller;
import play.mvc.Result;

import services.ComparatorService;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeagueController extends Controller{

    public Result getClubListSortedByPointsAsJson() throws IOException, ClassNotFoundException{
    //----------- Assigning the loaded club list from the saved file to a list -----------//
        List<SportsClub> clubListSortedByPoints = ComparatorService.getComparatorServiceInstance().getLoadedClubList();

    /*Sorting the loaded club list according to the descending order of points as first consideration
      and best goal difference as second consideration*/
        Collections.sort(clubListSortedByPoints,Collections.reverseOrder());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.convertValue(clubListSortedByPoints, JsonNode.class); //Convert the sorted club list into Json type
        return ok(jsonNode); //Generating a 200 OK result
    }

    public Result getClubListSortedByScoredGoals() throws IOException, ClassNotFoundException{
        List<SportsClub> clubListSortedByScoredGoals = ComparatorService.getComparatorServiceInstance().getLoadedClubList();

    //---- Sorting the loaded club list according to the descending order of score count ----//
        Collections.sort(clubListSortedByScoredGoals, new ScoredGoalsComparator().reversed());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.convertValue(clubListSortedByScoredGoals, JsonNode.class);
        return ok(jsonNode);
    }

    public Result getClubListSortedByWinCount() throws IOException, ClassNotFoundException{
        List<SportsClub> clubListSortedByWinCount = ComparatorService.getComparatorServiceInstance().getLoadedClubList();

    //---- Sorting the loaded club list according to the descending order of win count ----//
        Collections.sort(clubListSortedByWinCount, new WinComparator().reversed());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.convertValue(clubListSortedByWinCount, JsonNode.class);
        return ok(jsonNode);
    }

    public Result getMatchListSortedByDate() throws IOException, ClassNotFoundException{
    //----------- Assigning the loaded match list from the saved file to a list -----------//
        List<PlayedMatchInPremierLeague> matchListSortedByDate = ComparatorService.getComparatorServiceInstance().getLoadedMatchList();

    //---- Sorting the loaded match list according to the ascending order of match date ----//
        Collections.sort(matchListSortedByDate, new DateComparator());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.convertValue(matchListSortedByDate, JsonNode.class);
        return ok(jsonNode);
    }

    public Result getGeneratedRandomMatch() throws IOException, ClassNotFoundException{
        List<SportsClub> loadedClubList = ComparatorService.getComparatorServiceInstance().getLoadedClubList();
        List<PlayedMatchInPremierLeague> matchListWithGeneratedMatches = ComparatorService.getComparatorServiceInstance().getLoadedMatchList();

    //Creating an instance of PremierLeagueManager type to access the methods in PremierLeagueManager class//
        LeagueManager premierLeagueManager = new PremierLeagueManager();

        PlayedMatchInPremierLeague generatedPlayedMatchInPremierLeague = new PlayedMatchInPremierLeague();

        int minimumGeneratedIndexValue = 0;
        int maximumGeneratedIndexValue = loadedClubList.size();

    //--------- Generating random numbers to select random clubs from the list ---------//
        int randomIndexOfClubOne = (int) (Math.random()*(maximumGeneratedIndexValue - minimumGeneratedIndexValue+1)+minimumGeneratedIndexValue);
        int randomIndexOfClubTwo = (int) (Math.random()*(maximumGeneratedIndexValue - minimumGeneratedIndexValue+1)+minimumGeneratedIndexValue);

        for(int indexOfClub = 0; indexOfClub<loadedClubList.size(); indexOfClub++){
        /*ASSUMPTION: If the index of the club in the list is equal to the generated value then,
                      that club is selected as a club played in the random match*/
            if(indexOfClub == randomIndexOfClubOne){
                SportsClub sportsClub_One = loadedClubList.get(indexOfClub);
                generatedPlayedMatchInPremierLeague.setPlayedFootballClub_One(sportsClub_One); //Setting the first club in the random match to the match object
            //--- ASSUMPTION: Location of the random played match is always equal to the location of the first club ---//
                generatedPlayedMatchInPremierLeague.setPlayedMatchLocation(sportsClub_One.getSportsClubLocation());
            }
        }
        for(int indexOfClub = 0; indexOfClub<loadedClubList.size(); indexOfClub++){
        //Checking whether the club selected as the first club played in the match is equal to the second club played in the match or not//
            if(indexOfClub == randomIndexOfClubTwo && !(generatedPlayedMatchInPremierLeague.getPlayedFootballClub_One()
                    .getSportsClubName().equals(loadedClubList.get(indexOfClub).getSportsClubName()))){
                SportsClub sportsClub_Two = loadedClubList.get(indexOfClub);
                generatedPlayedMatchInPremierLeague.setPlayedFootballClub_Two(sportsClub_Two); //Setting the second club in the random match to the match object
            }
        }

    //ASSUMPTION: Minimum value of the generated score should be 0 and maximum value should be 16//
        int minimumGeneratedScoreValue = 0;
        int maximumGeneratedScoreValue = 16;

    //-------- Generating random numbers as the scores of the two clubs --------//
        int randomScoreOfClubOne = (int) (Math.random()*(maximumGeneratedScoreValue - minimumGeneratedScoreValue+1)+minimumGeneratedScoreValue);
        int randomScoreOfClubTwo = (int) (Math.random()*(maximumGeneratedScoreValue - minimumGeneratedScoreValue+1)+minimumGeneratedScoreValue);

    //-------- Setting the generated random values as the scores of the two clubs --------//
        generatedPlayedMatchInPremierLeague.setNumberOfGoalsScoredByFootballClub_One(randomScoreOfClubOne);
        generatedPlayedMatchInPremierLeague.setNumberOfGoalsScoredByFootballClub_Two(randomScoreOfClubTwo);

    //ASSUMPTION: Random values are generated to create a random date of the random match object//
        int minimumGeneratedDayValue = 1;
        int maximumGeneratedDayValue = 30;
        int minimumGeneratedMonthValue= 1;
        int maximumGeneratedMonthValue = 12;
        int minimumGeneratedYearValue = 2020;
        int maximumGeneratedYearValue = 2021;

        int randomMatchDay = (int) (Math.random()*(maximumGeneratedDayValue - minimumGeneratedDayValue + 1)+minimumGeneratedDayValue);
        int randomMatchMonth = (int) (Math.random()*(maximumGeneratedMonthValue - minimumGeneratedMonthValue + 1)+minimumGeneratedMonthValue);
        int randomMatchYear = (int) (Math.random()*(maximumGeneratedYearValue - minimumGeneratedYearValue + 1)+minimumGeneratedYearValue);

    //----- Setting the randomly generated date as the match date of the match object -----//
        generatedPlayedMatchInPremierLeague.setPlayedMatchDate(new MatchDate(randomMatchDay,randomMatchMonth,randomMatchYear));

        FootballClub footballClubOne = (FootballClub) generatedPlayedMatchInPremierLeague.getPlayedFootballClub_One();
        FootballClub footballClubTwo =  (FootballClub) generatedPlayedMatchInPremierLeague.getPlayedFootballClub_Two();

    //Setting the number of scored goals, received goals, points, and the goal difference related to the first club in the match//
        footballClubOne.setClubNumberOfGoalsScored(generatedPlayedMatchInPremierLeague.getNumberOfGoalsScoredByFootballClub_One());
        footballClubOne.setClubNumberOfGoalsReceived(generatedPlayedMatchInPremierLeague.getNumberOfGoalsScoredByFootballClub_Two());
        footballClubOne.calculatePointsByMatchStatus(generatedPlayedMatchInPremierLeague.getNumberOfGoalsScoredByFootballClub_One(),
                generatedPlayedMatchInPremierLeague.getNumberOfGoalsScoredByFootballClub_Two());
        footballClubOne.calculateGoalDifferenceAndMatchCount(generatedPlayedMatchInPremierLeague.getNumberOfGoalsScoredByFootballClub_One(),
                generatedPlayedMatchInPremierLeague.getNumberOfGoalsScoredByFootballClub_Two());

    //Setting the number of scored goals, received goals, points, and the goal difference related to the second club in the match//
        footballClubTwo.setClubNumberOfGoalsScored(generatedPlayedMatchInPremierLeague.getNumberOfGoalsScoredByFootballClub_Two());
        footballClubTwo.setClubNumberOfGoalsReceived(generatedPlayedMatchInPremierLeague.getNumberOfGoalsScoredByFootballClub_One());
        footballClubTwo.calculatePointsByMatchStatus(generatedPlayedMatchInPremierLeague.getNumberOfGoalsScoredByFootballClub_Two(),
                generatedPlayedMatchInPremierLeague.getNumberOfGoalsScoredByFootballClub_One());
        footballClubTwo.calculateGoalDifferenceAndMatchCount(generatedPlayedMatchInPremierLeague.getNumberOfGoalsScoredByFootballClub_Two(),
                generatedPlayedMatchInPremierLeague.getNumberOfGoalsScoredByFootballClub_One());

        System.out.println("RANDOM MATCH HAS BEEN GENERATED SUCCESSFULLY !");
        System.out.println(generatedPlayedMatchInPremierLeague);
        matchListWithGeneratedMatches.add(generatedPlayedMatchInPremierLeague);

        File premierLeagueClubDataFile = new File("premierLeague_ClubData.txt");
        premierLeagueManager.saveAllPremierLeagueClubDataAdded(premierLeagueClubDataFile,loadedClubList); //Saving the club data

        File premierLeagueMatchDataFile = new File("premierLeague_MatchData.txt");
        premierLeagueManager.saveAllPremierLeagueMatchDataAdded(premierLeagueMatchDataFile,matchListWithGeneratedMatches); //Saving the match data

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.convertValue(matchListWithGeneratedMatches, JsonNode.class);
        return ok(jsonNode);
    }

    public Result getSearchedMatch(String inputOfDateValue) throws IOException, ClassNotFoundException{
        List<PlayedMatchInPremierLeague> loadMatchList = ComparatorService.getComparatorServiceInstance().getLoadedMatchList();
        List<PlayedMatchInPremierLeague> searchMatchResult = new ArrayList<>(); //Creating an array to add the searched results

        for (PlayedMatchInPremierLeague playedMatchInPremierLeague : loadMatchList){
            if (playedMatchInPremierLeague.getPlayedMatchDate().displayPlayedMatch().equals(inputOfDateValue)){
                searchMatchResult.add(playedMatchInPremierLeague);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.convertValue(searchMatchResult, JsonNode.class);
        return ok(jsonNode);
    }
}
