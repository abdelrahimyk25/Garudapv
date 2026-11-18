import java.util.Objects;

public class Route {
    private final StationCampus stationA;
    private final StationCampus stationB;
    private final int longueur;
    private final Couleur couleur;
    private Joueur proprietaire;
    private Route voieParallele;

    public Route(StationCampus stationA, StationCampus stationB, int longueur, Couleur couleur) {
        this.stationA = Objects.requireNonNull(stationA, "La première station est obligatoire.");
        this.stationB = Objects.requireNonNull(stationB, "La deuxième station est obligatoire.");
        this.couleur = Objects.requireNonNull(couleur, "La couleur est obligatoire.");
        if (stationA == stationB || longueur < 1) {
            throw new IllegalArgumentException("Une route relie deux stations distinctes et sa longueur est positive.");
        }
        this.longueur = longueur;
    }

    public StationCampus getStationA() {
        return stationA;
    }

    public StationCampus getStationB() {
        return stationB;
    }

    public int getLongueur() {
        return longueur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public boolean estDouble() {
        return voieParallele != null;
    }

    public void setProprio(Joueur autre){
        this.proprietaire = autre;
    }

    public void associerVoieParallele(Route autre) {
        Objects.requireNonNull(autre, "La voie parallèle est obligatoire.");
        boolean memesStations = (stationA == autre.stationA && stationB == autre.stationB)
                || (stationA == autre.stationB && stationB == autre.stationA);
        if (autre == this || !memesStations) {
            throw new IllegalArgumentException("Il faut deux voies distinctes reliant les mêmes stations.");
        }
        if (estDouble() || autre.estDouble() || proprietaire != null || autre.proprietaire != null) {
            throw new IllegalStateException("Associe les deux voies libres avant le début de la partie.");
        }
        voieParallele = autre;
        autre.voieParallele = this;
    }

    public boolean estDisponible(int nombreJoueurs) {
        if (proprietaire != null) {
            return false;
        }
        if ((nombreJoueurs == 2 || nombreJoueurs == 3) && estDouble()) {
            return voieParallele.proprietaire == null;
        }
        return true;
    }

    public void prendre(Joueur joueur, int nombreJoueurs) {
        Objects.requireNonNull(joueur, "Le joueur est obligatoire.");
        if (!estDisponible(nombreJoueurs)) {
            throw new IllegalStateException("Cette route est indisponible.");
        }
        proprietaire = joueur;
    }
}