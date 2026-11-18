import java.util.ArrayList;
import java.util.Collections;
public class Paquet<T extends Carte> {
    private ArrayList<T> pioche;
    private ArrayList<T> defausse;
   

    public Paquet(){
        pioche = new ArrayList<>();
        defausse = new ArrayList<>();
    }


    public void AjouterCarte(T carte){
       pioche.add(carte);
    }

    public void melanger(){
        // une fonction pour melanger le packet aprés chaque tour, on peut utiliser collections.shuffle()
        Collections.shuffle(pioche);
    }

    public T piocher(){
        // verifier si la pioche est vide, si oui ajouter la defausse au ce dernier
        if (pioche.size() == 0){
            remelanger();
        }
        // si les deux sont vides, on retourne rien
        if (pioche.isEmpty()){
            return null;
        }
        // sinon retourne la card on top
        return pioche.remove(0);
    }

    public void defausse(T carte){
        // defausser c'est simplement ajouter une carte au defausse donc 
        defausse.add(carte);
    
}

    public void remelanger(){
        // fonction pour Ajouter des carte defaussé au packet de pioche et melanger
        pioche.addAll((defausse));
        defausse.clear();
        Collections.shuffle(pioche);
}
}