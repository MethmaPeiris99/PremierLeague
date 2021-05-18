package models.manager;

import models.entities.FootballClub;
import models.entities.PlayedMatchInPremierLeague;
import models.entities.SportsClub;

import java.io.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PremierLeagueManager implements LeagueManager,java.io.Serializable{

    static List <SportsClub> premierLeagueClubList = new ArrayList<>(); //Creating an array list to store SportsClub type objects
    public static final int MAX_NUMBER_OF_CLUBS_IN_PREMIER_LEAGUE = 20; //Number of football clubs that can be played in the premier league during a season
    private int numberOfAvailableSlotsForClubs = 20; //Number of available slots which football clubs can be added

//------- PlayedMatchInPremierLeague type object created to access the methods in that class -------//
    PlayedMatchInPremierLeague playedMatchInPremierLeague = new PlayedMatchInPremierLeague();

//----------------- Method used to display the functions of the Premier League system -----------------//
    @Override
    public void displayChoiceMenu(){
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("              M E N U   O F   P R E M I E R   L E A G U E - 20/21                 ");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("| ENTER A  :  ADD A FOOTBALL CLUB TO THE PREMIER LEAGUE                          |");
        System.out.println("| ENTER R  :  RELEGATE A FOOTBALL CLUB FROM THE PREMIER LEAGUE                   |");
        System.out.println("| ENTER D  :  DISPLAY STATISTICS FOR A SELECTED FOOTBALL CLUB IN PREMIER LEAGUE  |");
        System.out.println("| ENTER P  :  DISPLAY THE PREMIER LEAGUE TABLE                                   |");
        System.out.println("| ENTER M  :  ADD A PLAYED MATCH IN PREMIER LEAGUE                               |");
        System.out.println("| ENTER G  :  OPEN THE GUI OF PREMIER LEAGUE                                     |");
        System.out.println("| ENTER Q  :  QUIT THE SYSTEM                                                    |");
        System.out.println("----------------------------------------------------------------------------------");
    }

//--------- Method used to add a football club to the premier league based on user inputs ---------//
    @Override
    public void addFootballClubsToPremierLeague(SportsClub footballClubNeededToAdd){
        premierLeagueClubList.add(footballClubNeededToAdd); //Adding the relevant football club to the club list

    //----------- Displaying the information relevant to the football club which added to the list -----------//
        System.out.println();
        System.out.println(footballClubNeededToAdd.getSportsClubName() + " FOOTBALL CLUB HAS BEEN SUCCESSFULLY ADDED TO THE PREMIER LEAGUE !");
        System.out.println(footballClubNeededToAdd.toString());

        numberOfAvailableSlotsForClubs = MAX_NUMBER_OF_CLUBS_IN_PREMIER_LEAGUE-premierLeagueClubList.size(); //Removing one slot because of adding a football club to the list
        System.out.println();
        System.out.println("NUMBER OF AVAILABLE SLOTS IN THE PREMIER LEAGUE: " + numberOfAvailableSlotsForClubs);
    }

//------ Method used to relegate a football club from the premier league based on its id entered by the user ------//
    @Override
    public void relegateFootballClubsFromPremierLeague(SportsClub footballClubNeededToRelegate){

    //----------- Displaying the information relevant to the football club which needs to be relegated -----------//
        System.out.println();
        System.out.println(footballClubNeededToRelegate.getSportsClubName()+" FOOTBALL CLUB HAS BEEN RELEGATED FROM THE PREMIER LEAGUE !");
        System.out.println(footballClubNeededToRelegate.toString());

        premierLeagueClubList.remove(footballClubNeededToRelegate); //Removing the relevant football club from list

        numberOfAvailableSlotsForClubs = MAX_NUMBER_OF_CLUBS_IN_PREMIER_LEAGUE-premierLeagueClubList.size()+1; //Adding one slot because of removing a football club from the list
        System.out.println();
        System.out.println("NUMBER OF AVAILABLE SLOTS IN THE PREMIER LEAGUE: " + numberOfAvailableSlotsForClubs);
    }

//-------- Method used to display the statistics of a football club based on its id entered by the user --------//
    @Override
    public void displayStatisticsOfSelectedFootballClub(SportsClub footballClubNeededToDisplayStats){
    //Down casting SportsClub type to FootballClub type to get the access to the methods in FootballClub class//
        FootballClub footballClub = (FootballClub) footballClubNeededToDisplayStats;

    //------------------------- Displaying the statistics of the relevant football club -------------------------//
        System.out.println();
        System.out.println("||----------- STATISTICS OF "+footballClub.getSportsClubName()+" CLUB -----------||");
        System.out.println("NUMBER OF WINS ACHIEVED BY THE FOOTBALL CLUB    : " + footballClub.getFootballClubNumberOfWins());
        System.out.println("NUMBER OF DRAWS RELEVANT TO THE FOOTBALL CLUB   : " + footballClub.getFootballClubNumberOfDraws());
        System.out.println("NUMBER OF DEFEATS RELEVANT TO THE FOOTBALL CLUB : " + footballClub.getFootballClubNumberOfDefeats());
        System.out.println("NUMBER OF GOALS RECEIVED BY THE FOOTBALL CLUB   : " + footballClub.getFootballClubNumberOfGoalsReceived());
        System.out.println("NUMBER OF GOALS SCORED BY THE FOOTBALL CLUB     : " + footballClub.getFootballClubNumberOfGoalsScored());
        System.out.println("NUMBER OF POINTS ACHIEVED BY THE FOOTBALL CLUB  : " + footballClub.getFootballClubNumberOfPoints());
        System.out.println("GOAL DIFFERENCE OF THE FOOTBALL CLUB            : "+footballClub.getFootballClubGoalDifference());
        System.out.println("NUMBER OF MATCHES PLAYED BY THE FOOTBALL CLUB   : " + footballClub.getFootballClubNumberOfMatchesPlayed());
    }

/*Method used to display all the clubs and its statistics in descending order of points as first consideration
  and best goal difference as second consideration*/
    @Override
    public void displayPremierLeagueTable(){
        System.out.println("------------------------------ PREMIER LEAGUE TABLE ------------------------------");
        Collections.sort(premierLeagueClubList,Collections.reverseOrder()); //Sorting the list in descending order of points; if not goal difference
        System.out.println(premierLeagueClubList);
        System.out.println("----------------------------------------------------------------------------------");
    }

//--- Method used to add a played match into the match list based on the user inputs and updating the statistics accordingly ---//
    @Override
    public void addPlayedMatchInPremierLeague(PlayedMatchInPremierLeague inputOfPlayedMatchInPremierLeague) {
        System.out.println(inputOfPlayedMatchInPremierLeague); //Displaying the details related to the added match

        FootballClub footballClub_One = (FootballClub) inputOfPlayedMatchInPremierLeague.getPlayedFootballClub_One();

   //--- Setting the points, number of sored goals, received goals and the goal difference related to the first club in the match ---//
        footballClub_One.calculatePointsByMatchStatus(inputOfPlayedMatchInPremierLeague.getNumberOfGoalsScoredByFootballClub_One(),
                inputOfPlayedMatchInPremierLeague.getNumberOfGoalsScoredByFootballClub_Two());
        footballClub_One.setClubNumberOfGoalsScored(inputOfPlayedMatchInPremierLeague.getNumberOfGoalsScoredByFootballClub_One());
        footballClub_One.setClubNumberOfGoalsReceived(inputOfPlayedMatchInPremierLeague.getNumberOfGoalsScoredByFootballClub_Two());
        footballClub_One.calculateGoalDifferenceAndMatchCount(footballClub_One.getFootballClubNumberOfGoalsScored(),footballClub_One.getFootballClubNumberOfGoalsReceived());

        FootballClub footballClub_Two = (FootballClub) inputOfPlayedMatchInPremierLeague.getPlayedFootballClub_Two();

    //--- Setting the points, number of scored goals, received goals and the goal difference related to the second club in the match ---//
        footballClub_Two.calculatePointsByMatchStatus(inputOfPlayedMatchInPremierLeague.getNumberOfGoalsScoredByFootballClub_Two(),
                inputOfPlayedMatchInPremierLeague.getNumberOfGoalsScoredByFootballClub_One());
        footballClub_Two.setClubNumberOfGoalsScored(inputOfPlayedMatchInPremierLeague.getNumberOfGoalsScoredByFootballClub_Two());
        footballClub_Two.setClubNumberOfGoalsReceived(inputOfPlayedMatchInPremierLeague.getNumberOfGoalsScoredByFootballClub_One());
        footballClub_Two.calculateGoalDifferenceAndMatchCount(footballClub_Two.getFootballClubNumberOfGoalsScored(), footballClub_Two.getFootballClubNumberOfGoalsReceived());

        playedMatchInPremierLeague.getListOfPlayedMatchesInPremierLeague().add(inputOfPlayedMatchInPremierLeague); //Adding the played match to the match list
    }

//---------- Method used to save all the club data into the file used to save club data ----------//
    @Override
    public void saveAllPremierLeagueClubDataAdded(File inputOfFileName, List<SportsClub> inputOfClubsInPremierLeague) throws IOException {
        try {
            if (checkAvailabilityInPremierLeague(inputOfClubsInPremierLeague)) {
                FileOutputStream fileOutputStream = new FileOutputStream(inputOfFileName); //Used to write byte-oriented data to a file
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream); //Used to write serializable objects to a file

                for (SportsClub sportsClub : inputOfClubsInPremierLeague) {
                    objectOutputStream.writeObject(sportsClub);
                }
                objectOutputStream.flush(); //Flushing the current object output stream
                fileOutputStream.close(); //Closing the current file output stream
                objectOutputStream.close(); //Closing the current object output stream

                System.out.println("PREMIER LEAGUE FOOTBALL CLUB DATA HAS BEEN SAVED SUCCESSFULLY !");
            }
        }
        catch(NullPointerException nullPointerException){
            System.out.println("PREMIER LEAGUE HAS NO ADDED FOOTBALL CLUBS !");
        }
    }

