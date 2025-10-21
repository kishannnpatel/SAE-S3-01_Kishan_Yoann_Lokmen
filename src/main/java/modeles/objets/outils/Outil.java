package modeles.objets.outils;


import modeles.acteur.Sid;
import modeles.monde.Terrain;
import modeles.objets.Inventaire;
import modeles.objets.Item;
import modeles.objets.Objets;

public abstract class Outil extends Objets {

    public Outil(String nom, Terrain terrain, Inventaire inventaire, Sid sid) {
        super(nom, terrain, inventaire, sid);

    }

    @Override
    public Item creerItem() {
        return new Item(this, 1);
    }

    public String getType() {
        return "Outil";
    }


}

