package modeles.acteur;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.input.KeyCode;
import modeles.monde.Environnement;
import modeles.objets.EclatFeu;
import java.util.Set;

public class Sorcier extends Acteur {

    private final Sid sid;

    private final StringProperty direction = new SimpleStringProperty("occupe");   // ou "discute"
    private final StringProperty orientation = new SimpleStringProperty("droite"); // ou "gauche"
    private boolean occupe = true;

    public Sorcier(Environnement env, Sid sid) {
        super("Sorcier", 10, 995, 250, 45, 62);
        this.sid = sid;
    }

    @Override
    public void agir(Set<KeyCode> touches) {
        int dx = sid.getX() - getX();
        EclatFeu feu = new EclatFeu(sid.getEnvironnement().getTerrain(), sid.getInventaire(), sid);

        // Orientation
        orientation.set(dx > 0 ? "droite" : "gauche");

        // "discute" vs "occupe"
        if (Math.abs(dx) > 50) {
            occupe = false;
            direction.set("discute");
        } else {
            occupe = true;
            direction.set("occupe");
        }

        if (sid.getHitbox().collisionAvec(this.getHitbox())) {
            if (!sid.getInventaire().aAssez(feu, 1)) {
                sid.getInventaire().ajouter(feu, 1);
            } else {
                System.out.println("déjà récolté");
            }
        }
    }

    public StringProperty getDirection() { return direction; }
    public StringProperty getOrientation() { return orientation; }
    public boolean isOccupe() { return occupe; }
}