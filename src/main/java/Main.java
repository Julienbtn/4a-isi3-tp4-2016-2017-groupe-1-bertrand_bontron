import control.Controleur;
import control.ControleurAutonomie;
import control.ControleurFlocking;
import control.handler.*;
import model.Terrain;
import model.Tortue;
import vue.Demarrage;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;
import java.util.Random;

public class Main {

    public static void main(String args[]) {
        Controleur controleur = new Controleur();

        controleur.overrideActionHandler("Tortues Dependantes", new Dependantehandler());
        controleur.overrideActionHandler("Tortues Autonomes", new AutonomeHandler());
        controleur.overrideActionHandler("Tortues Flocking", new FlockingHandler());
        Demarrage demarrage = new Demarrage(controleur);
        System.out.println(demarrage.getMouseMotionListeners());

        /*String methode = "";
        switch(methode){
            case "dependant":
                dependant();
                break;
            case "autonome":
                autonome();
                break;
            case "flocking":
                flocking();
                break;
            default:
              dependant();
        }*/
    }

    public static void autonome() {
        Terrain model = new Terrain(600, 400);
        ControleurAutonomie controleur = new ControleurAutonomie(model);
        SimpleLogo vue = new SimpleLogo(model, controleur);

        Random rand = new Random();

        for (int i = 0; i < 100; i++) {
            controleur.addTortue(new Tortue(rand.nextInt(500) + 50, rand.nextInt(300) + 50, rand.nextInt(10)));
        }
        controleur.lancer();
    }

    public static void flocking() {
        Terrain model = new Terrain(600, 400);
        ControleurAutonomie controleur = new ControleurFlocking(model);
        SimpleLogo vue = new SimpleLogo(model, controleur);

        Random rand = new Random();

        for (int i = 0; i < 100; i++) {
            controleur.addTortue(new Tortue(rand.nextInt(500) + 50, rand.nextInt(300) + 50, rand.nextInt(10)));
        }
        controleur.lancer();
    }

    public static void dependant() {

        Terrain model = new Terrain(600, 400);
        Controleur controleur = new Controleur(model);
        SimpleLogo vue = new SimpleLogo(model, controleur);

        controleur.setVue(vue);
        controleur.addTortue();
        controleur.overrideActionHandler("Avancer", new AvancerHandler());
        controleur.overrideActionHandler("Gauche", new GaucheHandler());
        controleur.overrideActionHandler("Droite", new DroiteHandler());
        controleur.overrideActionHandler("Carré", new CarreHandler());
        controleur.overrideActionHandler("Polygone", new PolyHandler());
        controleur.overrideActionHandler("Spiral", new SpiralHandler());
        controleur.overrideActionHandler("Ajouter", new AjouterHandler());
    }

}
