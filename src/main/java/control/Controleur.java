package control;


import control.handler.ActionHandler;
import model.Terrain;
import model.Tortue;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Controleur implements ActionListener {

    private SimpleLogo vue;
    private Tortue tortueCourante;
    private Terrain terrain;

    private HashMap<String, ActionHandler> actionsHandlers;



    public Controleur(Terrain model){
        actionsHandlers = new HashMap<>();
        this.terrain = model;
    }

    public void addTortue(Tortue tortue){
        terrain.addTortue(tortue);
        vue.setTortue(tortue);
        if (null == tortueCourante)
            tortueCourante = tortue;
    }
    public void addTortue(){
        this.addTortue(new Tortue((int) terrain.getLargeur() / 2, (int) terrain.getHauteur() / 2));
    }


    public void overrideActionHandler(String command, ActionHandler handler){
        actionsHandlers.put(command, handler);
    }

    /** la gestion des actions des boutons */
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        this.dispatcher(command, e);
    }

    public void dispatcher(String command, ActionEvent event){

        ActionHandler handler = actionsHandlers.get(command);
        if (null != handler){
            handler.handle(this, this.terrain, this.vue);
        } else if (command.equals("Effacer"))
            vue.effacer();
        else if (command.equals("Quitter"))
            vue.quitter();
        else {
            System.out.println("Action non supportée : \"" + command + "\"");
        }
    }


    public Tortue getTortueCourante() {
        return tortueCourante;
    }

    public void setVue(SimpleLogo vue) {
        this.vue = vue;
    }
}
