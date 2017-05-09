package control.handler;


import control.Controleur;
import model.Terrain;
import vue.SimpleLogo;

public class SpiralHandler implements ActionHandler {
    @Override
    public void handle(Controleur controleur, Terrain model, SimpleLogo vue) {
        controleur.getTortueCourante().spiral(50, 40, 6);
    }
}
