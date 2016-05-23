import java.util.Scanner;
import java.util.ArrayList;

public class TP4 {

	static Scanner scan = new Scanner(System.in);

	static ArrayList<Balle> balles = new ArrayList<Balle>();
	static Espace espace;

	public static void main(String[] args) {
		boolean cont = true;

		System.out.println("### Algorithmique et programmation - TP4 ###");
		System.out.println("### Fait par Thibault VLACICH et Hugo MICHARD ###");

		do {
			cont = menu();
		} while(cont == true);
	}

	/**
	 * Affiche un menu
	 * 
	 * @return	boolean
	 */
	public static boolean menu() {
		int method = 0;
		String command;

		System.out.println("--- MENU ---");

		System.out.println("1 : Obtenir une liste des positions successives de la balle");
		System.out.println("2 : Animation graphique de la balle");
		System.out.println("\n0 : Quitter\n\n");

		System.out.print("Choisissez une option [1-2] : ");
		method = scan.nextInt();

		switch(method) {
		case 1:
			System.out.println("Voulez-vous définir une balle personalisée ? Y/N");
			command = scan.next(); 

			if(command.equalsIgnoreCase("Y")) {
				definirBalle();
				definirEspace();
			} else {
				double[] pos0 = {15.0, 45.0};
				double[] v0   = {10.0, 10.0};
				Balle balle = new Balle(pos0, v0, 2.0);
				
				balles.add(balle);

				espace = new Espace(50.0, 50.0);
			}

			ballePositions();
			break;
		case 2:
			System.out.println("Voulez-vous définir une balle personalisée ? Y/N");
			command = scan.next(); 

			if(command.equalsIgnoreCase("Y")) {
				definirBalle();
				definirEspace();
			} else {
				double[] pos0 = {15.0, 45.0};
				double[] v0   = {10.0, 10.0};
				Balle balle = new Balle(pos0, v0, 2.0);
				
				balles.add(balle);
			}
			
			Boolean cont = true;
			
			do {
				System.out.println("Voulez-vous ajouter une balle supplémentaires ? Y/N");
				command = scan.next();
				
				if(!command.equalsIgnoreCase("Y")) {
					cont = false;
					break;
				}
				
				System.out.println("Voulez-vous définir une balle personalisée ? Y/N");
				command = scan.next(); 

				if(command.equalsIgnoreCase("Y")) {
					definirBalle();
				} else {
					double[] pos0 = {20.0, 40.0};
					double[] v0   = {10.0, 10.0};
					Balle balle = new Balle(pos0, v0, 3.0);
					
					balles.add(balle);

					espace = new Espace(50.0, 50.0);
				}
			} while(cont);

			balleSimulation();
			break;
		default:
		case 0:
			return false;
		}

		System.out.println("\n--- Fin d'exécution de la méthode ---\n[Entrée] : Retour au menu...");

		scan.nextLine();
		scan.nextLine();
		return true;
	}

	/**
	 * Permet de définir une balle personalisée
	 */
	public static void definirBalle() {
		System.out.println("Définir la balle");
		System.out.println("Rayon :");

		double rayon = scan.nextDouble();

		System.out.println("Position initiale x :");

		double x0 = scan.nextDouble();

		System.out.println("Position initiale y :");

		double y0 = scan.nextDouble();

		double[] pos0 = {x0, y0};

		System.out.println("Vitesse initiale x (0 si nulle) :");

		double v0x = scan.nextDouble();

		System.out.println("Vitesse initiale y (0 si nulle) :");

		double v0y = scan.nextDouble();

		double[] v0 = {v0x, v0y};

		Balle balle = new Balle(pos0, v0, rayon);
		
		balles.add(balle);
	}

	/**
	 * Permet de définir un espace personalisé
	 */
	public static void definirEspace() {
		System.out.println("Définir l'espace");
		System.out.println("Hauteur :");

		double hauteur = scan.nextDouble();

		System.out.println("Longueur :");

		double longueur = scan.nextDouble();

		System.out.println("G (défaut : 9,81) :");

		double G = scan.nextDouble();

		espace = new Espace(hauteur, longueur, G);
	}

	/**
	 * Permet de lister la liste des positions successives
	 */
	public static void ballePositions() {
		System.out.println("Définir le pas :");

		double pas = scan.nextDouble();

		StdDraw.setXscale(0, espace.getHauteur());
		StdDraw.setYscale(0, espace.getLongueur());

		while(true) {
			int index = 1;
			for(Balle balle: balles) {
				balle.move(espace, pas);
				
				System.out.println("Balle n°"+index);
				System.out.println("x : "+balle.getPosx()+", y : "+balle.getPosy());
				
				index++;
			}
		}
	}

	/**
	 * Permet de simuler graphiquement le mouvement de la balle
	 */
	public static void balleSimulation() {
		System.out.println("Définir le pas :");

		double pas = scan.nextDouble();

		StdDraw.setXscale(0, espace.getHauteur());
		StdDraw.setYscale(0, espace.getLongueur());

		while(true) {
			StdDraw.clear(StdDraw.GRAY);
			
			for(Balle balle: balles) {
				balle.move(espace, pas);
				balle.draw();
			}
			
			StdDraw.show(50);
		}
	}
}
