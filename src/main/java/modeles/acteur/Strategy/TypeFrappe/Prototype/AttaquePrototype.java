package modeles.acteur.Strategy.TypeFrappe.Prototype;

import modeles.acteur.Strategy.TypeFrappe.Attaque;

public interface AttaquePrototype extends Attaque {
    AttaquePrototype cloner();
}
