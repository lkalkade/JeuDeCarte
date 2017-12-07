

/*
 * Fichier: JeuDeCarte.java
 * Crée le: 26 Novembre 2017.
 * Modifié: 27 Novembre 2017.
 * Auteur: Ludovic KALKA-DEBIDINE.
 * 
 * Ce programme est un exercice simple de programmation 
 * qui simule une partie de jeu de cartes entre 4 joueurs avec un paquet de 52 cartes
 * 
 */

/**
 * <p>Cette classe modélise un jeu de 52 cartes.</p>
 * @author Ludovic KALKA-DEBIDINE.
 */
public class JeuDeCarte {

	/** Le paquet de cartes. */
	private Carte [] Paquet;

	/** Le nombre de cartes contenues dans le tableau */
	private int nb_Carte;

	/** Hauteur des cartes du paquet: 2, 3, 4, 5, 6, 7, 8, 9, 10, Valet, Dame, Roi, As.*/
	private String [] valeurs = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As"};

	/** Couleur des cartes du paquet: Coeur, Carreau, Treffle, Pique.*/
	private String [] couleurs = {"Trèfle", "Coeur", "Carreau", "Pique"};

	/** Constructeur du Jeu De Carte vide .
	Creation d'un paquet de 52 cartes maximum vide au départ */
	public JeuDeCarte()
	{
		Paquet = new Carte [couleurs.length * valeurs.length];
		nb_Carte = 0;
	}

	/**
	Permet de connaitre combien de carte contient le paquet
	@return le nombre de carte que contient le paquet
	 */
	public int getNb_Carte() {
		return nb_Carte;
	}

	/** Remplissage d'un jeu complet de 52 cartes.
	Cette fonction initialise le paquet de maniere a avoir un
	jeu complet des cartes sans repetition et ordonne.
	 */
	public void initPaquet()
	{
		// Initialisation des cartes du paquet.
		nb_Carte=couleurs.length*valeurs.length;
		for(int i=0; i<couleurs.length; i++)
		{
			for(int j=0; j<valeurs.length; j++)
			{
				Paquet[i * valeurs.length + j]=new Carte(valeurs[j],couleurs[i],j+1);
			}
		}
	}

	/** Mélange le paquet .
	On echange de maniere aleatoire les cartes du paquet */
	public void melanger()
	{
		Carte temp ;
		int i , j =0,k=0;
		for ( i =0; i <500; i++){
			j=( int ) (Math.random( ) *  nb_Carte) ;
			k=( int ) (Math.random( ) *  nb_Carte) ;
			temp=Paquet [ j ] ;
			Paquet [ j ]= Paquet [ k ] ;
			Paquet [ k]=temp ;
		}

	}

	/** Ajoute une carte au début  du paquet .
	@param c La carte a ajouter
	@return vrai si la carte a ete ajoutee correctement, faux dans le cas contraire ( paquet plein )
	 */
	public  boolean ajoute(Carte c)
	{
		if(nb_Carte<51)
		{
			Paquet[nb_Carte]=c;
			nb_Carte++;
			return true; 
		}
		else
			return false;

	}

	/** Ajoute une carte a la fin du paquet .
	@param c La carte a ajouter
	@return vrai si la carte a ete ajoutee correctement, faux dans le cas contraire ( paquet plein )
	 */
	public  boolean ajouteALaFin(Carte c)
	{
		nb_Carte++;
		if(nb_Carte<51)
		{
			for ( int j=nb_Carte ; j >0; j--)
				Paquet [ j ]= Paquet [ j - 1] ;
			Paquet [0]=c ;
			return true ;
		}

		else
			return false;

	}

	/** Teste si le paquet est vide */
	public boolean estVide()
	{
		if ( nb_Carte==0)
			return true ;
		else
			return false ;
	}


	/** Pioche la premiere carte du paquet .
	@return La premiere carte ou null si le paquet est vide
	 */
	public Carte pioche ()
	{
		if ( nb_Carte >0)
		{
			nb_Carte--;
			return Paquet [ nb_Carte] ;
		}
		else
			return null ;
	}

	/**
	Construit une chaine de caracteres qui represente le paquet de 52 cartes .
	@return la representation texte du paquet de 52 cartes.
	 */
	public String toString()
	{
		String aff="" ;

		if(nb_Carte==0)
		{
			return "\tPaquet Vide ! " ;
		}

		for ( int i =0; i<nb_Carte ; i++)
		{
			aff=aff+Paquet[i].toString()+"\n" ;
		}

		return aff ;
	}



}

