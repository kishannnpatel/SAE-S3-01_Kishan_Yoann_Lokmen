package modeles.acteur.Strategy.TypeFrappe.Prototype;

import modeles.acteur.Strategy.TypeFrappe.Attaque;
import modeles.acteur.Strategy.TypeFrappe.FrappeForte;
import modeles.acteur.Strategy.TypeFrappe.FrappeMoyenne;

import java.util.HashMap;
import java.util.Map;

public class RegistrePrototypesAttaque {

    private final Map<String, AttaquePrototype> protos = new HashMap<>();
    public RegistrePrototypesAttaque() {
        protos.put("moyenne", new FrappeMoyenne());
        protos.put("forte",   new FrappeForte());
    }
    public Attaque creerDepuisPrototype(String type) {
        return protos.get(type).cloner();
    }
}
