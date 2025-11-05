package modeles.acteur.Strategy;

import modeles.acteur.Yeti;

public class Repos implements Comportement {
    @Override
    public void agir(Yeti yeti, int dx, int dy) {
        yeti.setFrappeEnCours(false);
        yeti.immobile();
    }


}
