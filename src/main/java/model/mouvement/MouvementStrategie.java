package model.mouvement;

import model.Tortue;

public abstract class MouvementStrategie {

    protected static final double ratioDegRad = 0.0174533; // Rapport radians/degres (pour la conversion)

    public abstract void bouger(Tortue tortue);
}
