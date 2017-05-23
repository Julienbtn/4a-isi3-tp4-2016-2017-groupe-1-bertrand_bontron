package control;


import control.handler.ActionHandler;
import model.Terrain;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public abstract class Controleur extends MouseAdapter implements ActionListener {

    protected SimpleLogo vue;
    protected Terrain terrain;

    protected Map<String, ActionHandler> actionsHandlers;

    public Controleur() {
        actionsHandlers = new HashMap<>();
    }



    public void overrideActionHandler(String command, ActionHandler handler) {
        actionsHandlers.put(command, handler);
    }

    /**
     * la gestion des actions des boutons
     */
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        this.dispatcher(command, e);
    }

    public void dispatcher(String command, ActionEvent event) {

        ActionHandler handler = actionsHandlers.get(command);
        if (null != handler) {
            handler.handle(this, this.terrain, this.vue, event);
        } else {
            System.out.println(String.format("Action non supportée : \"%s\"", command));
        }
    }

    public void mouseClicked(MouseEvent event){};



    public void setVue(SimpleLogo vue) {
        this.vue = vue;
    }
}
