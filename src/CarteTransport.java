
public class CarteTransport implements Carte {
    private Couleur couleur;


    public Couleur getCouleur(){
        return this.couleur;
    }

    public CarteTransport(Couleur other){
        this.couleur = other;
    }

    @Override 
    public String getDiscription(){
        return "Carte Transport : " + this.couleur;
    }
}