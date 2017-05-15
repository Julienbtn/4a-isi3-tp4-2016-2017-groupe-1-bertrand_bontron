package control.handler;

import control.Controleur;
import control.ControleurAutonomie;
import model.Terrain;
import model.Tortue;
import vue.Demarrage;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;

public class Dependantehandler implements ActionHandler {
    @Override
    public void handle(Controleur controleur, Terrain model, SimpleLogo vue, ActionEvent event) {

        model = new Terrain(600, 400);
        controleur = new Controleur(model);
        vue = new SimpleLogo(model, controleur);
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
