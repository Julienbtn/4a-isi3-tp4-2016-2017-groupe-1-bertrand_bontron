package model.tortue;

import model.Tortue;
import model.mouvement.MouvementStrategie;

public class TortueTriangle extends Tortue {

    public TortueTriangle(MouvementStrategie mouvement) {
        super(mouvement);
    }

    public TortueTriangle(int x, int y, MouvementStrategie mouvement) {
        super(x, y, mouvement);
    }

    public TortueTriangle(int x, int y, int couleurId, MouvementStrategie mouvement) {
        super(x, y , couleurId, mouvement);
    }

    public TortueTriangle(int x, int y, int couleurId, double vitesse, double direction, MouvementStrategie mouvement){
        super(x, y, couleurId, vitesse, direction, mouvement);
    }
}
