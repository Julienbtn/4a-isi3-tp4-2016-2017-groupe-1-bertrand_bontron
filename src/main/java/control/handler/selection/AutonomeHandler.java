package control.handler.selection;

import control.Controleur;
import control.ControleurAutonomie;
import control.handler.ActionHandler;
import model.Terrain;
import model.Tortue;
import model.mouvement.Aleatoire;
import model.mouvement.MouvementStrategie;
import model.tortue.TortueCerfVolant;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;
import java.util.Random;

public class AutonomeHandler implements ActionHandler {
    @Override
    public void handle(Controleur controleur, Terrain model, SimpleLogo vue, ActionEvent event) {

        model = new Terrain(600, 400);
        ControleurAutonomie controleurAutonomie = new ControleurAutonomie(model);
        vue = new SimpleLogo(model, controleurAutonomie);

        MouvementStrategie mouvement = new Aleatoire(model);

        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            controleurAutonomie.addTortue(new TortueCerfVolant(
                    rand.nextInt(500) + 50,
                    rand.nextInt(300) + 50,
                    rand.nextInt(3),
                    mouvement));
        }
        controleurAutonomie.lancer();
    }
}
