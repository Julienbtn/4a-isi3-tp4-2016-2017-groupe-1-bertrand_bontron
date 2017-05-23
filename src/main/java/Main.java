import control.Controleur;
import control.ControleurSelection;
import control.handler.selection.*;
import vue.Demarrage;

public class Main {

    public static void main(String args[]) {
        Controleur controleur = new ControleurSelection();
        controleur.overrideActionHandler("Tortues Dependantes", new Dependantehandler());
        controleur.overrideActionHandler("Tortues Autonomes", new AutonomeHandler());
        controleur.overrideActionHandler("Tortues Flocking", new FlockingHandler());
        Demarrage demarrage = new Demarrage(controleur);
    }

}
