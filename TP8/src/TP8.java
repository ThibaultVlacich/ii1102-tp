import java.io.IOException;
import java.util.Scanner;

public class TP8 {
	
	static int nLetterKeycode = 78;
	static int sLetterKeycode = 83;
	
	static boolean [][] defaultGrid = {
			{false, false, true, false},
			{true,  true,  true, false},
			{false, true, false, false}		
		};

	public static void main(String [] args) throws IOException {
		if(args.length > 0 && args[0].equals("console")) {
		    handleConsole();
		}
		else {
			handle2D();
		}
	 
	}
	
	private static void handle2D() {
		
		boolean[][] grille = defaultGrid;
		
		boolean[][] savedGrille = Jeu.read("save.txt");
		
		if(savedGrille != null) {
			grille = savedGrille;
			System.out.println("Grille lue depuis le fichier de sauvegarde");
		}
		
		while(true) {
			if (StdDraw.hasNextKeyTyped()) {
				if(StdDraw.isKeyPressed(nLetterKeycode)) {
					grille = Jeu.step(grille);
				}
				
				if(StdDraw.isKeyPressed(sLetterKeycode)) {
					Jeu.save(grille, "save.txt");
				}
			}
			
			StdDraw.clear();
			Jeu.affiche2D(grille);
			StdDraw.show(1000/Jeu.FPS);
		}
	}


	public static void handleConsole() {
		boolean[][] grille = defaultGrid;
		
		String ch = "a";
		Scanner scan = new Scanner(System.in);
		
		while(!ch.equals("q")) { // On quitte en appuyant sur "q" puis entrer
			Jeu.afficheConsole(grille);
			ch = scan.nextLine();
			grille = Jeu.step(grille);
		}
		
		scan.close();
		
	}

}
