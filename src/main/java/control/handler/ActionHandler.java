package control.handler;


import control.Controleur;
import model.Terrain;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;

public interface ActionHandler {

    void handle(Controleur controleur, Terrain model, SimpleLogo vue, ActionEvent event);
}
