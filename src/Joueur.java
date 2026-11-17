import java.util.ArrayList;


public class Joueur {
    private String name;
    private ArrayList<CarteObjectif> objectives;
    private ArrayList<CarteTransport> hand;
    private int navetteRestaunts;
    private int score;
    // private ArrayList<Route> routepossede


    public Joueur(String x, int nombrenavette){
        this.name = x;
        this.objectives = new ArrayList<>();
        this.hand = new ArrayList<>()
        this.navetteRestaunts = nombrenavette;
        this.score = 0;
        //this.routepossede = parameter;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<CarteObjectif> getObjectives(){
        return this.objectives;
    }

    public ArrayList<CarteTransport> getHand(){
        return this.hand;
    }

    public int getNavette(){
        return this.navetteRestaunts;
    }

    public int getScore(){
        return this.score;
    }


    public int compteCarte(Couleur color){
        int i = 0;
        int compteur = 0;

        while (i < this.hand.size()){
            if (hand.get(i).getCouleur() == color){
                compteur++;

            }
                i++;
            }
            return compteur;
        }
        
    }


