package control.handler;

import control.Controleur;
import model.Terrain;
import model.Tortue;
import vue.SimpleLogo;

public class AjouterHandler implements ActionHandler {
    @Override
    public void handle(Controleur controleur, Terrain model, SimpleLogo vue) {
        controleur.addTortue(new Tortue());
    }
}
