package modeles.acteur.Strategy.TypeFrappe;


import modeles.acteur.Strategy.TypeFrappe.Prototype.AttaquePrototype;

public class FrappeMoyenne extends AttaqueTemplate implements AttaquePrototype {

    @Override protected int degats() {
        return 5;
    }

    @Override protected int cooldownTicks() {
        return 30;
    }

    @Override
    public AttaquePrototype cloner() {
        return new FrappeMoyenne();
    }
}