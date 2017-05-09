package control.handler;


import control.Controleur;
import model.Terrain;
import vue.SimpleLogo;

public class CarreHandler implements ActionHandler {
    @Override
    public void handle(Controleur controleur, Terrain model, SimpleLogo vue) {
        controleur.getTortueCourante().carre();
    }
}
