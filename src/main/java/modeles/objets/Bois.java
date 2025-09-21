package modeles.objets;

import modeles.acteur.Sid;
import modeles.monde.Terrain;
import modeles.objets.Ressource;

public class Bois extends Ressource {

    public Bois(Terrain terrain, Inventaire inventaire, Sid sid){
        super("bois", terrain, inventaire, sid);
    }

    public void fonction(int x, int y){
        // Pas de fonctionnalité
    }
}
