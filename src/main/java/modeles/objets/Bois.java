package modeles.objets;

import modeles.acteur.Sid;
import modeles.monde.Terrain;
import modeles.objets.Ressource;
import modeles.objets.strategies.ComportementInactif;


public class Bois extends Ressource {

    public Bois(Terrain terrain, Inventaire inventaire, Sid sid){
        super("bois", terrain, inventaire, sid, new ComportementInactif());
    }

    public void fonction(int x, int y){
        // Pas de fonctionnalité
    }
}
