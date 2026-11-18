public class CarteObjectif implements Carte {
    private String title;
    private StationCampus Departure;
    private StationCampus Destination;
    private int point_value;
    private boolean estValide;


    public CarteObjectif(String title,StationCampus x, StationCampus y, int m){
        this.title = title;
        this.Departure = x;
        this.Destination = y;
        this.point_value = m;
        this.estValide = false;
    }
    
    public StationCampus getDeparture(){
        return this.Departure;
    }

    public StationCampus getDestination(){
        return this.Destination;
    }

    public int getValue(){
        return this.point_value;
    }
    
    public String getTitle(){
        return this.title;
    }

    public void setValider(){
        this.estValide = true;
    }

    @Override 
    public String getDiscription(){
        return "Carte Objective : departure " + this.Departure + " -> " + this.Destination + " ( " + this.point_value + ")" + "current state : " + estValide;
    }
}
