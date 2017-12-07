

/*
 * Fichier: Carte.java
 * Crée le: 26 Novembre 2017.
 * Modifié: 27 Novembre 2017.
 * Auteur: Ludovic KALKA-DEBIDINE.
 * 
 * Ce programme est un exercice simple de programmation 
 * qui simule une partie de jeu de cartes entre 4 joueurs avec un paquet de 52 cartes
 * 
 */


/**
 * <p>Cette classe modélise une carte du jeu de 52 cartes.</p>
 * @author Ludovic KALKA-DEBIDINE.
 */
public class Carte {

	/** valeur de la carte: 2, 3, 4, 5, 6, 7, 8, 9, 10, Valet, Dame, Roi, As.*/
	private String valeur;

	/** Couleur de la carte: Coeur, Carreau, Treffle, Pique.*/
	private String couleur;

	/** Rang de la carte de 1 a 13 (1=2. . 12=Roi 13=As ).*/
	private int rang;

	/**
	Constructeur à partir d'une valeur, d'une couleur et d'un rang.
	@param h la valeur de la nouvelle carte
	@param c la couleur de la carte
	@param r le rang de la nouvelle carte
	 */
	public Carte(String h, String c, int r)
	{
		this.valeur=h;
		this.couleur=c;
		this.rang=r;
	}

	/**
	Permet de connaitre la valeur de la carte
	@return la valeur de la carte
	 */
	public String getvaleur(){
		return valeur;
	}

	/**
	Permet de connaitre la couleur de la carte
	@return la couleur de la carte
	 */
	public String getCouleur(){
		return couleur;
	}

	/**
	Permet de connaitre le rang de la carte
	@return le rang de la carte
	 */
	public int getRang(){
		return rang;
	}

	/**
	Compare le rang de l a carte avec celui d'une autre et determine si la carte a un rang plus fort.
	@param c La carte avec la quelle on va comparer
	@return vrai si le rang de la carte est plus forte que celui de c, faux dans
	le cas contraire
	 */
	public boolean estPlusFort (Carte c)
	{
		return rang > c.getRang();

	}

	/**
	Compare le rang de la carte avec celui d'une autre et determine si la carte a le meme rang que celle ci.
	@param c La carte avec la quelle on va comparer
	@return vrai si le rang de la carte est le meme que celui de c, faux dans
	le cas contraire
	 */
	public boolean estEgal(Carte c)
	{
		return rang == c.getRang();
	}

	/**
	Construit une chaine de caracteres qui represente la carte .
	@return la representation texte de la carte
	 */
	public String toString(){
		return  "\t"+valeur+" de "+couleur;
	}


}

