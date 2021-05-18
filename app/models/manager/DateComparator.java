package models.manager;

import models.entities.PlayedMatchInPremierLeague;

import java.util.Comparator;

public class DateComparator implements Comparator<PlayedMatchInPremierLeague> {

//Overriding the method used to compare two match dates in MatchDate class//
    @Override
    public int compare(PlayedMatchInPremierLeague match1, PlayedMatchInPremierLeague match2) {
        return match1.getPlayedMatchDate().compareTo(match2.getPlayedMatchDate());
    }
}

