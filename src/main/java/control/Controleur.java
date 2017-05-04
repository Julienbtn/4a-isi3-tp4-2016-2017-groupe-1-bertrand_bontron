package control;


import model.Tortue;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controleur implements ActionListener {

    private SimpleLogo vue;
    private ArrayList<Tortue>tortuesList;
    private Tortue tortueCourante;

    public Controleur(SimpleLogo vue){
       tortuesList = new ArrayList<>();
        this.vue = vue;
    }

    public void setTortue(Tortue tortue){
       tortuesList.add(tortue);
        tortueCourante = tortue;
    }

    /** la gestion des actions des boutons */
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        System.out.println("I will do smt");

        // actions des boutons du haut
        if (command.equals("Avancer")) {
            System.out.println("command avancer");
            try {
                int valeur= Integer.parseInt(vue.getInputValue());
                tortueCourante.avancer(valeur);
            } catch (NumberFormatException ex){
                System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
            }

        }
        else if (command.equals("Droite")) {
            try {
                int valeur= Integer.parseInt(vue.getInputValue());
                tortueCourante.droite(valeur);
            } catch (NumberFormatException ex){
                System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
            }
        }
        else if (command.equals("Gauche")) {
            try {
                int valeur= Integer.parseInt(vue.getInputValue());
                tortueCourante.gauche(valeur);
            } catch (NumberFormatException ex){
                System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
            }
        }
        // actions des boutons du bas
        else if (command.equals("Proc1"))
            proc1();
        else if (command.equals("Proc2"))
            proc2();
        else if (command.equals("Proc3"))
            proc3();
        else if (command.equals("Effacer"))
            vue.effacer();
        else if (command.equals("Ajouter"))
            vue.ajouter();
        else if (command.equals("Quitter"))
            vue.quitter();

        vue.repaint();
    }

    /** les procedures Logo qui combine plusieurs commandes..*/
    public void proc1() {        tortueCourante.carre();    }

    public void proc2() {
        tortueCourante.poly(60,8);
    }

    public void proc3() {
        tortueCourante.spiral(50,40,6);
    }
}
