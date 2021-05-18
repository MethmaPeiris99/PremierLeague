package models.entities;

public class UniversityFootballClub extends FootballClub{

    private String universityNameOfClub; //Instance variable of UniversityFootballClub

//---------------- UniversityFootballClub class constructor ----------------//
    public UniversityFootballClub(String inputOfClubName, String inputOfClubLocation, String inputOfClubMembershipId, String inputOfUniversityName){
        super(inputOfClubName, inputOfClubLocation, inputOfClubMembershipId);
        this.universityNameOfClub = inputOfUniversityName;
    }

//---------------- Getter methods of UniversityFootballClub class ----------------//
    public String getUniversityName(){
        return universityNameOfClub;
    }

//---------------- Setter methods of UniversityFootballClub class ----------------//
    public void setUniversityName(String inputOfUniversityName){
        this.universityNameOfClub =inputOfUniversityName;
    }

//---------------- equals() method of UniversityFootballClub class ----------------//
    public boolean equals(FootballClub footballClub){
        if (this == footballClub){
            return true;
        }
        if (!(footballClub instanceof UniversityFootballClub)){
            return false;
        }
        UniversityFootballClub universityFootballClub = (UniversityFootballClub) footballClub;
        return this.universityNameOfClub.equals(universityFootballClub.universityNameOfClub);
    }

//---------------- hashCode() method of UniversityFootballClub class ----------------//
    public int hashCode(){
        return super.hashCode();
    }

//---------------- toString() method of UniversityFootballClub class ----------------//
    public String toString(){
        return super.toString()+
                "\nUniversity name of University football club: "+universityNameOfClub;
    }
}
