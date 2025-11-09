package modeles.objets.outils.Arme;

import modeles.acteur.Sid;
import modeles.monde.Terrain;
import modeles.objets.Inventaire;

public class decorateurArme extends Arme{
    private Arme arme;
    private String competence;
   public decorateurArme(Terrain terrain, Inventaire inventaire, Sid sid, int degat, Arme armee){
       super(terrain,inventaire,sid,degat,armee.getDISTANCE_MAX());
       this.arme = armee;
       this.competence  = this.arme.utiliserCompetence() + utiliserCompetence();
   }

}
