package models.entities;

public class MatchDate implements java.io.Serializable, Comparable<MatchDate>{

//Instance variables of MatchDate//
    private int matchDay;
    private int matchMonth;
    private int matchYear;

//---------------- MatchDate class constructor ----------------//
    public MatchDate(int inputOfMatchDay, int inputOfMatchMonth, int inputOfMatchYear){
        this.matchDay = inputOfMatchDay;
        this.matchMonth = inputOfMatchMonth;
        this.matchYear = inputOfMatchYear;
    }

//---------------- Getter methods of MatchDate class ----------------//
    public int getMatchDay(){
        return matchDay;
    }

    public int getMatchMonth(){
        return matchMonth;
    }

    public int getMatchYear(){
        return matchYear;
    }

//---------------- Setter methods of MatchDate class ----------------//
    public void setMatchDay(int inputOfMatchDay){
        this.matchDay = inputOfMatchDay;
    }

    public void setMatchMonth(int inputOfMatchMonth){
        this.matchMonth = inputOfMatchMonth;
    }

    public void setMatchYear(int inputOfMatchYear){
        this.matchYear = inputOfMatchYear;
    }

//---------------- equals() method of MatchDate class ----------------//
    public boolean equals(Object objectReference){
        if(this == objectReference){
            return true;
        }
        if(!(objectReference instanceof MatchDate)){
            return false;
        }
        MatchDate matchDate = (MatchDate) objectReference;

        return (this.matchDay == matchDate.matchDay && this.matchMonth == matchDate.matchMonth && this.matchYear == matchDate.matchYear);
    }
//---------------- hashCode() method of MatchDate class ----------------//
    public int hashCode() {
        /*Returning the values of day,month and year regarding a match.
         *By invoking this method on instances recognized as similar
          in equals(),should return same values of day,month and year.*/
        return this.getMatchDay()+Integer.parseInt(" / ")+this.getMatchMonth()+Integer.parseInt(" / ")+this.getMatchYear();
    }

//---------------- toString() method of MatchDate class ----------------//
    public String toString(){
        return  "\nDay of the Match  : "+matchDay+
                "\nMonth of the Match: "+matchMonth+
                "\nYear of the Match : "+matchYear;
    }

//---------------- compareTo() method of MatchDate class ----------------//
    @Override
    public int compareTo(MatchDate matchDate) {
        if(this.getMatchDateInDays() > matchDate.getMatchDateInDays()){
            return 1;
        }
        else if(this.getMatchDateInDays() == matchDate.getMatchDateInDays()){
            return 0;
        }
        else{
            return -1;
        }
    }

    private int getMatchDateInDays(){
        return (this.matchYear*365) + (this.matchMonth*30) + (this.matchDay);
    }

//------------ Method used to display the match date in the format of DD/MM/YYYY ------------//
    public String displayPlayedMatch(){
        if(matchDay<10 && matchMonth<10) {
            return "0"+ matchDay +"/0"+ matchMonth +"/"+ matchYear;
        }
        else if(matchDay<10) {
            return "0"+ matchDay + matchMonth + "/" + matchYear;
        }
        else if(matchMonth<10){
            return matchDay + "/0" +matchMonth + "/" + matchYear;
        }
        return matchDay+"/"+matchMonth+"/"+matchYear;
    }
}

