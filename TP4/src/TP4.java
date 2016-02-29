import java.util.Scanner;

public class TP4 {
	
	static Scanner scan = new Scanner(System.in);
	
	static double t = 0;
	static Balle balle;
	static Espace espace;

	public static void main(String[] args) {
		
		System.out.println("Définir la balle");
		System.out.println("Masse :");
		
		double masse = scan.nextDouble();
		
		System.out.println("Position initiale x :");
		
		double x0 = scan.nextDouble();
		
		System.out.println("Position initiale y :");
		
		double y0 = scan.nextDouble();
		
		System.out.println("Vitesse initiale (0 si nulle) :");
		
		double v0 = scan.nextDouble();
		
		balle = new Balle(x0, y0, v0, masse);
		
		System.out.println("Définir l'espace");
		System.out.println("Hauteur :");
		
		double hauteur = scan.nextDouble();
		
		System.out.println("Longueur :");
		
		double longueur = scan.nextDouble();
		
		System.out.println("G (optionnel) :");
		
		double G = scan.nextDouble();
		
		espace = new Espace(hauteur, longueur, G);
		
		System.out.println("Définir le pas :");
		
		double pas = scan.nextDouble();

		double posy = balle.getPosy();

		StdDraw.setXscale(0, espace.getHauteur());
		StdDraw.setYscale(0, espace.getLongueur());
		
		while(posy > 0){
			StdDraw.clear(StdDraw.GRAY);
			balle.move(pas, espace.G);
			posy = balle.getPosy();
			if(posy < 0){
				balle.setPosy(0);
			}
			//System.out.println("La position de la balle est : ["+balle.getPosx()+","+balle.getPosy()+"] ");
			balle.draw();
		}
		
	}
}
