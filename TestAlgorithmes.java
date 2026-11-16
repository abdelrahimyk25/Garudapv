import java.util.*;

public class TestAlgorithmes {

    // ==========================================================
    // 1.  ALGORITHME BFS (Parcours en largeur)
    // ==========================================================
    public static boolean sontConnectees(String depart, String arrivee, List<RouteSimple> routesDuJoueur) {
        // Cas évident : si le départ est la même station que l'arrivée
        if (depart.equals(arrivee)) {
            return true;
        }

        // 'visites' est un ensemble  pour ne pas tourner en rond
        Set<String> visites = new HashSet<>();

        // 'file' est la file d'attente pour le BFS 
        Queue<String> file = new LinkedList<>();

        // On commence par la station de départ
        file.add(depart);
        visites.add(depart);

        // Tant qu'il y a des stations à explorer dans la file
        while (!file.isEmpty()) {
            // file.poll() retire et renvoie le premier élément 
            String stationCourante = file.poll();

            // Si on a atteint la destination souhaitée : Victoire !
            if (stationCourante.equals(arrivee)) {
                return true;
            }

            // On cherche toutes les stations voisines reliées par les routes du joueur
            for (RouteSimple r : routesDuJoueur) {
                String voisine = null;

                // Une route va dans les deux sens (A <-> B)
                if (r.stationA.equals(stationCourante)) {
                    voisine = r.stationB;
                } else if (r.stationB.equals(stationCourante)) {
                    voisine = r.stationA;
                }

                // Si on a trouvé une voisine et qu'elle n'a pas encore été visitée
                if (voisine != null && !visites.contains(voisine)) {
                    visites.add(voisine);
                    file.add(voisine); // On l'ajoute dans la file pour l'explorer plus tard
                }
            }
        }

        // Si la file est vide et qu'on n'a jamais croisé 'arrivee' : pas de chemin !
        return false;
    }

    // ==========================================================
    // 2. LE PROGRAMME DE TEST (Le point d'entrée 'main')
    // ==========================================================
    public static void main(String[] args) {
        System.out.println("--- TEST DE MON ALGORITHME BFS ---");

        // Imaginons que le joueur possède 2 routes :
        // 1. Belfort <-> Sevenans
        // 2. Sevenans <-> Montbéliard
        List<RouteSimple> routesDuJoueur = new ArrayList<>();
        routesDuJoueur.add(new RouteSimple("Belfort", "Sevenans"));
        routesDuJoueur.add(new RouteSimple("Sevenans", "Montbeliard"));

        // Test 1 : Est-ce que Belfort et Montbéliard sont reliées ?
        boolean test1 = sontConnectees("Belfort", "Montbeliard", routesDuJoueur);
        System.out.println("Belfort relié à Montbéliard ? -> " + test1 + " (Attendu : true)");

        // Test 2 : Est-ce que Belfort et Paris sont reliées ?
        boolean test2 = sontConnectees("Belfort", "Paris", routesDuJoueur);
        System.out.println("Belfort relié à Paris ? -> " + test2 + " (Attendu : false)");
    }
}

// Petite classe simple pour représenter une route entre 2 stations
class RouteSimple {
    String stationA;
    String stationB;

    // Constructeur 
    public RouteSimple(String stationA, String stationB) {
        this.stationA = stationA;
        this.stationB = stationB;
    }
}