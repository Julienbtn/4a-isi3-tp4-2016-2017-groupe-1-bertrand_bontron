package control;


import control.handler.ActionHandler;
import model.Terrain;
import model.Tortue;
import model.mouvement.MouvementStrategie;
import model.mouvement.Rectiligne;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class Controleur extends MouseAdapter implements ActionListener {

    protected SimpleLogo vue;
    protected Tortue tortueCourante;
    protected Terrain terrain;
    protected MouvementStrategie defaultMouvementStrategie;

    protected HashMap<String, ActionHandler> actionsHandlers;



    public Controleur(Terrain model){
        actionsHandlers = new HashMap<>();
        this.defaultMouvementStrategie = new Rectiligne(model);
        this.terrain = model;
    }

    public void addTortue(Tortue tortue){
        terrain.addTortue(tortue);
        tortueCourante = tortue;
    }
    public void addTortue(){
        Tortue tortue = new Tortue( terrain.getLargeur() / 2, terrain.getHauteur() / 2, vue.getCouleur());
        tortue.setMouvement(defaultMouvementStrategie);
        this.addTortue(tortue);
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
            handler.handle(this, this.terrain, this.vue, event);
        } else if (command.equals("Effacer"))
            vue.effacer();
        else if (command.equals("Quitter"))
            vue.quitter();
        else {
            System.out.println("Action non supportée : \"" + command + "\"");
        }
    }

    public void mouseClicked(MouseEvent event){
        Tortue tortue = terrain.getTortueProche(event.getX(), event.getY());
        if (tortue != null){
            tortueCourante = tortue;
            System.out.println("Nouvelle tortue");
        }
    }


    public Tortue getTortueCourante() {
        return tortueCourante;
    }

    public void setVue(SimpleLogo vue) {
        this.vue = vue;
    }
}
