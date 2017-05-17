package vue;// package logo;

import model.Tortue;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Titre :        Logo
 * Description :  Un exemple de programme graphique utilisant la celebre model.Tortue Logo
 * Copyright :    Copyright (c) 2000
 * Societe :      LIRMM
 *
 * @author J. Ferber
 * @version 2.0
 */

public class FeuilleDessin extends JPanel {
    private ArrayList<TortueTriangleVue> tortuesList; // la liste des tortues enregistrees

    public FeuilleDessin() {
        tortuesList = new ArrayList<TortueTriangleVue>();
    }

    public void addTortue(Tortue tortue) {
        tortuesList.add(new TortueTriangleVue(tortue));
    }

    public void reset() {
        for (Iterator iterateur = tortuesList.iterator(); iterateur.hasNext(); ) {
            TortueTriangleVue tortueVue = (TortueTriangleVue) iterateur.next();
            tortueVue.tortue.reset();
        }
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color couleur = g.getColor();

        Dimension dimension = getSize();
        g.setColor(Color.white);
        g.fillRect(0, 0, dimension.width, dimension.height);
        g.setColor(couleur);

        showTurtles(g);
    }

    public void showTurtles(Graphics g) {
        for (Iterator iterateur = tortuesList.iterator(); iterateur.hasNext(); ) {
            TortueTriangleVue tortueVue = (TortueTriangleVue) iterateur.next();
            tortueVue.drawTurtleCerfVolant(g);
        }
    }

}
