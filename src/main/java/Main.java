import control.Controleur;
import control.handler.*;
import vue.Demarrage;

public class Main {

    public static void main(String args[]) {
        Controleur controleur = new Controleur();
        controleur.overrideActionHandler("Tortues Dependantes", new Dependantehandler());
        controleur.overrideActionHandler("Tortues Autonomes", new AutonomeHandler());
        controleur.overrideActionHandler("Tortues Flocking", new FlockingHandler());
        Demarrage demarrage = new Demarrage(controleur);
    }

}
