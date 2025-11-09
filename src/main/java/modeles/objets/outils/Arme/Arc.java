package modeles.objets.outils.Arme;


import modeles.acteur.Sid;
import modeles.monde.Terrain;
import modeles.objets.Inventaire;
import modeles.objets.outils.Arme.Arme;

public class Arc extends Arme {
    private final int DISTANCE_MAX = 320;
        public Arc(Terrain terrain, Inventaire inventaire, Sid sid, int degat){
            super( terrain, inventaire, sid,degat,320);

        }


}
