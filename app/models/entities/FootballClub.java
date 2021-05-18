package models.entities;

public class FootballClub extends SportsClub implements Comparable<FootballClub>,java.io.Serializable{

//---- Instance variables of FootballClub ----//
    private int footballClubNumberOfWins;
    private int footballClubNumberOfDraws;
    private int footballClubNumberOfDefeats;
    private int footballClubNumberOfGoalsReceived;
    private int footballClubNumberOfGoalsScored;
    private int footballClubNumberOfPoints;
    private int footballClubNumberOfMatchesPlayed;
    private int footballClubGoalDifference;

    public static final int MAXIMUM_PLAYED_MATCH_COUNT = 38;

//---------------- FootballClub class constructor ----------------//
    public FootballClub(String inputOfClubName, String inputOfClubLocation, String inputOfClubMembershipId){
        super(inputOfClubName, inputOfClubLocation, inputOfClubMembershipId);
    }

//-------------------- Getter methods of FootballClub class --------------------//
    public int getFootballClubNumberOfWins(){
        return footballClubNumberOfWins;
    }

    public int getFootballClubNumberOfDraws(){
        return footballClubNumberOfDraws;
    }

    public int getFootballClubNumberOfDefeats(){
        return footballClubNumberOfDefeats;
    }

    public int getFootballClubNumberOfGoalsReceived(){
        return footballClubNumberOfGoalsReceived;
    }

    public int getFootballClubNumberOfGoalsScored(){
        return footballClubNumberOfGoalsScored;
    }

    public int getFootballClubNumberOfPoints(){
        return footballClubNumberOfPoints;
    }

    public int getFootballClubNumberOfMatchesPlayed(){
        return footballClubNumberOfMatchesPlayed;
    }

    public int getFootballClubGoalDifference(){
        return footballClubGoalDifference;
    }

//-------------------- Setter methods of FootballClub class --------------------//
    public void setFootballClubNumberOfWins(int inputOfClubNumberOfWins){
        this.footballClubNumberOfWins = inputOfClubNumberOfWins;
    }

    public void setFootballClubNumberOfDraws(int inputOfClubNumberOfDraws){
        this.footballClubNumberOfDraws = inputOfClubNumberOfDraws;
    }

    public void setFootballClubNumberOfDefeats(int inputOfClubNumberOfDefeats){
        this.footballClubNumberOfDefeats = inputOfClubNumberOfDefeats;
    }

    public void setClubNumberOfGoalsReceived(int inputOfClubNumberOfGoalsReceived){
        this.footballClubNumberOfGoalsReceived += inputOfClubNumberOfGoalsReceived;
    }

    public void setClubNumberOfGoalsScored(int inputOfClubNumberOfGoalsScored){
        this.footballClubNumberOfGoalsScored += inputOfClubNumberOfGoalsScored;
    }

    public void setFootballClubNumberOfPoints(int inputOfClubNumberOfPoints){
        this.footballClubNumberOfPoints = inputOfClubNumberOfPoints;
    }

    public void setFootballClubNumberOfMatchesPlayed(int inputOfClubNumberOfMatchesPlayed){
        if(inputOfClubNumberOfMatchesPlayed < MAXIMUM_PLAYED_MATCH_COUNT) {
            this.footballClubNumberOfMatchesPlayed += inputOfClubNumberOfMatchesPlayed;
        }
    }

