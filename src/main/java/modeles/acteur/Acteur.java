package modeles.acteur;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.input.KeyCode;
import modeles.Hitbox;
import modeles.monde.Environnement;

import java.util.ArrayList;
import java.util.Set;

public abstract class Acteur {

    private final String nom;
    protected final IntegerProperty pv;
    private final Environnement environnement;
    private final IntegerProperty x, y;
    protected boolean enSaut = false;

    protected double vitesseY = 0;
    protected double gravite()    { return 0.4; }              // chiffre variable
    protected int    piedOffset() { return this.hitboxHeight; }

    // >>> nouveau : hitbox gérée ici (centralisation)
    protected final Hitbox hitbox;
    protected final int hitboxWidth;
    protected final int hitboxHeight;

    public Acteur(String nom, int pv, int x, int y,
                  int hitboxWidth, int hitboxHeight) {
        this.nom = nom;
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.pv = new SimpleIntegerProperty(pv);
        this.environnement = Environnement.getInstance();
        this.hitboxWidth = hitboxWidth;
        this.hitboxHeight = hitboxHeight;
        this.hitbox = new Hitbox(x, y, hitboxWidth, hitboxHeight);
    }

    public ArrayList<Acteur> getActeursAutour() { return Environnement.getInstance().getActeurs(); }

    public String getNom(){ return this.nom; }

    public int getPv() { return pv.get(); }
    public IntegerProperty pvProperty() { return pv; }

    public int getX() { return x.get(); }
    public int getY() { return y.get(); }
    public IntegerProperty getXProperty(){ return this.x; }
    public IntegerProperty getYProperty(){ return this.y; }

    public void setX(int n){
        x.set(n);
        hitbox.setPosition(getX(), getY()); // keep in sync
    }
    public void setY(int n){
        y.set(n);
        hitbox.setPosition(getX(), getY()); // keep in sync
    }

    public Environnement getEnvironnement(){ return this.environnement; }

    public Hitbox getHitbox() { return this.hitbox; }

    public void decrementerPv(int n) { this.pv.set(getPv() - n); }
    public void incrementerPv(int n) { this.pv.set(getPv() + n); }
    public boolean estVivant() { return getPv() > 0; }

    // >>> nouveau : déplacements sécurisés + màj hitbox + collision
    public final void moveX(int dx) {
        if (dx == 0) return;                        // si aucun déplacement, on ne fait rien
        final int nx = getX() + dx;                 // calcule la nouvelle position X
        hitbox.setPosition(nx, getY());             // déplace temporairement la hitbox à la nouvelle position
        if (!collisionAvecBlocs()) {                // si pas de collision...
            x.set(nx);                              // ...on applique le déplacement
        }
        hitbox.setPosition(getX(), getY());         // synchronise la hitbox avec la position finale
    }

    public final void moveY(int dy) {
        if (dy == 0) return;                        // inutile de bouger si dy = 0
        final int ny = getY() + dy;                 // calcule la nouvelle position Y
        hitbox.setPosition(getX(), ny);             // met la hitbox à jour
        if (!collisionAvecBlocs()) {                // pas de collision ?
            y.set(ny);                              // on bouge l’acteur
        }
        hitbox.setPosition(getX(), getY());         // on remet la hitbox à la bonne place
    }

    // >>> nouveau : collision commune
    protected final boolean collisionAvecBlocs() {
        for (Hitbox bloc : Environnement.getInstance().getTerrain().getHitboxBlocsSolides()) {
            if (hitbox.collisionAvec(bloc)) return true;
        }
        return false;
    }

    protected boolean auSol() {
        hitbox.setPosition(getX(), getY() + 1);
        boolean col = collisionAvecBlocs();
        hitbox.setPosition(getX(), getY());
        return col;
    }

    // contrat des sous-classes (inchangé)
    public abstract void agir(Set<KeyCode> touches);

    // chiffre variable

    public final void appliquerGravite(int[][] map, int tailleBloc) {
        vitesseY += gravite();
        int dy = (int) Math.floor(vitesseY);
        if (dy != 0) {
            int oldY = getY();
            moveY(dy);
            if (getY() == oldY && vitesseY > 0) {
                vitesseY = 0;
                enSaut   = false;
            } else {
                enSaut = !auSol();
            }
        } else {
            enSaut = !auSol();
        }
        if (auSol() && vitesseY > 0) {
            vitesseY = 0;
            enSaut = false;
        }
    }


    @Override
    public String toString() { return "x=" + getX() + ", y=" + getY(); }
}