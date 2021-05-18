package models.manager;

import models.entities.PlayedMatchInPremierLeague;
import models.entities.SportsClub;

import java.io.IOException;
import java.io.File;

import java.util.List;

public interface LeagueManager{

//----- Abstract methods related to the functions in the menu which are overridden in the PremierLeagueManager class -----//
    void displayChoiceMenu();
    void addFootballClubsToPremierLeague(SportsClub footballClubNeededToAdd);
    void relegateFootballClubsFromPremierLeague(SportsClub footballClubNeededToRelegate);
    void displayStatisticsOfSelectedFootballClub(SportsClub footballClubNeededToDisplayStats);
    void displayPremierLeagueTable();
    void addPlayedMatchInPremierLeague(PlayedMatchInPremierLeague inputOfPlayedMatchInPremierLeague);

//Abstract methods related to save user input data which are overridden in the PremierLeagueManager class//
    void saveAllPremierLeagueClubDataAdded(File inputOfFileName, List<SportsClub> inputOfClubsInPremierLeague) throws IOException;
    void saveAllPremierLeagueMatchDataAdded(File inputOfFileName, List<PlayedMatchInPremierLeague> inputOfPlayedMatchInPremierLeague) throws IOException;

//Abstract methods related to load user input saved data which are overridden in the PremierLeagueManager class//
    void loadAllPremierLeagueClubDataAdded(File inputOfFileName)throws IOException, ClassNotFoundException;
    void loadAllPremierLeagueMatchDataAdded(File inputOfFileName)throws IOException, ClassNotFoundException;

//---------- Method used to check whether the premier league array list is empty or not ----------//
    default boolean checkAvailabilityInPremierLeague(List<SportsClub> inputOfPremierLeagueArrayList) {
        if(!inputOfPremierLeagueArrayList.isEmpty()){
            return true;
        }
        return false;
    }
}
