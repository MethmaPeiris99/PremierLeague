package models.entities;

import java.util.List;
import java.util.ArrayList;

public class PlayedMatchInPremierLeague implements java.io.Serializable{

//---- Instance variables of PlayedMatchInPremierLeague ----//
    private SportsClub playedFootballClub_One;
    private SportsClub playedFootballClub_Two;
    private String playedMatchLocation;
    private MatchDate playedMatchDate;
    private int numberOfGoalsScoredByFootballClub_One;
    private int numberOfGoalsScoredByFootballClub_Two;

    static List<PlayedMatchInPremierLeague> listOfPlayedMatchesInPremierLeague = new ArrayList<>();

//---------------- Getter methods of PlayedMatchInPremierLeague class ----------------//
    public SportsClub getPlayedFootballClub_One(){
        return playedFootballClub_One;
    }

    public SportsClub getPlayedFootballClub_Two(){
        return playedFootballClub_Two;
    }

    public String getPlayedMatchLocation(){
        return playedMatchLocation;
    }

    public MatchDate getPlayedMatchDate(){
        return playedMatchDate;
    }

    public int getNumberOfGoalsScoredByFootballClub_One(){
        return numberOfGoalsScoredByFootballClub_One;
    }

    public int getNumberOfGoalsScoredByFootballClub_Two(){
        return numberOfGoalsScoredByFootballClub_Two;
    }

    public List<PlayedMatchInPremierLeague> getListOfPlayedMatchesInPremierLeague(){
        return listOfPlayedMatchesInPremierLeague;
    }

//---------------- Setter methods of PlayedMatchInPremierLeague class ----------------//
    public void setPlayedFootballClub_One(SportsClub inputOfClub_One){
        this.playedFootballClub_One = inputOfClub_One;
    }

    public void setPlayedFootballClub_Two(SportsClub inputOfClub_Two){
        this.playedFootballClub_Two = inputOfClub_Two;
    }

    public void setPlayedMatchLocation(String inputOfMatchLocation){
        this.playedMatchLocation = inputOfMatchLocation;
    }

    public void setPlayedMatchDate(MatchDate inputOfMatchDate){
        this.playedMatchDate = inputOfMatchDate;
    }

    public void setNumberOfGoalsScoredByFootballClub_One(int inputOfScoredGoalsByClub_One){
        this.numberOfGoalsScoredByFootballClub_One = inputOfScoredGoalsByClub_One;
    }

    public void setNumberOfGoalsScoredByFootballClub_Two(int inputOfScoredGoalsByClub_Two){
        this.numberOfGoalsScoredByFootballClub_Two = inputOfScoredGoalsByClub_Two;
    }

//---------------- equals() method of PlayedMatchInPremierLeague class ----------------//
    public boolean equals(Object objectReference){
        if(this == objectReference){
            return true;
        }
        if(!(objectReference instanceof PlayedMatchInPremierLeague)){
            return false;
        }
        PlayedMatchInPremierLeague playedMatch = (PlayedMatchInPremierLeague) objectReference;
        return (this.playedFootballClub_One == playedMatch.playedFootballClub_One && this.playedFootballClub_Two == playedMatch.playedFootballClub_Two &&
                this.playedMatchLocation.equals(playedMatch.playedMatchLocation) && this.playedMatchDate == playedMatch.playedMatchDate &&
                this.numberOfGoalsScoredByFootballClub_One == playedMatch.numberOfGoalsScoredByFootballClub_One
                && this.numberOfGoalsScoredByFootballClub_Two == playedMatch.numberOfGoalsScoredByFootballClub_Two);
    }

//---------------- hashCode() method of PlayedMatchInPremierLeague class ----------------//
    public int hashCode(){
        /*Returning the values of ids of football clubs, location and date regarding a played match.
         *By invoking this method on instances recognized as similar in equals(),should return same values for
         *ids of football clubs, location and date regarding a played match .*/
        return Integer.parseInt(this.getPlayedFootballClub_One().getSportsClubMembershipId())+Integer.parseInt(",")+
                Integer.parseInt(this.getPlayedFootballClub_Two().getSportsClubMembershipId())+Integer.parseInt(",")+
                Integer.parseInt(this.playedMatchLocation)+Integer.parseInt(",")+Integer.parseInt(this.getPlayedMatchDate().toString());
    }

//---------------- toString() method of PlayedMatchInPremierLeague class ----------------//
    public String toString(){
        return  "\n\nName of the football club 1                :"+playedFootballClub_One.getSportsClubName()+
                "\nName of the football club 2                :"+playedFootballClub_Two.getSportsClubName()+
                "\nLocation of the match                      : "+playedMatchLocation+
                "\n------------- Date of the match -------------"+playedMatchDate+
                "\nNumber of goals scored by Football club 1  : "+numberOfGoalsScoredByFootballClub_One+
                "\nNumber of goals scored by Football club 2  : "+numberOfGoalsScoredByFootballClub_Two;
    }
}

