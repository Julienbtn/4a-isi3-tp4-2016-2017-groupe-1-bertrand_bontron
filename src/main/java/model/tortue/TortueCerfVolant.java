package model.tortue;

import model.Tortue;
import model.mouvement.MouvementStrategie;

public class TortueCerfVolant extends Tortue {

    public TortueCerfVolant(MouvementStrategie mouvement) {
        super(mouvement);
    }

    public TortueCerfVolant(int x, int y, MouvementStrategie mouvement) {
        super(x, y, mouvement);
    }

    public TortueCerfVolant(int x, int y, int couleurId, MouvementStrategie mouvement) {
        super(x, y , couleurId, mouvement);
    }

    public TortueCerfVolant(int x, int y, int couleurId, double vitesse, double direction, MouvementStrategie mouvement){
        super(x, y, couleurId, vitesse, direction, mouvement);
    }
}
