package vue;

import control.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

public class Demarrage extends JFrame {

    private Controleur controleur;

    public Demarrage(Controleur controleur) {
        this.setTitle("Choix du mode de tortue");
        this.setSize(500, 100);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout());
        JButton boutonDependant = new JButton("Tortues Dependantes");
        JButton boutonAutonome = new JButton("Tortues Autonomes");
        JButton boutonFlocking = new JButton("Tortues Flocking");
        panel.add(boutonDependant);
        panel.add(boutonAutonome);
        panel.add(boutonFlocking);
        boutonDependant.addActionListener(controleur);
        boutonAutonome.addActionListener(controleur);
        boutonFlocking.addActionListener(controleur);
        getContentPane().add(panel);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
