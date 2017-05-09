package control.handler;


import control.Controleur;
import model.Terrain;
import vue.SimpleLogo;

public class AvancerHandler implements ActionHandler {
    @Override
    public void handle(Controleur controleur, Terrain model, SimpleLogo vue) {

        System.out.println("command avancer");
        try {
            int valeur= Integer.parseInt(vue.getInputValue());
            controleur.getTortueCourante().avancer(valeur);
        } catch (NumberFormatException ex){
            System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
        }
    }
}
