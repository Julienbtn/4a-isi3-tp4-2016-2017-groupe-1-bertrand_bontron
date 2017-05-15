package model;

import java.awt.*;

public class Couleur {
    public static final Color[] couleurs = {Color.black, Color.blue, Color.cyan, Color.darkGray, Color.red,
            Color.green, Color.lightGray, Color.magenta, Color.orange, Color.gray,
            Color.pink, Color.yellow};

    public static Color getCouleur(int id) {
        return (id < couleurs.length) ? couleurs[id] : Color.black;
    }
}
