package modeles.objets;

import modeles.acteur.Sid;
import modeles.monde.Terrain;
import modeles.objets.strategies.ComportementPosable;

public class Glace extends Ressource {
    public Glace(Terrain terrain, Inventaire inventaire, Sid sid) {
        super("glace", terrain, inventaire, sid, new ComportementPosable(2));
    }
}
