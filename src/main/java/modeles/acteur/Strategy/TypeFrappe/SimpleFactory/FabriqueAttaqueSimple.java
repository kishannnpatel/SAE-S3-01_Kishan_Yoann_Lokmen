package modeles.acteur.Strategy.TypeFrappe.SimpleFactory;

import modeles.acteur.Strategy.TypeFrappe.Attaque;
import modeles.acteur.Strategy.TypeFrappe.FrappeForte;
import modeles.acteur.Strategy.TypeFrappe.FrappeMoyenne;

public class FabriqueAttaqueSimple {
    public Attaque cree(TypeAttaque type){
        return switch (type){
            case MOYENNE -> new FrappeMoyenne();
            case FORTE  -> new FrappeForte();
            case CUSTOM -> new FrappeMoyenne();
        };
    }
}