//---------- Method used to save all the match data into the file used to save match data ----------//
    @Override
    public void saveAllPremierLeagueMatchDataAdded(File inputOfFileName, List<PlayedMatchInPremierLeague> inputOfPlayedMatchInPremierLeague) throws IOException {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(inputOfFileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for (PlayedMatchInPremierLeague playedMatchInPremierLeague : inputOfPlayedMatchInPremierLeague) {
                objectOutputStream.writeObject(playedMatchInPremierLeague);
            }
            objectOutputStream.flush();
            fileOutputStream.close();
            objectOutputStream.close();

            System.out.println("PREMIER LEAGUE MATCH DATA HAS BEEN SAVED SUCCESSFULLY !");
        }
        catch(NullPointerException nullPointerException){
           System.out.println("PREMIER LEAGUE HAS NO ADDED PLAYED MATCHES !");
       }
    }

//------ Method used to load club data from the file used to save club data to the club list ------//
    @Override
    public void loadAllPremierLeagueClubDataAdded(File inputOfFileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(inputOfFileName); //Used to read byte-oriented data from a file
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream); //Deserializing the objects which wrote to a file using the object output stream

        for(;;){
            try{
                SportsClub sportsClub = (SportsClub) objectInputStream.readObject();
                premierLeagueClubList.add(sportsClub);
            }
            catch (EOFException eofException){
                break;
            }
        }
        fileInputStream.close();
        objectInputStream.close();

        if(checkAvailabilityInPremierLeague(premierLeagueClubList)) {
            System.out.println("PREMIER LEAGUE FOOTBALL CLUB DATA HAS BEEN LOADED SUCCESSFULLY !");
            System.out.println(premierLeagueClubList);
        }
    }

//------ Method used to load match data from the file used to save match data to the match list ------//
    @Override
    public void loadAllPremierLeagueMatchDataAdded(File inputOfFileName) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(inputOfFileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        for(;;){
            try{
                PlayedMatchInPremierLeague playedMatchInPremierLeague = (PlayedMatchInPremierLeague) objectInputStream.readObject();
                playedMatchInPremierLeague.getListOfPlayedMatchesInPremierLeague().add(playedMatchInPremierLeague);
            }
            catch (EOFException eofException){
                break;
            }
        }
        fileInputStream.close();
        objectInputStream.close();

        if(!playedMatchInPremierLeague.getListOfPlayedMatchesInPremierLeague().isEmpty()) {
            System.out.println();
            System.out.println("PREMIER LEAGUE MATCH DATA HAS BEEN LOADED SUCCESSFULLY !");
            System.out.println(playedMatchInPremierLeague.getListOfPlayedMatchesInPremierLeague());
        }
    }
}
