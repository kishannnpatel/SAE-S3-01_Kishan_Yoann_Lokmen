package modeles.acteur.Strategy;

import modeles.acteur.Yeti;

public interface Comportement {

    void agir(Yeti self, int dx, int dy);

}
