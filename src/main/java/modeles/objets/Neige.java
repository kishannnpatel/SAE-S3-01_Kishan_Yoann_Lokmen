package modeles.objets;

import modeles.acteur.Sid;
import modeles.monde.Terrain;
import modeles.objets.strategies.ComportementPosable;

public class Neige extends Ressource {
    public Neige(Terrain terrain, Inventaire inventaire, Sid sid) {
        super("neige", terrain, inventaire, sid, new ComportementPosable(1));
    }
}
