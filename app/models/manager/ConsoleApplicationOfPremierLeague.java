package models.manager;

import models.entities.FootballClub;
import models.entities.MatchDate;
import models.entities.PlayedMatchInPremierLeague;
import models.entities.SportsClub;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.InputMismatchException;

import java.util.Scanner;

public class ConsoleApplicationOfPremierLeague{

    static LeagueManager managerOfPremierLeague = new PremierLeagueManager(); /*PremierLeagueManager type object created
                                                                                to access the methods in PremierLeagueManager class*/

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        File premierLeagueClubDataFile = new File("premierLeague_ClubData.txt"); //File created to store data of clubs in premier league
        File premierLeagueMatchDataFile = new File("premierLeague_MatchData.txt"); //File created to store data of played matches

        try{
        //Checking whether both created data files exists in the system and checking its content null or not before loading data//
            if(premierLeagueClubDataFile.exists() && premierLeagueClubDataFile.length() != 0){
                managerOfPremierLeague.loadAllPremierLeagueClubDataAdded(premierLeagueClubDataFile);
            }
            if(premierLeagueMatchDataFile.exists() && premierLeagueMatchDataFile.length() != 0){
                managerOfPremierLeague.loadAllPremierLeagueMatchDataAdded(premierLeagueMatchDataFile);
            }
        }
        catch(FileNotFoundException | NullPointerException exception){
            if(!premierLeagueClubDataFile.exists()){
                System.out.println("PREMIER LEAGUE CLUB DATA FILE CANNOT BE FOUND !");
            }
            if(!premierLeagueMatchDataFile.exists()){
                System.out.println("PLAYED MATCHES IN PREMIER LEAGUE DATA FILE CANNOT BE FOUND !");
            }
        }

        Scanner userInputMain = new Scanner(System.in); /*Scanner type object created to access the methods in Scanner class;
                                                          inputs are received from the standard input, keyboard */

        while(true){
        //------- PlayedMatchInPremierLeague type object created to access the methods in that class -------//
            PlayedMatchInPremierLeague playedMatchInPremierLeague = new PlayedMatchInPremierLeague();

            managerOfPremierLeague.displayChoiceMenu();

            System.out.print("ENTER CHOICE: ");
            String userChoice = userInputMain.nextLine().toUpperCase().replaceAll("\\s",""); /*Getting the input from the user in UPPER CASE,
                                                                                                               replaceAll() will remove all the white spaces in the input*/

            if(userChoice.matches("[A-Z]*")){ //Checking whether the input is in the character range of A-Z or not
                switch(userChoice){
                    case "A":
                        addFootballClub();
                        break;
                    case "R":
                        relegateFootballClub();
                        break;
                    case "D":
                        displayStatistics();
                        break;
                    case "P":
                        managerOfPremierLeague.displayPremierLeagueTable();
                        break;
                    case "M":
                        addPlayedMatch();
                        break;
                    case "G":
                        String urlOfAngularGUI = "http://localhost:4200";
                        try{
                            java.awt.Desktop.getDesktop().browse(URI.create(urlOfAngularGUI));
                            System.out.println("GUI HAS BEEN LOADED SUCCESSFULLY !");
                        }
                        catch(Exception exception){
                            System.out.println("SOMETHING WENT WRONG WITH THE EXECUTION OF THE GUI !");
                        }
                        break;
                    case "Q":
                        System.out.println("THANK YOU FOR USING THE PREMIER LEAGUE SYSTEM, HAVE A NICE DAY! ");
                        managerOfPremierLeague.saveAllPremierLeagueClubDataAdded(premierLeagueClubDataFile,PremierLeagueManager.premierLeagueClubList);
                        managerOfPremierLeague.saveAllPremierLeagueMatchDataAdded(premierLeagueMatchDataFile,playedMatchInPremierLeague.getListOfPlayedMatchesInPremierLeague());

                        System.exit(0); //Indicates successful termination of the system
                    default:
                        System.out.println("SORRY, ONLY 'A','R','D','P','M','G','Q' ARE EXPECTED ! ENTER AGAIN.");
                }
            }
            else{
                System.out.println("INVALID INPUT TYPE ! ONLY 'A','R','D','P','M','G','Q' ARE EXPECTED ! ENTER AGAIN.");
            }
        }
    }

