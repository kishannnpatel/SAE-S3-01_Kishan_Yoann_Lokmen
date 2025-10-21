package modeles.objets.outils;


import modeles.acteur.Sid;
import modeles.monde.Terrain;
import modeles.objets.Glace;
import modeles.objets.Inventaire;
import modeles.objets.Neige;

public class Pioche extends Outil {

    public Pioche(Terrain terrain, Inventaire inventaire, Sid sid){
        super("pioche", terrain, inventaire, sid);
    }

    public void fonction(int x, int y){
            int[][] map = getTerrain().getMap();
            if (map[y][x] == 1) {
                map[y][x] = -1;
                // Plus tard : ajouter à l'inventaire
                getInventaire().ajouterItem(new Neige(getTerrain(), getSid().getInventaire(), getSid()));
                System.out.println("Ajoute de neige");

                getTerrain().mettreAJourHitboxBlocsSolides();
                System.out.println("Bloc cassé");
            } else if (map[y][x] == 2){
                map[y][x] = -1;
                // Plus tard : ajouter à l'inventaire
                getInventaire().ajouterItem(new Glace(getTerrain(), getSid().getInventaire(), getSid()));

                getTerrain().mettreAJourHitboxBlocsSolides();
                System.out.println("Bloc cassé");
            }
    }
}
