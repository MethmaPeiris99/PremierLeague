package models.entities;

public abstract class SportsClub implements java.io.Serializable{

//---- Instance variables of SportsClub ----//
    private String sportsClubName;
    private String sportsClubLocation;
    private String sportsClubMembershipId;

//---------------- SportsClub class constructor ----------------//
    public SportsClub(String inputOfClubName, String inputOfClubLocation, String inputOfClubMembershipId){
        this.sportsClubName = inputOfClubName;
        this.sportsClubLocation = inputOfClubLocation;
        this.sportsClubMembershipId = inputOfClubMembershipId;
    }

//---------------- Getter methods of SportsClub class ----------------//
    public String getSportsClubName(){
        return sportsClubName;
    }

    public String getSportsClubLocation(){
        return sportsClubLocation;
    }

    public String getSportsClubMembershipId(){
        return sportsClubMembershipId;
    }

//---------------- Setter methods of SportsClub class ----------------//
    public void setSportsClubName(String inputOfClubName){
        this.sportsClubName = inputOfClubName;
    }

    public void setSportsClubLocation(String inputOfClubLocation){
        this.sportsClubLocation = inputOfClubLocation;
    }

    public void setSportsClubMembershipId(String inputOfClubMembershipId){
        this.sportsClubMembershipId = inputOfClubMembershipId;
    }

//---------------- equals() method of SportsClub class ----------------//
    public boolean equals(Object objectReference){
        if(this == objectReference){ //Checking SportsClub type reference and Object type reference referencing the same object or not
            return true;
        }
        if(!(objectReference instanceof SportsClub)){ //Checking whether the objectReference type contains SportsClub type or not
            return false;
        }
        SportsClub sportsClub = (SportsClub) objectReference; //Down casting the Object type variable into SportsClub type

        return (this.sportsClubName.equals(sportsClub.sportsClubName) && this.sportsClubLocation.equals(sportsClub.sportsClubLocation) &&
                this.sportsClubMembershipId.equals(sportsClub.sportsClubMembershipId)); /*Checking whether the object passed as the argument has the same state as
							                                                              SportsClub type instances or not*/
    }

//---------------- hashCode() method of SportsClub class ----------------//
    public int hashCode(){
        return Integer.parseInt(this.getSportsClubMembershipId()); /*Returning the membership Id value which is unique to each Sports club
                                                                    *By invoking this method on instances recognized as similar in equals(),
                                                                     should return the same membership Id value.*/
    }

//---------------- toString() method of SportsClub class ----------------//
    public String toString(){
        return  "\n\nName of the Sports club           : "+sportsClubName+
                "\nLocation of the Sports club       : "+sportsClubLocation+
                "\nMembership Id of the Sports club  : "+sportsClubMembershipId;
    }
}
