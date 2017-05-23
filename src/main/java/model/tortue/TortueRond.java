package model.tortue;

import model.Couleur;
import model.Tortue;
import model.mouvement.MouvementStrategie;

public class TortueRond extends Tortue {


    public TortueRond(MouvementStrategie mouvement) {
        super(mouvement);
    }

    public TortueRond(int x, int y, MouvementStrategie mouvement) {
        super(x, y, mouvement);
    }

    public TortueRond(int x, int y, int couleurId, MouvementStrategie mouvement) {
        super(x, y , couleurId, mouvement);
    }

    public TortueRond(int x, int y, int couleurId, double vitesse, double direction, MouvementStrategie mouvement){
        super(x, y, couleurId, vitesse, direction, mouvement);
    }
}
