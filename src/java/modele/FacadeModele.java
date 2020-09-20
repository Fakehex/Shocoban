package model;

public class FacadeModele {
    ModeleNbCoup modele = new ModeleNbCoup(new ModeleConcret());

    public void move(int x) {
        modele.move(x);
    }

    public void reset() {
        modele.reset();
    }

    public int nbCoup() {
        return modele.nbCoup;
    }

    public int[] getEtat() {
        return modele.getEtat();
    }

}
