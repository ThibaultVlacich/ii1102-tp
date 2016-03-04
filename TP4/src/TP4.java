import java.util.Scanner;

public class TP4 {
	
	static Scanner scan = new Scanner(System.in);
	
	static Balle balle;
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
            		balle = new Balle(pos0, v0, 2.0);
            		
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
            		balle = new Balle(pos0, v0, 2.0);
            		
            		espace = new Espace(50.0, 50.0);
            	}
            	
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
		
		balle = new Balle(pos0, v0, rayon);
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
			 
			 balle.move(espace, pas);
			 System.out.println("x : "+balle.getPosx()+", y : "+balle.getPosy());
			 
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
			 
			 balle.move(espace, pas);
			 balle.draw();
			 
		 }
	}
}
