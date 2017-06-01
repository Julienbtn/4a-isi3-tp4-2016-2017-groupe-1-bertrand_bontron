package control;


import control.handler.ResetHandler;
import model.Terrain;

public class ControleurAutonomie extends ControleurTortue {

    public static int FPS = 60;

    private Thread thread;

    public ControleurAutonomie(Terrain model) {
        super(model);


        final ControleurAutonomie myself = this;
        thread = new Thread(() -> {
            while (true) {
                myself.bouger();
                try {
                    Thread.sleep(1000 / FPS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void lancer() {
        thread.start();
    }


    private void bouger() {
        terrain.pasSuivant();
    }
}
