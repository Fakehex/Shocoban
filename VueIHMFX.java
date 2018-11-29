package vue;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.CommandeTabInt;
import controller.Controleur;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VueIHMFX {

    CommandeTabInt commandeGetEtat;
    public Button[] myButton;
    public GridPane gridPane = new GridPane();

    Image[] chameau = new Image[]{ new Image(new FileInputStream(
            "chameau0.gif"),80,80,false,false),
            new Image(new FileInputStream(
                    "chameau1.png"),80,80,false,false),
            new Image(new FileInputStream(
                    "chameau2.jpg"),80,80,false,false)};


    public VueIHMFX(Controleur controleur) throws FileNotFoundException {
        commandeGetEtat = controleur.commandeGetEtat();
        myButton = new Button[commandeGetEtat.exec().length];
        for (int i=0;i<commandeGetEtat.exec().length;i++) {
            myButton[i] = new Button();
            myButton[i].setMinSize(80,80);
            gridPane.add(myButton[i],i,0);
        }
        dessine();
    }

    public void dessine() {
        for (int i=0;i<commandeGetEtat.exec().length;i++) {
            myButton[i].setGraphic(new ImageView(chameau[commandeGetEtat.exec()[i]]));
        }
    }
}
