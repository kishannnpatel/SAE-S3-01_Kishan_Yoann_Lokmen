package modeles.objets.outils.Arme;


import modeles.acteur.Sid;
import modeles.monde.Terrain;
import modeles.objets.Inventaire;
import modeles.objets.outils.Arme.Arme;

public class Dague extends Arme {

    public Dague(Terrain terrain, Inventaire inventaire, Sid sid, int degat){
        super( terrain, inventaire, sid,degat,128);
    }
}
