package modeles.acteur.Strategy;

import modeles.acteur.Strategy.TypeFrappe.Prototype.RegistrePrototypesAttaque;
import modeles.acteur.Yeti;
import modeles.acteur.Strategy.TypeFrappe.*;
import java.util.Random;

public class Frappe implements Comportement {

    private final RegistrePrototypesAttaque registre = new RegistrePrototypesAttaque();
    private final Random rng = new Random();

    @Override
    public void agir(Yeti self, int dx, int dy) {
        self.setFrappeEnCours(true);
        self.orienterVers(dx);

        Attaque attaque = choisir(dx);
        attaque.executer(self);
    }

    private Attaque choisir(int dx) {
        int dist = Math.abs(dx);
        Attaque choix;

        if (dist <= 10) {
            choix = rng.nextInt(100) < 60
                    ? registre.creerDepuisPrototype("forte")
                    : registre.creerDepuisPrototype("moyenne");
        } else {
            choix = registre.creerDepuisPrototype("moyenne");
        }

        System.out.println("Yeti à distance " + dist
                + " → choisit " + choix.getClass().getSimpleName());
        return choix;
    }
}