    public void setFootballClubGoalDifference(int inputOfClubGoalDifference){
        this.footballClubGoalDifference = inputOfClubGoalDifference;
    }

//---------------- equals() method of FootballClub class ----------------//
    public boolean equals(SportsClub sportsClub){
        if (this == sportsClub){ //Checking FootballClub type reference and SportsClub type reference referencing the same object or not
            return true;
        }
        if (!(sportsClub instanceof FootballClub)){ //Checking whether the sportsClub type contains FootballClub type or not
            return false;
        }
        FootballClub footballClub = (FootballClub) sportsClub; //Down casting the SportsClub type variable into FootballClub type

//------------------ Checking whether the object passed as the argument has the same state as FootballClub type instances or not ------------------//
        return  this.footballClubNumberOfWins == footballClub.footballClubNumberOfWins && this.footballClubNumberOfDraws == footballClub.footballClubNumberOfDraws &&
                this.footballClubNumberOfDefeats == footballClub.footballClubNumberOfDefeats && this.footballClubNumberOfGoalsReceived ==
                footballClub.footballClubNumberOfGoalsReceived && this.footballClubNumberOfGoalsScored == footballClub.footballClubNumberOfGoalsScored
                && this.footballClubNumberOfPoints == footballClub.footballClubNumberOfPoints && this.footballClubNumberOfMatchesPlayed
                == footballClub.footballClubNumberOfMatchesPlayed && this.footballClubGoalDifference == footballClub.footballClubGoalDifference;
    }

//------------------------ hashCode() method of FootballClub class ------------------------//
    public int hashCode(){
        return super.hashCode();
    }

//----------------------- toString() method of FootballClub class -----------------------//
    public String toString(){
        return super.toString()+
                "\nNumber of wins belongs to Football club     : "+footballClubNumberOfWins+
                "\nNumber of draws belongs to Football club    : "+footballClubNumberOfDraws+
                "\nNumber of defeats belongs to Football club  : "+footballClubNumberOfDefeats+
                "\nNumber of goals received by Football club   : "+footballClubNumberOfGoalsReceived+
                "\nNumber of goals scored by Football club     : "+footballClubNumberOfGoalsScored+
                "\nNumber of points achieved by Football club  : "+footballClubNumberOfPoints+
                "\nNumber of matches played by Football club   : "+footballClubNumberOfMatchesPlayed+
                "\nGoal difference of the Football club        : "+footballClubGoalDifference;
    }

    public void calculateGoalDifferenceAndMatchCount(int inputOfGoalsScored, int inputOfGoalsReceived){
        footballClubGoalDifference = inputOfGoalsScored - inputOfGoalsReceived;
        footballClubNumberOfMatchesPlayed ++;
    }

//Method used to determine the status of a particular match (win,draw or defeat) by considering the goals scored by played clubs//
    public void calculatePointsByMatchStatus(int inputOfGoalsScoredByClub, int inputOfGoalsScoredByOpponent){
        if(inputOfGoalsScoredByClub > inputOfGoalsScoredByOpponent){
            footballClubNumberOfWins +=1;
            footballClubNumberOfPoints +=3;
            System.out.println();
            System.out.println(getSportsClubName()+" HAS WON THE MATCH !");
        }
        else if(inputOfGoalsScoredByClub < inputOfGoalsScoredByOpponent){
            footballClubNumberOfDefeats +=1;
            System.out.println(getSportsClubName()+" HAS LOST THE MATCH !");
        }
        else{
            footballClubNumberOfDraws +=1;
            footballClubNumberOfPoints +=1;
            System.out.println(getSportsClubName()+" DREW THIS TIME !");
        }
    }

//----------------------- compareTo() method of FootballClub class -----------------------//
    @Override
    public int compareTo(FootballClub footballClub){
        if(this.footballClubNumberOfPoints == footballClub.getFootballClubNumberOfPoints()){ //Checking the equality of number of points of two FootballClub type instances

        //--------------------- Comparing the goal difference of two FootballClub type instances ---------------------//
            return Integer.toString(this.footballClubGoalDifference).compareTo(Integer.toString(footballClub.getFootballClubGoalDifference()));
        }
    //---------------------- Comparing the total number of points of two FootballClub type instances ----------------------//
        return Integer.toString(this.footballClubNumberOfPoints).compareTo(Integer.toString(footballClub.getFootballClubNumberOfPoints()));
    }
}
