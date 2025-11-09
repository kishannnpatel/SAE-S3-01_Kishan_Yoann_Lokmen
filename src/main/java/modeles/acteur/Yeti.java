package modeles.acteur;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.input.KeyCode;
import modeles.acteur.Strategy.Chasse;
import modeles.acteur.Strategy.Comportement;
import modeles.acteur.Strategy.Frappe;
import modeles.acteur.Strategy.Repos;
import modeles.monde.Environnement;

import java.util.Set;

public class Yeti extends Acteur {

    private final StringProperty direction = new SimpleStringProperty("immobile");
    private static final int VITESSE_X = 2;
    private boolean frappeEnCours = false;
    private int compteurDegats = 0;

    // Strategy
    private static final int PORTEE_FRAPPE = 20;
    private static final int PORTEE_CHASSE = 180;
    private static final int SEUIL_VERTICAL = 50;

    private final Sid sid;


    public Yeti(Environnement env, Sid sid) {
        super("Yeti", 100, 800, 350,  60, 60);
        this.sid = sid;
    }

    // Strategy Methode

    public int vitesseX() {
        return VITESSE_X;
    }

    public int getCompteurDegats() {
        return compteurDegats;
    }

    public void setCompteurDegats(int compteurDegats) {
        this.compteurDegats = compteurDegats;
    }

    public void setFrappeEnCours(boolean frappeEnCours) {
        this.frappeEnCours = frappeEnCours;
    }

    public void immobile() {
       setDirection("immobile");
    }

    public void orienterVers(int dx){
        setDirection(dx > 0 ? "droite" : "gauche");
    }

    public Sid cible(){
        return sid;
    }

    public StringProperty getDirection() { return direction; }
    public void setDirection(String direction) { this.direction.set(direction); }
    public boolean isFrappeEnCours() { return frappeEnCours; }

    @Override
    public void agir(Set<KeyCode> touches) {
        if (!estPretAAgir()) { arreterAction(); return; }

        int dx = sid.getX() - getX();
        int dy = sid.getY() - getY();

        Comportement strat = choisirStrat(dx, dy);
        strat.agir(this, dx, dy);
    }

    private Comportement choisirStrat(int dx, int dy) {
        if (Math.abs(dy) > SEUIL_VERTICAL) return new Repos();
        if (Math.abs(dx) <= PORTEE_FRAPPE)   return new Frappe();
        if (Math.abs(dx) <= PORTEE_CHASSE)   return new Chasse();
        return new Repos();
    }

    private boolean estPretAAgir() { return getPv() >= 0 && sid != null && sid.estVivant(); }

    private void arreterAction() {
        frappeEnCours = false;
        setDirection("immobile");
    }

}