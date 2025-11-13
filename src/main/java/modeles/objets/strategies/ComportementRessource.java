package modeles.objets.strategies;

import modeles.objets.Ressource;

public interface ComportementRessource {
    void appliquer(Ressource ressource, int x, int y);
}
