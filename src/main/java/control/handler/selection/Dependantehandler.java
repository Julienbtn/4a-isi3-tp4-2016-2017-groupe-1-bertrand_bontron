package control.handler.selection;

import control.Controleur;
import control.ControleurManuel;
import control.handler.*;
import model.Terrain;
import model.mouvement.Rectiligne;
import model.tortue.TortueTriangle;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;

public class Dependantehandler implements ActionHandler {
    @Override
    public void handle(Controleur controleur, Terrain model, SimpleLogo vue, ActionEvent event) {

        model = new Terrain(600, 400);
        ControleurManuel controleurManuel = new ControleurManuel(model);
        vue = new SimpleLogo(model, controleurManuel);
        controleurManuel.setVue(vue);
        controleurManuel.overrideActionHandler("Avancer", new AvancerHandler());
        controleurManuel.overrideActionHandler("Gauche", new GaucheHandler());
        controleurManuel.overrideActionHandler("Droite", new DroiteHandler());
        controleurManuel.overrideActionHandler("Carré", new CarreHandler());
        controleurManuel.overrideActionHandler("Polygone", new PolyHandler());
        controleurManuel.overrideActionHandler("Spiral", new SpiralHandler());
        controleurManuel.overrideActionHandler("Ajouter", new AjouterHandler());

        controleurManuel.addTortue(new TortueTriangle(new Rectiligne(model)));


    }


}
