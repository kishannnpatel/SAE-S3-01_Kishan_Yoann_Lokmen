package vues.acteur;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import modeles.acteur.Sorcier;

import java.util.Objects;

public class SorcierVue {

    private final Sorcier sorcier;
    private final ImageView imageView;

    private final Image imageOccupeDroite;
    private final Image imageOccupeGauche;
    private final Image imageDiscuteDroite;
    private final Image imageDiscuteGauche;

    public SorcierVue(Sorcier sorcier, Pane zoneJeu) {
        this.sorcier = sorcier;

        imageOccupeDroite = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                "/images/Sorcier/OD.png")));
        imageOccupeGauche = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                "/images/Sorcier/OG.png")));
        imageDiscuteDroite = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                "/images/Sorcier/DD.png")));
        imageDiscuteGauche = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                "/images/Sorcier/DG.png")));

        imageView = new ImageView(imageOccupeDroite);
        imageView.setFitWidth(49);
        imageView.setFitHeight(64);

        imageView.xProperty().bind(sorcier.getXProperty().asObject());
        imageView.yProperty().bind(sorcier.getYProperty().asObject());

        sorcier.getDirection().addListener((obs, oldVal, newVal) -> updateImage());
        sorcier.getOrientation().addListener((obs, oldVal, newVal) -> updateImage());

        updateImage();
        zoneJeu.getChildren().add(imageView);
    }

    private void updateImage() {
        String etat = sorcier.getDirection().get();         // "discute" ou "occupe"
        String orientation = sorcier.getOrientation().get(); // "droite" ou "gauche"

        if (etat.equals("discute")) {
            imageView.setImage(orientation.equals("droite") ? imageDiscuteDroite : imageDiscuteGauche);
        } else {
            imageView.setImage(orientation.equals("droite") ? imageOccupeDroite : imageOccupeGauche);
        }
    }

    public ImageView getImageView() {
        return imageView;
    }
}