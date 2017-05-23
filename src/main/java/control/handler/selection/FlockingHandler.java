package control.handler.selection;

import control.Controleur;
import control.ControleurAutonomie;
import control.handler.ActionHandler;
import model.Terrain;
import model.mouvement.Flocking;
import model.mouvement.FlockingRaciste;
import model.mouvement.MouvementStrategie;
import model.tortue.TortueRond;
import model.tortue.TortueTriangle;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;
import java.util.Random;

public class FlockingHandler implements ActionHandler {
    @Override
    public void handle(Controleur controleur, Terrain model, SimpleLogo vue, ActionEvent event) {

        model = new Terrain(600, 400);
        ControleurAutonomie controleurFlocking = new ControleurAutonomie(model);
        vue = new SimpleLogo(model, controleurFlocking);

        MouvementStrategie mouvement = new FlockingRaciste(model, 50);

        Random rand = new Random();

        for (int i = 0; i < 100; i++) {
            controleurFlocking.addTortue(new TortueTriangle(
                    rand.nextInt(500) + 50,
                    rand.nextInt(300) + 50,
                    rand.nextInt(10),
                    rand.nextDouble() * 10,
                    rand.nextInt(360),
                    mouvement));
        }
        controleurFlocking.lancer();
    }
}
