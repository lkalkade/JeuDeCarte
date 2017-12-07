

/*
 * Fichier: TestDeJeuDeCarte.java
 * Crée le: 26 Novembre 2017.
 * Modifié: 27 Novembre 2017.
 * Auteur: Ludovic KALKA-DEBIDINE.
 * 
 * Ce programme est un exercice simple de programmation 
 * qui simule une partie de jeu de cartes entre 4 joueurs avec un paquet de 52 cartes
 * 
 */

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 * <p>Cette classe permet de tester les classes Carte, JeuDeCarte et Joueur.</p>
 * @author Ludovic KALKA-DEBIDINE.
 */
public class TestJeuDeCarte {


	/**
	 * <p>Construction de l'application.</p>
	 */
	public TestJeuDeCarte()
	{

		// Appel du constructeur de la classe JFrame.
		JFrame fenetre = new JFrame();
		fenetre.setVisible(true);

		// Ajoute les composants au conteneur.
		JTextArea zoneSortie = new JTextArea();
		zoneSortie.setEditable(false);
		fenetre.getContentPane().add(new JScrollPane(zoneSortie), BorderLayout.CENTER);

		// Texte de sortie.
		StringBuilder sortie = new StringBuilder();

		//Joue une partie
		Jeu partie= new Jeu();

		//Resultat de la partie
		partie.jouer(sortie);

		// Met à jour la zone de sortie.
		zoneSortie.setText(sortie.toString());

		// Modifie les propriétés de la fenêtre.
		fenetre.setSize(600, 200);
		fenetre.setLocation(100, 100);
		fenetre.setTitle("JeuDeCartes");
		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * <p>Débute l'exécution du test.</p>
	 * @param args Les paramètres de la ligne de commande.
	 */
	public static void main(String[] args)
	{
		new TestJeuDeCarte();
	}

}

