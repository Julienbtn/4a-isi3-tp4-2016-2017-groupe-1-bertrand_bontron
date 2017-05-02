package vue;// package logo;

import model.Tortue;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

/**
 * Titre :        Logo
 * Description :  Un exemple de programme graphique utilisant la celebre model.Tortue Logo
 * Copyright :    Copyright (c) 2000
 * Societe :      LIRMM
 * @author J. Ferber
 * @version 2.0
 */

public class FeuilleDessin extends JPanel {
	private ArrayList<TortueVue> tortues; // la liste des tortues enregistrees
	
	public FeuilleDessin() {
		tortues = new ArrayList<TortueVue>();
	}

	public void addTortue(Tortue o) {
		tortues.add(new TortueVue(o));
	}

	public void reset() {
		for (Iterator it = tortues.iterator();it.hasNext();) {
			Tortue t = (Tortue) it.next();
			t.reset();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Color c = g.getColor();
		
		Dimension dim = getSize();
		g.setColor(Color.white);
		g.fillRect(0,0,dim.width, dim.height);
		g.setColor(c);

		showTurtles(g);
	}
	
	public void showTurtles(Graphics g) {
		for(Iterator it = tortues.iterator();it.hasNext();) {
			TortueVue t = (TortueVue) it.next();
			t.drawTurtle(g);
		}
	}

}
