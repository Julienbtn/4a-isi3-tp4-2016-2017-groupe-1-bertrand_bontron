package control.handler;

import control.Controleur;
import model.Terrain;
import vue.SimpleLogo;

public class GaucheHandler implements ActionHandler {
    @Override
    public void handle(Controleur controleur, Terrain model, SimpleLogo vue) {

        try {
            int valeur= Integer.parseInt(vue.getInputValue());
            controleur.getTortueCourante().gauche(valeur);
        } catch (NumberFormatException ex){
            System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
        }
    }
}
