package modeles.objets.strategies;

import modeles.objets.Ressource;

public class ComportementInactif implements ComportementRessource {
    @Override
    public void appliquer(Ressource ressource, int x, int y) {
        // Aucun effet
    }
}
