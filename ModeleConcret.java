package model;

public class ModeleConcret implements Modele {
    public int[] etat = {0,0,0,1,2,2,2};

    public int[] getEtat() {
        return etat;
    }

    public void move(int indice) {
        if (etat[indice]==0) {
            if (indice<etat.length-1 && etat[indice+1]==1) {
                etat[indice]=1; etat[indice+1]=0;
            }
            else if (indice<etat.length-2 && etat[indice+1]==2 && etat[indice+2]==1) {
                etat[indice]=1; etat[indice+2]=0;
            }
        }
        else if (etat[indice]==2) {
            if (indice>0 && etat[indice-1]==1) {
                etat[indice]=1; etat[indice-1]=2;
            }
            else if (indice>1 && etat[indice-1]==0 && etat[indice-2]==1) {
                etat[indice]=1; etat[indice-2]=2;
            }
        }
    }

    @Override
    public void reset() {
        etat =  new int[] {0,0,0,1,2,2,2};
    }
}
