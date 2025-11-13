package modeles.objets.strategies;

import modeles.objets.Item;
import modeles.objets.Objets;
import modeles.objets.Ressource;

public class ComportementPosable implements ComportementRessource {
    private final int idBloc; // valeur à poser dans la map (ex: 1 pour neige, 2 pour glace)

    public ComportementPosable(int idBloc) {
        this.idBloc = idBloc;
    }

    @Override
    public void appliquer(Ressource ressource, int x, int y) {
        int[][] map = ressource.getTerrain().getMap();
        Objets objetEnMain = ressource.getSid().getObjetEnMain();

        Item itemTrouve = ressource.getInventaire().getItems().stream()
                .filter(item -> item.getObjet().equals(objetEnMain))
                .findFirst().orElse(null);

        if (itemTrouve == null || itemTrouve.getQuantite().get() == 0) {
            System.out.println("Impossible de poser : objet non disponible ou quantité insuffisante.");
            return;
        }

        if (map[y][x] == -1) {
            map[y][x] = idBloc;
            ressource.getInventaire().retirerUnItem(objetEnMain);

            if (!ressource.getInventaire().contient(objetEnMain)) {
                ressource.getSid().setObjetEnMain(null);
            }

            ressource.getTerrain().mettreAJourHitboxBlocsSolides();
            System.out.println("Bloc posé (" + ressource.getNom() + ")");
        }
    }
}
