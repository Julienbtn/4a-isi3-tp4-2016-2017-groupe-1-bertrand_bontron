package control.handler;


import control.Controleur;
import model.Terrain;
import vue.SimpleLogo;

public interface ActionHandler {

    void handle(Controleur controleur, Terrain model, SimpleLogo vue);
}
