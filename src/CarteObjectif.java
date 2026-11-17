public class CarteObjectif implements Carte {
    private String Departure;
    private String Destination;
    private int point_value;


    public CarteObjectif(String x, String y, int m){
        this.Departure = x;
        this.Destination = y;
        this.point_value = m;
    }
    
    public String getDeparture(){
        return this.Departure;
    }

    public String getDestination(){
        return this.Destination;
    }

    public int getValue(){
        return this.point_value;
    }

    @Override 
    public String getDiscription(){
        return "Carte Objective : departure " + this.Departure + " -> " + this.Destination + " ( " + this.point_value + ")";
    }
}
