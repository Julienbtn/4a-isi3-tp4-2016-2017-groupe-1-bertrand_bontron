package control;


import model.Terrain;

public class ControleurAutonomie extends ControleurTortue {

    private Thread thread;

    public ControleurAutonomie(Terrain model) {
        super(model);


        final ControleurAutonomie myself = this;
        thread = new Thread(() -> {
            while (true) {
                myself.bouger();
                try {
                    Thread.sleep(28);
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