//---- Method used to get data from the user relevant to a football club to be add to the premier league ----//
    private static void addFootballClub(){
    //------------------ Checking whether the premier league is already out of space with clubs or not ------------------//
        if(PremierLeagueManager.premierLeagueClubList.size() < PremierLeagueManager.MAX_NUMBER_OF_CLUBS_IN_PREMIER_LEAGUE){
            Scanner userInputAdd = new Scanner(System.in);

        //------------------- Getting inputs from a user relevant to a football club -------------------//
            while(true){
                String commonToLeagueId = "pl2021"; //ASSUMPTION: String part which is common to all football club ids
                System.out.print("ENTER THE MEMBERSHIP ID OF THE FOOTBALL CLUB (Should contain 4 integer values): ");
                String inputOfMembershipId = userInputAdd.nextLine().replaceAll("\\s", "");
                boolean idPattern = inputOfMembershipId.matches("[0-9]*"); //Checking whether the input is in the character range of "0"-"9"

            //-------- Checking the id is in the correct range and its length has the expected size or not --------//
                if(idPattern && inputOfMembershipId.length() == 4){
                    inputOfMembershipId = commonToLeagueId + inputOfMembershipId; //Concatenating the common String value of the id and user input

                    boolean foundClubId = false;
                    for(int indexOfClub = 0; indexOfClub < PremierLeagueManager.premierLeagueClubList.size(); indexOfClub++){

                    //----------- Checking whether the object needed to add already exist or not in the premier league by considering the membership id -----------//
                        if(PremierLeagueManager.premierLeagueClubList.get(indexOfClub).getSportsClubMembershipId().equals(inputOfMembershipId)){
                            foundClubId = true;
                            System.out.println("SORRY, THIS FOOTBALL CLUB ALREADY EXIST IN THE PREMIER LEAGUE !");
                            break;
                        }
                    }
                    if(!foundClubId){
                        while(true){
                            System.out.print("ENTER THE NAME OF THE FOOTBALL CLUB: ");
                            String inputOfClubName = userInputAdd.nextLine().toLowerCase().replaceAll("\\s", ""); /*Getting the input from the user in lower case
                                                                                                                                     and removing all the white spaces using replaceAll()*/
                        //Checking whether the input is in the character range of a-z or not and the input contains at least one character or not//
                            if(inputOfClubName.matches("[a-z]*") && inputOfClubName.length() != 0){
                                boolean foundClubName = false;

                                for(SportsClub sportsClub : PremierLeagueManager.premierLeagueClubList){
                                //Checking whether there's a club with the same name as the entered club name or not//
                                    if(sportsClub.getSportsClubName().equals(inputOfClubName)){
                                        foundClubName = true;
                                        System.out.println("ENTERED NAME CANNOT BE ACCEPTED !");
                                        break;
                                    }
                                }
                                if(!foundClubName){
                                    while(true){
                                        System.out.print("ENTER THE LOCATION OF THE FOOTBALL CLUB: ");
                                        String inputOfClubLocation = userInputAdd.nextLine().toLowerCase().replaceAll("\\s", "");
                                        if(inputOfClubLocation.matches("[a-z]*") && inputOfClubLocation.length() != 0){

                                        //------------------------- Creating a football club based on the user inputs -------------------------//
                                            SportsClub footballClub = new FootballClub(inputOfClubName, inputOfClubLocation, inputOfMembershipId);

                                            managerOfPremierLeague.addFootballClubsToPremierLeague(footballClub);
                                            break;
                                        } else {
                                            System.out.println("INVALID INPUT TYPE OF THE CLUB LOCATION ! PLEASE TRY AGAIN");
                                            System.out.println();
                                        }
                                    }
                                }
                                break;
                            }
                            else{
                                System.out.println("INVALID INPUT TYPE OF THE CLUB NAME ! PLEASE TRY AGAIN");
                                System.out.println();
                            }
                        }
                    }
                    break;
                }
                else{
                    System.out.println("INVALID INPUT OF THE MEMBERSHIP ID ! PLEASE TRY AGAIN");
                    System.out.println();
                }
            }
        }
        else{
            System.out.println("SORRY, PREMIER LEAGUE IS FULL ! YOU CAN'T ADD ANY FOOTBALL CLUBS FURTHER !");
            System.out.println();
        }
    }

