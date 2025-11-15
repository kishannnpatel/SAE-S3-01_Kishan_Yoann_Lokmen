package modeles.monde;

import modeles.acteur.Acteur;

import java.util.ArrayList;

public class Environnement {

    private static Environnement uniqueInstance = null;
    private int width, height;
    private ArrayList<Acteur> acteurs;
    private Terrain terrain;

    private Environnement() {
        this.acteurs = new ArrayList<>();
        // Terrain basé sur la map définie dans la classe Terrain
        this.terrain = new Terrain();
        // Optionnel : tu peux déduire largeur/hauteur en pixels à partir de la map
        if (terrain.getMap() != null && terrain.getMap().length > 0) {
            int nbColonnes = terrain.getMap()[0].length;
            int nbLignes = terrain.getMap().length;
            int TAILLE_BLOC = 32; // même valeur que dans Terrain
            this.width = nbColonnes * TAILLE_BLOC;
            this.height = nbLignes * TAILLE_BLOC;
        }
    }

    public static Environnement getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Environnement();
        }
        return uniqueInstance;
    }

    public void initEnvironnement(int width, int height) {
        this.width = width;
        this.height = height;
        this.acteurs.clear(); // important si tu relances une partie

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ArrayList<Acteur> getActeurs() {
        return acteurs;
    }

    public void ajouterActeur(Acteur a) {
        acteurs.add(a);
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public boolean estDansLimite(int x, int y) {
        return (0 <= x && x < this.width && 0 <= y && y < this.height);
    }
}