package control.handler;

import control.Controleur;
import control.ControleurAutonomie;
import control.ControleurTortue;
import model.Terrain;
import model.Tortue;
import model.mouvement.Rectiligne;
import model.tortue.TortueRond;
import model.tortue.TortueTriangle;
import vue.Demarrage;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;

public class AjouterHandler implements ActionHandler {
    @Override
    public void handle(Controleur controleur, Terrain model, SimpleLogo vue, ActionEvent event) {
        ((ControleurTortue)controleur).addTortue(new TortueRond(
                model.getLargeur() / 2,
                model.getHauteur() / 2,
                vue.getCouleur(),
                new Rectiligne(model)));

    }
}