//---- Method used to get the id of the football club needs to be relegated from the premier league from the user ----//
    private static void relegateFootballClub(){
    //---- Invoking the method in LeagueManager interface used to check if the premier league is empty or not ---//
        if(managerOfPremierLeague.checkAvailabilityInPremierLeague(PremierLeagueManager.premierLeagueClubList)){
            Scanner userInputRelegate = new Scanner(System.in);

            String commonToLeagueId = "pl2021";

            while(true){
                System.out.print("ENTER THE MEMBERSHIP ID OF THE FOOTBALL CLUB WHICH NEEDED TO BE RELEGATED (Should contain pl2021 followed by 4 integer values): ");
                String inputOfMembershipId = userInputRelegate.next().replaceAll("\\s","");

            //--- Checking whether the input is in the correct length regarding the length of an id and contains the "pl2021" sub string or not ---//
                if(inputOfMembershipId.length() == 10 && inputOfMembershipId.contains(commonToLeagueId)){
                    boolean foundMembershipId = false;

                    for(int indexOfClub = 0; indexOfClub < PremierLeagueManager.premierLeagueClubList.size(); indexOfClub++){

                    //---- Checking whether the entered membership id is equal to the FootballClub object in the list or not ----//
                        if(PremierLeagueManager.premierLeagueClubList.get(indexOfClub).getSportsClubMembershipId().contains(inputOfMembershipId)){
                            foundMembershipId = true;
                            managerOfPremierLeague.relegateFootballClubsFromPremierLeague(PremierLeagueManager.premierLeagueClubList.get(indexOfClub));
                            break;
                        }
                    }
                    if(!foundMembershipId){
                        System.out.println("SORRY, THERE'S NO FOOTBALL CLUB MATCH WITH THAT MEMBERSHIP ID !");
                    }
                    break;
                }
                else{
                    System.out.println("INVALID INPUT OF THE MEMBERSHIP ID ! PLEASE TRY AGAIN");
                    System.out.println();
                }
            }
        }
        else{
            System.out.println("SORRY, THE PREMIER LEAGUE HAS NO ADDED FOOTBALL CLUBS !");
        }
    }

//---- Method used to display the statistics relevant to a football club by getting its id from the user ----//
    private static void displayStatistics(){
        if(managerOfPremierLeague.checkAvailabilityInPremierLeague(PremierLeagueManager.premierLeagueClubList)){
            Scanner userInputStats = new Scanner(System.in);
            String commonToLeagueId = "pl2021";

            while(true){
                System.out.print("ENTER THE MEMBERSHIP ID OF THE FOOTBALL CLUB WHICH NEEDED TO DISPLAY THE STATISTICS (Should contain pl2021 followed by 4 integer values): ");
                String inputOfMembershipId = userInputStats.nextLine().replaceAll("\\s","");

                if(inputOfMembershipId.length() == 10 && inputOfMembershipId.contains(commonToLeagueId)){
                    boolean foundMembershipId = false;
                    for(int indexOfClub = 0; indexOfClub < PremierLeagueManager.premierLeagueClubList.size(); indexOfClub++){
                        if(PremierLeagueManager.premierLeagueClubList.get(indexOfClub).getSportsClubMembershipId().contains(inputOfMembershipId)){
                            foundMembershipId = true;
                            managerOfPremierLeague.displayStatisticsOfSelectedFootballClub(PremierLeagueManager.premierLeagueClubList.get(indexOfClub));
                            break;
                        }
                    }
                    if(!foundMembershipId){
                        System.out.println("SORRY, THERE'S NO FOOTBALL CLUB MATCH WITH THAT MEMBERSHIP ID !");
                    }
                    break;
                }
                else{
                    System.out.println("INVALID INPUT OF THE MEMBERSHIP ID ! PLEASE TRY AGAIN");
                    System.out.println();
                }
            }
        }
        else{
            System.out.println("SORRY, THE PREMIER LEAGUE HAS NO ADDED FOOTBALL CLUBS !");
        }
    }

