package vue;

import controller.Controleur;
import javafx.scene.control.Label;
import model.CommandeInt;

public class VueNbCoupIHMFX  {
    Controleur controleur;
    public Label label = new Label("0");
    CommandeInt commande;

    public VueNbCoupIHMFX(Controleur controleur) {
        this.controleur=controleur;
        commande = controleur.commandeNbCoup();
    }

    public void dessine() {
        label.setText(commande.exec()+"");
    }
}
