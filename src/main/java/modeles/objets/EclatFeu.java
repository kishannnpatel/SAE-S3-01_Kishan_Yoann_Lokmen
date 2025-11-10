package modeles.objets;

import modeles.acteur.Sid;
import modeles.monde.Terrain;
import modeles.objets.strategies.ComportementInactif;

public class EclatFeu extends Ressource {
    public EclatFeu(Terrain terrain, Inventaire inventaire, Sid sid) {
        super("eclat_feu", terrain, inventaire, sid, new ComportementInactif());
    }
}
