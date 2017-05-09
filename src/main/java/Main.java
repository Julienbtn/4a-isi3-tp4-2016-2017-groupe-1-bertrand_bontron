import control.Controleur;
import control.handler.*;
import model.Terrain;
import model.Tortue;
import vue.SimpleLogo;

public class Main {

    public static void main(String args[]){
        Terrain model = new Terrain(600, 400);
        Controleur controleur = new Controleur(model);
        SimpleLogo vue = new SimpleLogo(model, controleur);

        controleur.setVue(vue);
        controleur.addTortue();
        controleur.overrideActionHandler("Avancer", new AvancerHandler());
        controleur.overrideActionHandler("Gauche", new GaucheHandler());
        controleur.overrideActionHandler("Droite", new DroiteHandler());
        controleur.overrideActionHandler("Proc1", new CarreHandler());
        controleur.overrideActionHandler("Proc2", new PolyHandler());
        controleur.overrideActionHandler("Proc3", new SpiralHandler());
        controleur.overrideActionHandler("Ajouter", new AjouterHandler());
    }
}
