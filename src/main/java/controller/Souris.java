package controller;

import com.example.sae_dev_kishan_yoann_lokmen.Refractor.OutilsSouris;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import modeles.acteur.Sid;
import modeles.monde.Terrain;
import modeles.objets.Inventaire;
import modeles.objets.Objets;
import modeles.objets.Outil;
import modeles.objets.Ressource;
import vues.monde.TerrainVue;

public class Souris {

    private Sid sid;
    private Terrain terrain;
    private static final int TAILLE_BLOC = 32;
    private TerrainVue terrainVue;
    private TilePane tilePane;
    private static final int DISTANCE_MAX = 128; // distance maximale autorisée (4 bloc)
    public boolean peutCasser = false;

    public Souris(Sid sid, Terrain terrain, TerrainVue terrainVue, TilePane tilePane) {
        this.sid = sid;
        this.terrain = terrain;
        this.terrainVue = terrainVue;
        this.tilePane = tilePane;
    }

    private void executerActionSurObjet(int x, int y, Class<?> typeAttendu) {
        Objets objet = sid.getObjetEnMain();
        if (objet != null && typeAttendu.isInstance(objet)) {
            objet.fonction(x, y);
        }
        terrainVue.afficherMap(tilePane);
    }

    private void clic_gauche(int x, int y) {
        executerActionSurObjet(x, y, Outil.class);
    }

    private void clic_droit(int x, int y) {
        executerActionSurObjet(x, y, Ressource.class);
    }

    public void gererClic(MouseEvent event) {
        int sourisX = (int) event.getX();
        int sourisY = (int) event.getY();

        int blocX = OutilsSouris.toBloc(sourisX, TAILLE_BLOC);
        int blocY = OutilsSouris.toBloc(sourisY, TAILLE_BLOC);

        int persoX = sid.getX();
        int persoY = sid.getY() + 28;

        // early return si hors portée
        if (OutilsSouris.distanceCarree(persoX, persoY, sourisX, sourisY) > DISTANCE_MAX * DISTANCE_MAX) return;

        // dispatch compact
        switch (event.getButton()) {
            case PRIMARY   -> clic_gauche(blocX, blocY);
            case SECONDARY -> clic_droit(blocX, blocY);
            default        -> {} // pour plus tard si on rajoute des fonctions
        }
    }

    // Utiliser par les outil ou arme afin de casser ou attaquer
    /*private void clic_gauche(int x, int y) {
        Objets objets = sid.getObjetEnMain();
        if (objets != null && objets instanceof Outil) {
            objets.fonction(x, y);
        }
        terrainVue.afficherMap(tilePane);
    }

    // Utiliser par les ressources posable afin d'être poser
    private void clic_droit(int x, int y) {
        Objets objets = sid.getObjetEnMain();
        if (objets != null && objets instanceof Ressource) {
            objets.fonction(x, y);
        }
        terrainVue.afficherMap(tilePane);
    }*/

    // Gère les clic
    /*public void gererClic(MouseEvent event) {
        int sourisX = (int) event.getX();
        int sourisY = (int) event.getY();

       //  int blocX = sourisX / TAILLE_BLOC;
      // int blocY = sourisY / TAILLE_BLOC;

        // refractor1
        int blocX = MouseMath.toBloc(sourisX, TAILLE_BLOC);
        int blocY = MouseMath.toBloc(sourisY, TAILLE_BLOC);

        int persoX = sid.getX();
        int persoY = sid.getY() + 28;

        int dx = persoX - sourisX;
        int dy = persoY - sourisY;

       //q  int distanceCarree = dx * dx + dy * dy;
        // refractor1
        int distanceCarree = MouseMath.distanceCarree(persoX, persoY, sourisX, sourisY);
        if (distanceCarree <= DISTANCE_MAX * DISTANCE_MAX) {
            if (event.getButton() == MouseButton.PRIMARY) {
                clic_gauche(blocX, blocY);
            } else if (event.getButton() == MouseButton.SECONDARY) {
                clic_droit(blocX, blocY);
            }
        }
    }*/



}
