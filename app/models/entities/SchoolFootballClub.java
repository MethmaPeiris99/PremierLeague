package models.entities;

public class SchoolFootballClub extends FootballClub{

    private String schoolNameOfClub; //Instance variable of SchoolFootballClub

//---------------- SchoolFootballClub class constructor ----------------//
    public SchoolFootballClub(String inputOfClubName, String inputOfClubLocation, String inputOfClubMembershipId, String inputOfSchoolName){
        super(inputOfClubName, inputOfClubLocation, inputOfClubMembershipId);
        this.schoolNameOfClub = inputOfSchoolName;
    }

//---------------- Getter methods of SchoolFootballClub class ----------------//
    public String getSchoolName(){
        return schoolNameOfClub;
    }

//---------------- Setter methods of SchoolFootballClub class ----------------//
    public void setSchoolName(String inputOfSchoolName){
        this.schoolNameOfClub = inputOfSchoolName;
    }

//---------------- equals() method of SchoolFootballClub class ----------------//
    public boolean equals(FootballClub footballClub){
        if (this == footballClub){ //Checking SchoolFootballClub type reference and FootballClub type reference referencing the same object or not
            return true;
        }
        if (!(footballClub instanceof SchoolFootballClub)){ //Checking whether the footballClub type contains SchoolFootballClub type or not
            return false;
        }

        SchoolFootballClub schoolFootballClub = (SchoolFootballClub) footballClub;  //Down casting the FootballClub type variable into SchoolFootballClub type


        return this.schoolNameOfClub.equals(schoolFootballClub.schoolNameOfClub); /*Checking whether the object passed as the argument has the same state as
                                                                                    SchoolFootballClub type instances or not*/
    }

//---------------- hashCode() method of SchoolFootballClub class----------------//
    public int hashCode(){
        return super.hashCode(); /*Returning the membership Id value which is unique to each Sports club
                                  *By invoking this method on instances recognized as similar in equals(),
                                  *should return the same membership Id value.*/
    }

//---------------- toString() method of SchoolFootballClub class----------------//
    public String toString(){
        return super.toString()+
                "\nSchool name of School football club: "+schoolNameOfClub;
    }
}
