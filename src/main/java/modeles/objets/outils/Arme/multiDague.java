package modeles.objets.outils.Arme;

import modeles.acteur.Sid;
import modeles.monde.Terrain;
import modeles.objets.Inventaire;

public class multiDague extends Dague{
    private Dague dague;
    private String competence;
   public multiDague(Terrain terrain, Inventaire inventaire, Sid sid, int degat,Dague dague){
       super(terrain,inventaire,sid,degat);
       this.dague = dague;
       this.competence  = this.dague.utiliserCompetence() + utiliserCompetence();
   }

}
