package modeles.objets.outils.Arme;

import java.util.Random;

public class stratArc1 implements strategieArc{
    @Override
    public void lancerStrat(int degat) {
        //par exemple cette attaque permet de faire des coups critique
        Random random = new Random();
    // génere un nombre entre 0 et 99
        int nombre = random.nextInt(100);
        if(nombre <=33){
            degat=degat*3;
        }
    }
}
