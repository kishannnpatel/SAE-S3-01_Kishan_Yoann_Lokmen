package modeles.objets;


import modeles.acteur.Sid;
import modeles.monde.Terrain;
import modeles.objets.Inventaire;
import modeles.objets.Ressource;

public class EclatFeu extends Ressource {

    public EclatFeu(Terrain terrain, Inventaire inventaire, Sid sid){
        super("eclat_feu", terrain, inventaire, sid);
    }

    public void fonction(int x, int y){
        // Pas de fonctionnalité
    }
}
