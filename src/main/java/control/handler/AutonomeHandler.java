package control.handler;

import control.Controleur;
import control.ControleurAutonomie;
import model.Terrain;
import model.Tortue;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;
import java.util.Random;

public class AutonomeHandler implements ActionHandler {
    public void handle(Controleur controleur, Terrain model, SimpleLogo vue, ActionEvent event) {
        model = new Terrain(600, 400);
        ControleurAutonomie controleurAutonomie = new ControleurAutonomie(model);
        vue = new SimpleLogo(model, controleurAutonomie);

        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            controleurAutonomie.addTortue(new Tortue(rand.nextInt(500) + 50, rand.nextInt(300) + 50, rand.nextInt(3)));
        }
        controleurAutonomie.lancer();
    }
}
