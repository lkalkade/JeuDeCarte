

/*
 * Fichier: Jeu.java
 * Crée le: 26 Novembre 2017.
 * Modifié: 27 Novembre 2017.
 * Auteur: Ludovic KALKA-DEBIDINE.
 * 
 * Ce programme est un exercice simple de programmation 
 * qui simule une partie de jeu de cartes entre 4 joueurs avec un paquet de 52 cartes
 * 
 */


/**
 * <p>Cette classe permet de tester une partie entre 4 joueurs.</p>
 * @author Ludovic KALKA-DEBIDINE.
 */
public class Jeu {

	/** Creation des joueurs et de la table
	 */

	private JeuDeCarte jeu; //Paquet de 52 cartes

	private JeuDeCarte table; //Table de jeu

	private Joueur ja; //Joueur 1
	private Joueur jb; //Joueur 2
	private Joueur jc; //Joueur 3
	private Joueur jd; //Joueur 4


	public Jeu()
	{	 
		// Construction des joueurs.
		ja = new Joueur("1");
		jb = new Joueur("2");
		jc = new Joueur("3");
		jd = new Joueur("4");
		
		// Construction de la table.
		table = new JeuDeCarte();
		
		// Construction du paquet de cartes.
		jeu = new JeuDeCarte();
		jeu.initPaquet();

	}

