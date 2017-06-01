package vue;

import model.Tortue;
import vue.tortue.TortueVue;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class FeuilleDessin extends JPanel {

    private java.util.List<TortueVue> tortuesList; // la liste des tortues enregistrees
    private TortueVueFactory tortueFactory;

    public FeuilleDessin() {
        tortuesList = new ArrayList<>();
        tortueFactory = new TortueVueFactory();
    }

    public void addTortue(Tortue tortue) {
        tortuesList.add(tortueFactory.construire(tortue));
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

    public void showTurtles(Graphics graphic) {
        for (TortueVue tortue : tortuesList) {
            tortue.drawTurtle(graphic);
        }
    }

    public void vider() {
        this.tortuesList = new ArrayList<>();
    }
}
