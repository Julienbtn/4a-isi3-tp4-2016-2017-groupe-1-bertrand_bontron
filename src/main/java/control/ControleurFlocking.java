package control;

import model.Terrain;
import model.mouvement.Flocking;


public class ControleurFlocking extends ControleurAutonomie {

    public ControleurFlocking(Terrain model) {
        super(model);
        this.defaultMouvementStrategie = new Flocking(model, 20, 0.05);
    }
}
