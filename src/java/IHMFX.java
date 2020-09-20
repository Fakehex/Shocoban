package sample;

import controller.Controleur;
import controller.ControleurIHMFX;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.MonteurScene;
import model.Observateur;
import vue.VueIHMFX;
import vue.VueNbCoupIHMFX;

public class IHMFX extends Application implements Observateur {
    VueNbCoupIHMFX vueNbCoup;
    VueIHMFX vue;

    public void actualise(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vueNbCoup.dessine();
                vue.dessine();
            }
        });
    };

    @Override
    public void start(Stage primaryStage) throws Exception{
        Controleur controleur = Controleur.getControleur();
        controleur.abonne(this);

        vue = new VueIHMFX(controleur);
        ControleurIHMFX controleurIHMFX = new ControleurIHMFX(controleur,vue);
        vue.gridPane.setAlignment(Pos.CENTER);
        vueNbCoup= new VueNbCoupIHMFX(controleur);
        vueNbCoup.label.setAlignment(Pos.CENTER);

        /* montage de la scene */
        MonteurScene monteurScene = new MonteurScene();

        Scene scene = monteurScene.
                setCentre(vue.gridPane).
                ajoutBas(controleurIHMFX.reset).
                ajoutBas(vueNbCoup.label).
                setLargeur(800).
                setHauteur(200).
                retourneScene();

        primaryStage.setScene(scene);

        primaryStage.setTitle("Chameaux");
        primaryStage.show();
    }

    public void lance() {
        launch(new String[]{});
    }
}

