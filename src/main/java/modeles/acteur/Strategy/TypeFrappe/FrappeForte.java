package modeles.acteur.Strategy.TypeFrappe;


import modeles.acteur.Strategy.TypeFrappe.Prototype.AttaquePrototype;

public class FrappeForte extends AttaqueTemplate implements AttaquePrototype {

    @Override protected int degats() {
        return 10;
    }

    @Override protected int cooldownTicks() {
        return 45;
    }

    @Override
    public AttaquePrototype cloner() {
        return new FrappeForte();
    }
}