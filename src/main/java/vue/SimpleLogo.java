package vue;// package logo;

import control.Controleur;
import model.Tortue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;


/*************************************************************************

	Un petit Logo minimal qui devra etre ameliore par la suite

				J. Ferber - 1999-2001

				Cours de DESS TNI - Montpellier II

	@version 2.0
	@date 25/09/


**************************************************************************/


public class SimpleLogo extends JFrame implements Observer {
	public static final Dimension VGAP = new Dimension(1,5);
	public static final Dimension HGAP = new Dimension(5,1);

	private FeuilleDessin feuille;
	private Tortue tortueCourante;
	private JTextField inputValue;
	private Controleur controleur;


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
		public void run(){
			SimpleLogo fenetre = new SimpleLogo();
			fenetre.setVisible(true);
		}
		});

	}
	
	public void quitter() {
		System.exit(0);
	}

	public SimpleLogo() {
		super("un logo tout simple");
		this.controleur = new Controleur(this);
		logoInit();
		addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent arg0) {
		        super.windowClosing(arg0);
		        System.exit(0);
		    }
		});
	}

	public void logoInit() {
		getContentPane().setLayout(new BorderLayout(10,10));

		// Boutons
		JToolBar toolBar = new JToolBar();
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(toolBar);

		getContentPane().add(buttonPanel,"North");

		addButton(toolBar,"Effacer","Nouveau dessin","/icons/index.png");
		
		toolBar.add(Box.createRigidArea(HGAP));
		inputValue=new JTextField("45",5);
		toolBar.add(inputValue);
		addButton(toolBar, "Avancer", "Avancer 50", null);
		addButton(toolBar, "Droite", "Droite 45", null);
		addButton(toolBar, "Gauche", "Gauche 45", null);
		addButton(toolBar, "Lever", "Lever Crayon", null);
		addButton(toolBar, "Baisser", "Baisser Crayon", null);
		addButton(toolBar, "Ajouter","Ajouter Tortue" , null);

		String[] colorStrings = {"noir", "bleu", "cyan","gris fonce","rouge",
								 "vert", "gris clair", "magenta", "orange",
								 "gris", "rose", "jaune"};

		// Create the combo box
		toolBar.add(Box.createRigidArea(HGAP));
		JLabel colorLabel = new JLabel("   Couleur: ");
		toolBar.add(colorLabel);
		JComboBox colorList = new JComboBox(colorStrings);
		toolBar.add(colorList);

		colorList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox = (JComboBox)e.getSource();
				int n = comboBox.getSelectedIndex();
				tortueCourante.setColor(n);
			}
		});


		// Menus
		JMenuBar menubar=new JMenuBar();
		JMenu menuFile=new JMenu("File"); // on installe le premier menu
		JMenu menuCommandes=new JMenu("Commandes"); // on installe le premier menu
		JMenu menuHelp=new JMenu("Aide"); // on installe le premier menu

		setJMenuBar(menubar);	// on installe le menu bar
		menubar.add(menuFile);

		addMenuItem(menuFile, "Effacer", "Effacer", KeyEvent.VK_N);
		addMenuItem(menuFile, "Quitter", "Quitter", KeyEvent.VK_Q);

		menubar.add(menuCommandes);
		addMenuItem(menuCommandes, "Avancer", "Avancer", -1);
		addMenuItem(menuCommandes, "Droite", "Droite", -1);
		addMenuItem(menuCommandes, "Gauche", "Gauche", -1);
		addMenuItem(menuCommandes, "Lever Crayon", "Lever", -1);
		addMenuItem(menuCommandes, "Baisser Crayon", "Baisser", -1);
		addMenuItem(menuCommandes, "Ajouter Tortue", "Ajouter", -1);

		menubar.add(menuHelp);
		addMenuItem(menuHelp, "Aide", "Help", -1);
		addMenuItem(menuHelp, "A propos", "About", -1);

		setDefaultCloseOperation(EXIT_ON_CLOSE);


		// les boutons du bas
		JPanel p2 = new JPanel(new GridLayout());
		JButton b20 = new JButton("Proc1");
		JButton b21 = new JButton("Proc2");
		JButton b22 = new JButton("Proc3");
		p2.add(b20);
		p2.add(b21);
		p2.add(b22);
		b20.addActionListener(controleur);
		b21.addActionListener(controleur);
		b22.addActionListener(controleur);

		getContentPane().add(p2,"South");

		feuille = new FeuilleDessin(); //500, 400);
		feuille.setBackground(Color.white);
		feuille.setSize(new Dimension(600,400));
		feuille.setPreferredSize(new Dimension(600,400));
			
		getContentPane().add(feuille,"Center");


		// Creation de la tortue
		Tortue tortue = new Tortue();

		// Deplacement de la tortue au centre de la feuille
		tortue.setPosition(500/2, 400/2); 		
		
		tortueCourante = tortue;
		feuille.addTortue(tortue);
		controleur.setTortue(tortue);

		pack();
		setVisible(true);
	}

	public void setTortue(Tortue tortue){
		feuille.addTortue(tortue);
		tortueCourante = tortue;
		tortue.addObserver(this);
	}

	public String getInputValue(){
		String texte = inputValue.getText();
		return(texte);
	}


	// efface tout et reinitialise la feuille
	public void effacer() {
		feuille.reset();
		feuille.repaint();

		// Replace la tortue au centre
		Dimension dimansion = feuille.getSize();
		tortueCourante.setPosition(dimansion.width/2, dimansion.height/2);
	}

	public void ajouter(){
		feuille.addTortue(new Tortue());
		feuille.repaint();
	}

	//utilitaires pour installer des boutons et des menus
	public void addButton(JComponent p, String nom, String tooltiptext, String imageName) {
		JButton bouton;
		if ((imageName == null) || (imageName.equals(""))) {
			bouton = (JButton)p.add(new JButton(nom));
		}
		else {
			java.net.URL url = this.getClass().getResource(imageName);
			if (url != null) {
				ImageIcon im = new ImageIcon (url);
				bouton = (JButton) p.add(new JButton(im));
			}
			else
				bouton = (JButton) p.add(new JButton(nom));
			bouton.setActionCommand(nom);
		}

		bouton.setToolTipText(tooltiptext);
		bouton.setBorder(BorderFactory.createRaisedBevelBorder());
		bouton.setMargin(new Insets(0,0,0,0));
		bouton.addActionListener(controleur);
	}

	public void addMenuItem(JMenu menu, String texte, String command, int clef) {
		JMenuItem menuItem;
		menuItem = new JMenuItem(texte);
		menu.add(menuItem);

		menuItem.setActionCommand(command);
		menuItem.addActionListener(controleur);
		if (clef > 0) {
			if (clef != KeyEvent.VK_DELETE)
				menuItem.setAccelerator(KeyStroke.getKeyStroke(clef, Event.CTRL_MASK, false));
			else
				menuItem.setAccelerator(KeyStroke.getKeyStroke(clef, 0, false));
		}
	}


	public void repaint(){
		this.feuille.repaint();
	}

	@Override
	public void update(Observable observable, Object o) {
		System.out.println("Oh my god, something just happened");
		this.repaint();
	}
}
