package control;


import model.Terrain;
import model.Tortue;
import model.mouvement.Aleatoire;

import java.util.Iterator;

public class ControleurAutonomie extends Controleur {

    private Thread thread;

    public ControleurAutonomie(Terrain model) {
        super(model);
        defaultMouvementStrategie = new Aleatoire(model);


        final ControleurAutonomie myself = this;
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    myself.bouger();
                    try {
                        Thread.sleep(28);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void lancer() {
        thread.start();
    }

    public void addTortue(Tortue tortue) {
        tortue.setMouvement(defaultMouvementStrategie);
        super.addTortue(tortue);
    }

    private void bouger() {
        Iterator<Tortue> tortues = terrain.getTortues();
        while (tortues.hasNext()) {
            Tortue tortue = tortues.next();
            tortue.avancer();
        }
        System.out.println("on a bougé");
    }
}
