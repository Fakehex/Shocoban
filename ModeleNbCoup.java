package model;


public class ModeleNbCoup implements Modele {
    Modele modele;
    int nbCoup =0;

    public ModeleNbCoup(Modele modele) {
        this.modele = modele;
    }

    public int nbCoup(){
        return nbCoup;
    }
    public int[] getEtat(){
        return modele.getEtat();
    }
    public void move(int indice) {
        nbCoup++;
        modele.move(indice);
    }
    public void reset(){
        nbCoup=0;
        modele.reset();
    }

}