	/** Jouer une partie
	 * @param sortie description de la partie jouer
	 */
	public StringBuilder jouer (StringBuilder sortie)
	{ 

		Carte c1,c2,c3,c4; //Cartes jouées par les joueurs

		int tour =0; //Nombre de tour

		sortie.append("Jeu de carte complet : \n\n");
		sortie.append(jeu);
		sortie.append("\n");
		
		//Melange du jeu de carte
		jeu.melanger();

		//Distribution des cartes
		while(!jeu.estVide())
		{
			ja.ajoute(jeu.pioche());
			jb.ajoute(jeu.pioche());
			jc.ajoute(jeu.pioche());
			jd.ajoute(jeu.pioche());
		}

		sortie.append("\nDistribution des cartes entre les 4 joueurs:\n");
		sortie.append(ja+"\n"+jb+"\n"+jc+"\n"+jd+"\n");

		/**Jouer une partie*/
		while(ja.aDesCartes()&& jb.aDesCartes() && jc.aDesCartes() && jd.aDesCartes())
		{

			c1=ja.joue();
			c2=jb.joue();
			c3=jc.joue();
			c4=jd.joue();

			table.ajoute(c1);
			table.ajoute(c2);
			table.ajoute(c3);
			table.ajoute(c4);
			
			tour+=1;

			//Joueur 1 gagne le tour
			if(c1.estPlusFort(c2) && c1.estPlusFort(c3) && c1.estPlusFort(c4))
			{
				sortie.append("\ntour: "+tour+"\n");
				//sortie.append("\ntable:\n"+ table);
				sortie.append("\ntable:\n\tJoueur 1 joue:"+c1+"\n\tJoueur 2 joue:"+c2+"\n\tJoueur 3 joue:"+c3+"\n\tJoueur 4 joue:"+c4+"\n");
				
				while(!table.estVide())
					ja.ramasse(table.pioche());
				
				sortie.append("\n\tLe joueur "+ja.nom+" gagne le tour "+tour+"\n");
				sortie.append(ja+"\n"+jb+"\n"+jc+"\n"+jd+"\n");

			}

			//Joueur 2 gagne le tour
			if(c2.estPlusFort(c1) && c2.estPlusFort(c3) && c2.estPlusFort(c4))
			{		
				sortie.append("\ntour: "+tour+"\n");
				//sortie.append("\ntable:\n"+ table);
				sortie.append("\ntable:\n\tJoueur 1 joue:"+c1+"\n\tJoueur 2 joue:"+c2+"\n\tJoueur 3 joue:"+c3+"\n\tJoueur 4 joue:"+c4+"\n");
				
				while(!table.estVide())
					jb.ramasse(table.pioche());
				
				sortie.append("\n\tLe joueur "+jb.nom+" gagne le tour "+tour+"\n");
				sortie.append(ja+"\n"+jb+"\n"+jc+"\n"+jd+"\n");

			}
			
			//Joueur 3 gagne le tour
			if(c3.estPlusFort(c1) && c3.estPlusFort(c2) && c3.estPlusFort(c4))
			{
				sortie.append("\ntour: "+tour+"\n");
				//sortie.append("\ntable:\n"+ table);
				sortie.append("\ntable:\n\tJoueur 1 joue:"+c1+"\n\tJoueur 2 joue:"+c2+"\n\tJoueur 3 joue:"+c3+"\n\tJoueur 4 joue:"+c4+"\n");
				
				while(!table.estVide())
					jc.ramasse(table.pioche());

				sortie.append("\n\tLe joueur "+jc.nom+" gagne le tour "+tour+"\n");
				sortie.append(ja+"\n"+jb+"\n"+jc+"\n"+jd+"\n");

			}
			
			//Joueur 4 gagne le tour
			if(c4.estPlusFort(c1) && c4.estPlusFort(c2) && c4.estPlusFort(c3))
			{
				sortie.append("\ntour: "+tour+"\n");
				//sortie.append("\ntable:\n"+ table);
				sortie.append("\ntable:\n\tJoueur 1 joue:"+c1+"\n\tJoueur 2 joue:"+c2+"\n\tJoueur 3 joue:"+c3+"\n\tJoueur 4 joue:"+c4+"\n");
				
				while(!table.estVide())
					jd.ramasse(table.pioche());

				sortie.append("\n\tLe joueur "+jd.nom+" gagne le tour "+tour+"\n");
				sortie.append(ja+"\n"+jb+"\n"+jc+"\n"+jd+"\n");
			}
			
			//Si égalité choix d'un vainqueur aléatoirement
			if(c1.estEgal(c2) && c1.estEgal(c3) && c1.estEgal(c4))
			{
				int winner = (int)( Math.random()*( 4 - 0 + 1 ) ) + 0; //Choix du vainqueur aléatoirement
				sortie.append("Egalité");
				if(winner == 1)
				{
					while(!table.estVide())
						ja.ramasse(table.pioche());

					sortie.append("\n\tLe joueur "+ja.nom+" gagne le tour "+tour+"\n");
					sortie.append(ja+"\n"+jb+"\n"+jc+"\n"+jd+"\n");
				}

				if(winner==2)
				{
					while(!table.estVide())
						jb.ramasse(table.pioche());

					sortie.append("\n\tLe joueur "+jb.nom+" gagne le tour "+tour+"\n");
					sortie.append(ja+"\n"+jb+"\n"+jc+"\n"+jd+"\n");
				}

				if(winner==3)
				{
					while(!table.estVide())
						jc.ramasse(table.pioche());

					sortie.append("\n\tLe joueur "+jc.nom+" gagne le tour "+tour+"\n");
					sortie.append(ja+"\n"+jb+"\n"+jc+"\n"+jd+"\n");
				}

				if(winner==4){
					while(!table.estVide())
						jd.ramasse(table.pioche());

					sortie.append("\n\tLe joueur "+jd.nom+" gagne le tour "+tour+"\n");
					sortie.append(ja+"\n"+jb+"\n"+jc+"\n"+jd+"\n");
				}

			}

		}


		//Le joueur qui possède le plus de car dans son pli, gagne la partie
		if(ja.pli.getNb_Carte()>jb.pli.getNb_Carte() && ja.pli.getNb_Carte()>jc.pli.getNb_Carte() && ja.pli.getNb_Carte()>jd.pli.getNb_Carte()  )
			sortie.append("\n\tLe joueur "+ja.nom+" gagne la partie\n");
		else if(jb.pli.getNb_Carte()>ja.pli.getNb_Carte() && jb.pli.getNb_Carte()>jc.pli.getNb_Carte() && jb.pli.getNb_Carte()>jd.pli.getNb_Carte() )
			sortie.append("\n\tLe joueur "+jb.nom+" gagne la partie\n");
		else if(jc.pli.getNb_Carte()>ja.pli.getNb_Carte() && jc.pli.getNb_Carte()>jb.pli.getNb_Carte() && jc.pli.getNb_Carte()>jd.pli.getNb_Carte())
			sortie.append("\n\tLe joueur "+jc.nom+" gagne la partie\n");
		else if(jd.pli.getNb_Carte()>ja.pli.getNb_Carte() && jd.pli.getNb_Carte()>jb.pli.getNb_Carte() && jd.pli.getNb_Carte()>jc.pli.getNb_Carte() )
			sortie.append("\n\tLe joueur "+jd.nom+" gagne la partie\n");
		else
			sortie.append("\n\tLa partie est nulle, égalité\n");

		return sortie;


	}

}

