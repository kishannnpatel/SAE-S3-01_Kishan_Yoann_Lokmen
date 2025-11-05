package modeles.acteur.Strategy;

import modeles.acteur.Yeti;

public class Chasse implements Comportement {
    @Override
    public void agir(Yeti self, int dx, int dy) {
        self.setFrappeEnCours(false);
        self.orienterVers(dx);
        self.moveX(dx > 0 ? self.vitesseX() : -self.vitesseX());
    }
}
