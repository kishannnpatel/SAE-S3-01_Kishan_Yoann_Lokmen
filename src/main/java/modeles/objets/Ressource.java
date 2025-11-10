package modeles.objets;

import modeles.acteur.Sid;
import modeles.monde.Terrain;
import modeles.objets.strategies.ComportementRessource;

public abstract class Ressource extends Objets {

    private final ComportementRessource comportement;

    public Ressource(String nom, Terrain terrain, Inventaire inventaire, Sid sid, ComportementRessource comportement) {
        super(nom, terrain, inventaire, sid);
        this.comportement = comportement;
    }

    @Override
    public Item creerItem() {
        return new Item(this, 1);
    }

    @Override
    public void fonction(int x, int y) {
        comportement.appliquer(this, x, y);
    }

    public String getType() {
        return "Ressource";
    }
}
