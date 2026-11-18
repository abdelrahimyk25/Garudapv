import java.util.ArrayList;


public class Joueur {
    private String name;
    private ArrayList<CarteObjectif> objectives;
    private ArrayList<CarteTransport> hand;
    private int navetteRestaunts;
    private int score;
    private ArrayList<Route> routesPossedes;


    public Joueur(String x, int nombrenavette){
        this.name = x;
        this.objectives = new ArrayList<>();
        this.hand = new ArrayList<>();
        this.navetteRestaunts = nombrenavette;
        this.score = 0;
        this.routesPossedes = new ArrayList<>();
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

    //une fonction pour aider prendre le decision pour peut acheter au fonction de nombre des carte de tel couleur
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
    


     // fonction pour ajouter une carte de transport a la main de joueur
    public void AjouterCT(CarteTransport carte){
        this.getHand().add(carte);
    }

     // fonction pour ajouter une carte d'objectif a la main de joueur
     public void AjouterCO(CarteObjectif carte){
        this.getObjectives().add(carte);

     }

     // Fonction pour determiner si un joueur peut acheter une route ou pas (a modifier pour que il traite le joker comme optionelle)
     public boolean peutAcheterRoute(Route route, int nbjoker){

        int nbcouleur = route.getLongueur() - nbjoker; // ici nbjoker est le nombre des joker aue le jouer decide d'utiliser
        
        return nbjoker >= 0 && nbcouleur >= 0 && compteCarte(Couleur.JOKER) >= nbjoker && compteCarte(route.getCouleur()) >= nbcouleur && this.getNavette() >= route.getLongueur();
     }


     // Fonction pour enlevent des cards pour un achat 
     public void payerRoute(Route route, int nbjoker){

        if (peutAcheterRoute(route,nbjoker)){
            int nbcouleur = route.getLongueur() - nbjoker;
            
            int i = 0;
            while (i < getHand().size() && (nbcouleur > 0 || nbjoker > 0)){
                Couleur col = getHand().get(i).getCouleur();
                if (col == route.getCouleur() && nbcouleur > 0){
                    getHand().remove(i);
                    nbcouleur--;
                }else if(col == Couleur.JOKER && nbjoker > 0){
                        getHand().remove(i);
                        nbjoker--;
                 }else{
                    i++;
                }
            }
            this.navetteRestaunts -= route.getLongueur();
        }

     }
     // Fonction pour possedre une route
     public void acheterRoute(Route route, int nbjoker, int nombreJoueurs){
        if(route.getProprietaire() == null && peutAcheterRoute(route, nbjoker)){
            payerRoute(route, nbjoker);
            route.prendre(this, nbjoker);
            this.routesPossedes.add(route);
        }

     }

     // Fonction pour verifier si l'objective est completé ou pas

     public boolean verifierOB(){
        return true;
     }

     // Fonction pour calculer le score

      public int calculateScore(){
          
        return 1;
      }


    }




