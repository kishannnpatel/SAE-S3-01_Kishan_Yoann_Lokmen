package modeles.acteur.Strategy.TypeFrappe;

import modeles.acteur.Sid;
import modeles.acteur.Yeti;

public abstract class AttaqueTemplate implements Attaque {

    protected abstract int degats();
    protected abstract int cooldownTicks();
    
    protected  void appliqueEffect(Yeti yeti , Sid sid){
        sid.setEstRalenti(true);
    }

    @Override
    public void executer(Yeti yeti) {
       
        Sid sid = yeti.cible();
        if (sid == null || !sid.estVivant()) {
            return;
        }
        System.out.println( getClass().getSimpleName() + " utilisée !");
        
        if (yeti.getCompteurDegats() == 0) {
            sid.decrementerPv(degats());
            appliqueEffect(yeti, sid);
        }

        yeti.setCompteurDegats(yeti.getCompteurDegats() + 1);

        if (yeti.getCompteurDegats() >= cooldownTicks()) {
            sid.decrementerPv(degats());
            appliqueEffect(yeti, sid);
            yeti.setCompteurDegats(0);

        }
    }
}
