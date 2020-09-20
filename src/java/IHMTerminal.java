package sample;

import controller.Controleur;
import model.Observateur;

import java.util.Scanner;

public class IHMTerminal implements Observateur {
    Controleur controleur;
    Scanner scanner = new Scanner(System.in);

    @Override
    public void actualise() {
        dessine();
        System.out.print(">");
    }

    void dessine() {
        int[] etat= controleur.commandeGetEtat().exec();
        for (int e:etat)
            System.out.print(e + " ");
        System.out.println("");
    }

    public void lance() {
        controleur = Controleur.getControleur();
        controleur.abonne(this);
        dessine();
        System.out.print(">");

        boolean fin = false;
        while (!fin) {
            String commande = scanner.next();
            if (commande.equals("f"))
                fin = true;
            else if (commande.equals("r"))
                controleur.reset();
            else
                try {
                    int coup = Integer.parseInt(commande);
                    controleur.move(coup);
                } catch (Exception e) {
                    System.out.print("non!>");
                }
        }
    }
}
