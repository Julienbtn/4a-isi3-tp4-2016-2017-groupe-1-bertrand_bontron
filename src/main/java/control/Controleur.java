package control;


import model.Tortue;
import vue.SimpleLogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controleur implements ActionListener {

    private SimpleLogo vue;
    private ArrayList<Tortue> tortues;
    private Tortue courante;

    public Controleur(SimpleLogo vue){
        tortues = new ArrayList<>();
        this.vue = vue;
    }

    public void setTortue(Tortue tortue){
        tortues.add(tortue);
        courante = tortue;
    }

    /** la gestion des actions des boutons */
    public void actionPerformed(ActionEvent e)
    {
        String c = e.getActionCommand();
        System.out.println("I will do smt");

        // actions des boutons du haut
        if (c.equals("Avancer")) {
            System.out.println("command avancer");
            try {
                int v = Integer.parseInt(vue.getInputValue());
                courante.avancer(v);
            } catch (NumberFormatException ex){
                System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
            }

        }
        else if (c.equals("Droite")) {
            try {
                int v = Integer.parseInt(vue.getInputValue());
                courante.droite(v);
            } catch (NumberFormatException ex){
                System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
            }
        }
        else if (c.equals("Gauche")) {
            try {
                int v = Integer.parseInt(vue.getInputValue());
                courante.gauche(v);
            } catch (NumberFormatException ex){
                System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
            }
        }
        // actions des boutons du bas
        else if (c.equals("Proc1"))
            proc1();
        else if (c.equals("Proc2"))
            proc2();
        else if (c.equals("Proc3"))
            proc3();
        else if (c.equals("Effacer"))
            vue.effacer();
        else if (c.equals("Quitter"))
            vue.quitter();

        vue.repaint();
    }

    /** les procedures Logo qui combine plusieurs commandes..*/
    public void proc1() {
        courante.carre();
    }

    public void proc2() {
        courante.poly(60,8);
    }

    public void proc3() {
        courante.spiral(50,40,6);
    }
}
