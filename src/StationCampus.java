import java.util.Objects;

public class StationCampus {
    private final String nom;
    private final int x;
    private final int y;

    public StationCampus(String nom, int x, int y) {
        this.nom = Objects.requireNonNull(nom, "Le nom de la station est obligatoire.");
        this.x = x;
        this.y = y;
    }

    public String getNom() {
        return nom;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}