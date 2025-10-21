package modeles.objets.outils.Arme;


import modeles.acteur.Sid;
import modeles.monde.Terrain;
import modeles.objets.Inventaire;
import modeles.objets.outils.Arme.Arme;

public class Dague extends Arme {
    String competence;

    public Dague(Terrain terrain, Inventaire inventaire, Sid sid, int degat){
        super( terrain, inventaire, sid,degat,128);
        this.competence = "la competence sers juste a montrer l'utilité d'un designpattern decorateur() "+degat;
    }
    public String utiliserCompetence(){
        return competence;
    }
}
