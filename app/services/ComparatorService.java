package services;

import models.entities.PlayedMatchInPremierLeague;
import models.entities.SportsClub;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class ComparatorService {
    private static ComparatorService comparatorServiceInstance;

    public static ComparatorService getComparatorServiceInstance(){
        if(comparatorServiceInstance == null){
            comparatorServiceInstance = new ComparatorService();
        }
        return comparatorServiceInstance;
    }

    public List<SportsClub> getLoadedClubList() throws IOException, ClassNotFoundException {
        List<SportsClub> loadedClubList = new ArrayList<>(); //Creating an array to store the loaded clubs from the file

        FileInputStream fileInputStream = new FileInputStream("premierLeague_ClubData.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        for(;;){
            try {
                SportsClub sportsClub = (SportsClub) objectInputStream.readObject();
                loadedClubList.add(sportsClub);
            }
            catch (EOFException eofException){
                break;
            }
        }
        fileInputStream.close();
        objectInputStream.close();

        return loadedClubList;
    }

    public List<PlayedMatchInPremierLeague> getLoadedMatchList() throws IOException, ClassNotFoundException {
        List<PlayedMatchInPremierLeague> loadedMatchList = new ArrayList<>(); //Creating an array to store the loaded matches from the file

        FileInputStream fileInputStream = new FileInputStream("premierLeague_MatchData.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        for(;;){
            try {
                PlayedMatchInPremierLeague playedMatchInPremierLeague = (PlayedMatchInPremierLeague) objectInputStream.readObject();
                loadedMatchList.add(playedMatchInPremierLeague);
            }
            catch (EOFException eofException){
                break;
            }
        }
        fileInputStream.close();
        objectInputStream.close();

        return loadedMatchList;
    }
}
