package control.handler;

import control.Controleur;
import control.ControleurAutonomie;
import model.Terrain;
import vue.Demarrage;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;

public class GaucheHandler implements ActionHandler {
    @Override
    public void handle(Controleur controleur, Terrain model, SimpleLogo vue, ActionEvent event) {

        try {
            int valeur = Integer.parseInt(vue.getInputValue());
            controleur.getTortueCourante().gauche(valeur);
        } catch (NumberFormatException ex) {
            System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
        }
    }

}
