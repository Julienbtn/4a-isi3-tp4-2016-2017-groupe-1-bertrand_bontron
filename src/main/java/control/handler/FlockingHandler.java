package control.handler;

import control.Controleur;
import control.ControleurAutonomie;
import control.ControleurFlocking;
import model.Terrain;
import model.Tortue;
import vue.Demarrage;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;
import java.util.Random;

public class FlockingHandler implements ActionHandler {
    @Override
    public void handle(Controleur controleur, Terrain model, SimpleLogo vue, ActionEvent event) {

        model = new Terrain(600, 400);
        ControleurFlocking controleurFlocking = new ControleurFlocking(model);
        vue = new SimpleLogo(model, controleurFlocking);

        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            controleurFlocking.addTortue(new Tortue(
                    rand.nextInt(500) + 50,
                    rand.nextInt(300) + 50,
                    rand.nextInt(10),
                    rand.nextDouble() * 10,
                    rand.nextInt(360)));
        }
        controleurFlocking.lancer();
    }
}
