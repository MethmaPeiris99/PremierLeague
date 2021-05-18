package models.manager;

import models.entities.FootballClub;
import models.entities.SportsClub;

import java.util.Comparator;

public class WinComparator implements Comparator<SportsClub> {

//-------- Method used to compare number of wins related to two clubs --------//
    @Override
    public int compare(SportsClub sportsClub1, SportsClub sportsClub2) {
        FootballClub footballClub1 = (FootballClub) sportsClub1;
        FootballClub footballClub2 = (FootballClub) sportsClub2;

        if(footballClub1.getFootballClubNumberOfWins() > footballClub2.getFootballClubNumberOfWins()){
            return 1;
        }
        else if(footballClub1.getFootballClubNumberOfWins() == footballClub2.getFootballClubNumberOfWins()){
            return 0;
        }
        else{
            return -1;
        }
    }
}
