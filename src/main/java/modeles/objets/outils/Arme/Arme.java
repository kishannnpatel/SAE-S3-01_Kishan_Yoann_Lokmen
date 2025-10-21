package modeles.objets.outils.Arme;

import modeles.acteur.Acteur;
import modeles.acteur.Sid;
import modeles.acteur.Yeti;
import modeles.monde.Terrain;
import modeles.objets.Inventaire;
import modeles.objets.outils.Outil;

public abstract class Arme extends Outil {

    private final int DISTANCE_MAX;
    private int degat;
    private strategieArc strat;
    public Arme(Terrain terrain, Inventaire inventaire, Sid sid,int degat,int distanceMax){
        super("arme", terrain, inventaire, sid);
        this.degat = degat;
        this.DISTANCE_MAX = distanceMax;
        this.strat = null;
    }
//template : un code commun mais on met la partie qui change dans le code des sous classes
    public void fonction(int x, int y){
        //attaquer
        int sourisX = x * 32;
        int sourisY = y * 32;
        int persoX = getSid().getX();
        int persoY = getSid().getY() + 28;
        int dx = persoX - sourisX;
        int dy = persoY - sourisY;
        int distanceCarree = dx * dx + dy * dy;
        if (distanceCarree <= DISTANCE_MAX * DISTANCE_MAX) {
            for (Acteur a : getSid().getActeursAutour()) {
                if (a instanceof Yeti yeti) {
                    if (yeti.getHitbox().contientPoint(sourisX, sourisY)) {
                        if (yeti.getHitbox().collisionAvec(getSid().getHitbox())) {
                            //ici on utilisera la strat
                            this.strat.lancerStrat(this.degat);
                            yeti.decrementerPv(this.degat);
                            System.out.println("Yeti frappé ! PV restants : " + yeti.getPv());
                        }
                    }
                }
            }
        }
    }
    public int getDegat(){
        return this.degat;
    }
    public void changerStrat(strategieArc strate){
        this.strat=strate;
    }
}

