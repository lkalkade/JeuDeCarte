

/*
 * Fichier: Joueur.java
 * Crée le: 26 Novembre 2017.
 * Modifié: 27 Novembre 2017.
 * Auteur: Ludovic KALKA-DEBIDINE.
 * 
 * Ce programme est un exercice simple de programmation 
 * qui simule une partie de jeu de cartes entre 4 joueurs avec un paquet de 52 cartes
 * 
 */

/**
 * <p>Cette classe modélise un joueur.</p>
 * @author Ludovic KALKA-DEBIDINE.
 */
public class Joueur {

	/**
	La main du joueur ( son paquet des cartes )
	*/
	JeuDeCarte mamain;

	/**
	Le pli du joueur ( son paquet des cartes )
	*/
	JeuDeCarte pli;

	/** Le nom du joueur
	*/
	String nom;

	/** Constructeur par defaut*/
	public Joueur()
	{
		mamain = new JeuDeCarte();
		nom="";
		pli = new JeuDeCarte();
	}

	/** Constructeur avec nom
	 * @param n le nom du joueur
	 */
	public Joueur(String n)
	{
		mamain= new JeuDeCarte();
		this.nom=n;
		pli = new JeuDeCarte();

	}

	/** ajouter une carte a sa main
	*/
	public void ajoute(Carte c)
	{
		mamain.ajoute(c);

	}

	/** ajouter une carte a la fin de son pli*/
	public void ramasse(Carte c)
	{
		pli.ajouteALaFin(c);
	}

	/** Combien de cartes a le joueur */
	public int combienDeCartes (){
		return mamain.getNb_Carte();
	}

	/** Teste si le joueur a encore des cartes
	*/
	public boolean aDesCartes()
	{
		return !mamain.estVide();			
	}

	/** Jouer une carte de sa main
	*/
	public Carte joue()
	{
		return mamain.pioche();
	}

	/**
	Donne une description du joueur .
	@return la description d'un joueur.
	 */
	public String toString(){
		return "\nJoueur: "+nom+
				"\n\nMain :\n"+mamain.toString()+
				"\nPli:\n"+pli.toString();
	}
}

