package modeles.acteur;

import javafx.beans.property.*;
import javafx.scene.input.KeyCode;
import modeles.monde.Environnement;
import modeles.objets.Inventaire;
import modeles.objets.Objets;

import java.util.Set;

public class Sid extends Acteur {

    private final StringProperty directionProperty = new SimpleStringProperty("base");
    private final BooleanProperty estRalenti = new SimpleBooleanProperty(false);

    private Objets objetEnMain = null;

    private static final double SAUT_FORCE = -8;
    private boolean aDejaSaute = false;
    private final Inventaire inventaire;
    private int finRalenti;

    public Sid(Environnement env) {
        super("Sid", 50, 100, 100, 25, 55);
        this.inventaire = new Inventaire();
    }

    public StringProperty getDirection() { return directionProperty; }
    public void setDirection(String direction) { directionProperty.set(direction); }

    public Inventaire getInventaire() { return inventaire; }

    public BooleanProperty estRalentiProperty() { return estRalenti; }
    public boolean isEstRalenti() { return estRalenti.get(); }
    public void setEstRalenti(boolean ralenti) { estRalenti.set(ralenti); }

    private int calculerDeplacementX(Set<KeyCode> touches) {
        int vitesse = isEstRalenti() ? 2 : 4;
        int dx = 0;
        if (touches.contains(KeyCode.D)) {
            setDirection("droite");
            dx += vitesse;
            if (isEstRalenti()) finRalenti++;
        }
        if (touches.contains(KeyCode.Q)) {
            setDirection("gauche");
            dx -= vitesse;
            if (isEstRalenti()) finRalenti++;
        }
        return dx;
    }

    private void gererSaut(Set<KeyCode> touches) {
        boolean veutSauter = touches.contains(KeyCode.SPACE);
        if (veutSauter) {
            if (!enSaut && !aDejaSaute) {
                vitesseY = SAUT_FORCE;
                enSaut = true;
                aDejaSaute = true;
            }
        } else {
            aDejaSaute = false;
        }
    }

    @Override
    public void agir(Set<KeyCode> touches) {
        if (finRalenti == 240) { finRalenti = 0; setEstRalenti(false); }
        moveX(calculerDeplacementX(touches));
        gererSaut(touches);
    }
    public boolean objetPresent(){
        if(this.objetEnMain !=null){
            return true;
        }
        return false;
    }
    public void utiliserObjet(int x,int y){
        if(objetPresent()){
            objetEnMain.fonction(x,y);
        }
        else{System.out.println("Sid n'a pas d'objet en main");}
    }

    public Objets getObjetEnMain() { return objetEnMain; }
    public void setObjetEnMain(Objets objet) { this.objetEnMain = objet; }
}