//---- Method used to get information related to a played match in premier league from the user to add to the match list ----//
    private static void addPlayedMatch(){
    //Checking whether if there's at least two clubs in the list to create a match//
        if(PremierLeagueManager.premierLeagueClubList.size() >= 2){

            Scanner userInputMatch = new Scanner(System.in);
        //------- PlayedMatchInPremierLeague type object created to access the methods in that class -------//
            PlayedMatchInPremierLeague playedMatchInPremierLeague = new PlayedMatchInPremierLeague();

            String commonToLeagueId = "pl2021";

            while(true){
                System.out.print("ENTER THE MEMBERSHIP ID OF THE FIRST FOOTBALL CLUB (Should contain pl2021 followed by 4 integer values): ");
                String firstClubId = userInputMatch.nextLine().toLowerCase().replaceAll("\\s", "");

                if(firstClubId.length() == 10 && firstClubId.contains(commonToLeagueId)){
                    boolean foundMembershipIdOfClub1 = false;

                    for(SportsClub sportsClub : PremierLeagueManager.premierLeagueClubList){

                    //---- Checking whether the entered membership id of first club is equal to the FootballClub object in the list or not ----//
                        if(sportsClub.getSportsClubMembershipId().equals(firstClubId)) {
                            foundMembershipIdOfClub1 = true;
                            SportsClub firstFootballClub;
                            firstFootballClub = sportsClub;
                            playedMatchInPremierLeague.setPlayedFootballClub_One(firstFootballClub); //Setting the first club of the match
                            break;
                        }
                    }
                    if(!foundMembershipIdOfClub1){
                        System.out.println("SORRY, THE ENTERED THE MEMBERSHIP ID FOR THE CLUB ONE WAS NOT FOUND !");
                    }
                    if(foundMembershipIdOfClub1){
                        while (true) {
                            System.out.print("ENTER THE MEMBERSHIP ID OF THE SECOND FOOTBALL CLUB (Should contain pl2021 followed by 4 integer values): ");
                            String secondClubId = userInputMatch.nextLine().toLowerCase().replaceAll("\\s", "");

                            if ((secondClubId.length() == 10) && (secondClubId.contains(commonToLeagueId)) && (!firstClubId.equals(secondClubId))) {
                                boolean foundMembershipIdOfClub2 = false;

                                for (SportsClub sportsClub : PremierLeagueManager.premierLeagueClubList) {

                                //---- Checking whether the entered membership id of second club is equal to the FootballClub object in the list or not ----//
                                    if (sportsClub.getSportsClubMembershipId().equals(secondClubId)) {
                                        foundMembershipIdOfClub2 = true;
                                        SportsClub secondFootballClub;
                                        secondFootballClub = sportsClub;
                                        playedMatchInPremierLeague.setPlayedFootballClub_Two(secondFootballClub); //Setting the second club of the match

                                    //Down casting two SportsClub type football clubs into FootballClub type to access the methods relevant to FootballClub class//
                                        FootballClub footballClubOne = (FootballClub) playedMatchInPremierLeague.getPlayedFootballClub_One();
                                        FootballClub footballClubTwo = (FootballClub) playedMatchInPremierLeague.getPlayedFootballClub_Two();

                                    //---- Checking whether the two clubs already played all 38 matches in the premier league or not ----//
                                        if(footballClubOne.getFootballClubNumberOfMatchesPlayed() <= FootballClub.MAXIMUM_PLAYED_MATCH_COUNT &&
                                                footballClubTwo.getFootballClubNumberOfMatchesPlayed()<= FootballClub.MAXIMUM_PLAYED_MATCH_COUNT){

                                        //---------------- ASSUMPTION: Setting the location of the played match as the location of the first club ----------------//
                                            playedMatchInPremierLeague.setPlayedMatchLocation(playedMatchInPremierLeague.getPlayedFootballClub_One().getSportsClubLocation());

                                        //Checking whether if there's already added matches in the match list related to two clubs by considering the ids//
                                            for(PlayedMatchInPremierLeague matchInPremierLeague: playedMatchInPremierLeague.getListOfPlayedMatchesInPremierLeague()){
                                                if(firstClubId.equals(matchInPremierLeague.getPlayedFootballClub_One().getSportsClubMembershipId()) &&
                                                        secondClubId.equals(matchInPremierLeague.getPlayedFootballClub_Two().getSportsClubMembershipId())){

                                                /*ASSUMPTION: Setting the location of the played match as the location of the second club
                                                  if there's a match in the list already for two clubs*/
                                                    playedMatchInPremierLeague.setPlayedMatchLocation(matchInPremierLeague.getPlayedFootballClub_Two().getSportsClubLocation());
                                                    break;
                                                }
                                            }
                                            int minimumValueOfDayMonth = 1;
                                            int maximumValueOfDay = 30; //ASSUMPTION: Maximum number of days in a month is 30
                                            int maximumValueOfMonth = 12;

                                        //ASSUMPTION: System was created to add played matches relevant to 2020-2021 season in premier league//
                                            int minimumValueOfYear = 2020;
                                            int maximumValueOfYear = 2021;

                                            try {
                                                while (true) {
                                                    System.out.print("ENTER THE DAY OF THE PLAYED MATCH: ");
                                                    int matchDay = userInputMatch.nextInt();

                                                    if (matchDay >= minimumValueOfDayMonth && matchDay <= maximumValueOfDay) {
                                                        while (true) {
                                                            System.out.print("ENTER THE MONTH OF THE PLAYED MATCH: ");
                                                            int matchMonth = userInputMatch.nextInt();

                                                            if (matchMonth >= minimumValueOfDayMonth && matchMonth <= maximumValueOfMonth) {
                                                                while (true) {
                                                                    System.out.print("ENTER THE YEAR OF THE PLAYED MATCH: ");
                                                                    int matchYear = userInputMatch.nextInt();

                                                                    if (matchYear == minimumValueOfYear || matchYear == maximumValueOfYear) {
                                                                        playedMatchInPremierLeague.setPlayedMatchDate(new MatchDate(matchDay, matchMonth, matchYear)); //Setting the date of the match

                                                                        System.out.print("ENTER THE NUMBER OF GOALS SCORED BY FIRST FOOTBALL CLUB: ");
                                                                        int goalsScoredClub_One = userInputMatch.nextInt();
                                                                        playedMatchInPremierLeague.setNumberOfGoalsScoredByFootballClub_One(goalsScoredClub_One); //Setting the number of goals scored by the first club

                                                                        System.out.print("ENTER THE NUMBER OF GOALS SCORED BY SECOND FOOTBALL CLUB: ");
                                                                        int goalsScoredClub_Two = userInputMatch.nextInt();
                                                                        playedMatchInPremierLeague.setNumberOfGoalsScoredByFootballClub_Two(goalsScoredClub_Two); //Setting the number of goals scored by the second club

                                                                        managerOfPremierLeague.addPlayedMatchInPremierLeague(playedMatchInPremierLeague);
                                                                        break;
                                                                    }
                                                                    else {
                                                                        System.out.println("INVALID INPUT OF MATCH YEAR ! PLEASE TRY AGAIN");
                                                                        System.out.println();
                                                                    }
                                                                }
                                                                break;
                                                            }
                                                            else {
                                                                System.out.println("INVALID INPUT OF MATCH MONTH ! PLEASE TRY AGAIN");
                                                                System.out.println();
                                                            }
                                                        }
                                                        break;
                                                    }
                                                    else {
                                                        System.out.println("INVALID INPUT OF MATCH DAY ! PLEASE TRY AGAIN");
                                                        System.out.println();
                                                    }
                                                }
                                            }
                                            catch (InputMismatchException inputMismatch){
                                                System.out.println("INVALID INPUT, CONSIDER THE DATA TYPE !");
                                            }
                                        }
                                        else{
                                            System.out.println("ALL 38 MATCHES WERE PLAYED BY ONE OF THE FOOTBALL CLUBS !");
                                        }
                                        break;
                                    }
                                }
                                if(!foundMembershipIdOfClub2) {
                                    System.out.println("SORRY, THE ENTERED THE MEMBERSHIP ID FOR THE CLUB TWO WAS NOT FOUND !");
                                }
                                break;
                            }
                            else {
                                System.out.println("INVALID INPUT OF SECOND CLUB MEMBERSHIP ID ! PLEASE TRY AGAIN");
                                System.out.println();
                            }
                        }
                    }
                    break;
                }
                else{
                    System.out.println("INVALID INPUT OF FIRST CLUB MEMBERSHIP ID ! PLEASE TRY AGAIN");
                    System.out.println();
                }
            }
        }
        else{
            System.out.println("SORRY, THE PREMIER LEAGUE HAS NOT ENOUGH FOOTBALL CLUBS TO PLAY A MATCH !");
        }
    }
}

