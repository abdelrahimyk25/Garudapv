import java.util.ArrayList;
import java.util.Collections;
public class Paquet<T extends Carte> {
    private ArrayList<T> pioche;
    private ArrayList<T> defausse;


    public Paquet(){
        pioche = new ArrayList<>();
        defausse = new ArrayList<>();
    }


    public void AjouterCarte(Carte T){
       // une fonction a faire qui peut ajouter une carte au pioche/defausse
    }

    public void Melanger(){
        // une fonction pour melanger le packet aprés chaque tour
    }

    public T piocher(){
       // Fonction qui enlever de la pioche et retourne la carte
    }

    public void defausse(){
        // fonction pour defausser une carte
    
}

    public void remelanger(){
        // fonction pour Ajouter des carte defaussé au packet de pioche et melanger
    }
}