package model;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

import java.util.ArrayList;

public class MonteurScene {
    ArrayList<Region> bas = new ArrayList<Region>();
    Region centre;
    int largeur = 800;
    int hauteur = 400;

    public MonteurScene setLargeur(int l){
        largeur=l;
        return this;
    }

    public MonteurScene setHauteur(int l) {
        hauteur=l;
        return this;
    }

    public MonteurScene setCentre(Region node) {
        centre = node;
        return this;
    }

    public MonteurScene ajoutBas(Region node) {
        bas.add(node);
        return this;
    }

    public Scene retourneScene() {
        assert (centre !=null);
        GridPane gridPane = new GridPane();

        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(centre,0,0);
        gridPane.setMinSize(largeur, hauteur);
        centre.setMinSize(largeur, hauteur*7/8);

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        if (bas.size()!=0) {
            GridPane gridPaneBas = new GridPane();
            gridPaneBas.setAlignment(Pos.CENTER);
            gridPaneBas.setMinSize(largeur, hauteur/8);
            gridPaneBas.setPadding(new Insets(10, 10, 10, 10));
            //Setting the padding
            gridPane.setPadding(new Insets(10, 10, 10, 10));
            int i=0;
            for (Region n:bas) {
                n.setMinSize(largeur/bas.size(),hauteur/8);
                gridPaneBas.add(n,i,0);
                i++;
            }
            gridPane.add(gridPaneBas,0,1);
        }

        return new Scene(gridPane,largeur,hauteur);

    }
}
