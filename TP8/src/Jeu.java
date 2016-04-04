
public class Jeu {
	public static final int FPS = 5;
	
	public static void afficheConsole(boolean[][] grille) {
		int m = grille.length;
		int n = grille[0].length;
		
		for(int i = 0; i < m; i++) {
			System.out.print("|");
			for(int j = 0; j < n; j++) {
				if(grille[i][j] == true) {
					System.out.print("X");
				} else {
					System.out.print(" ");
				}
				System.out.print("|");
			}
			System.out.println("");
		}
	}
	
	public static void affiche2D(boolean [][] grille) {
		int m = grille.length;
		int n = grille[0].length;
		
		StdDraw.setXscale(-1, n);
		StdDraw.setYscale(-1, m);
		
		StdDraw.clear();
		StdDraw.line(-0.5, m-0.5, n-0.5, m-0.5);
		StdDraw.line(n-0.5, -0.5, n-0.5, m-0.5);

		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				StdDraw.line(j-0.5, i-0.5, j-0.5, i+0.5);
				StdDraw.line(j-0.5, i-0.5, j+0.5, i-0.5);
				if(grille[i][j] == true) {
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledCircle(j, i, 0.5);
				}
			}
		}
	}
	
	public static int comptage(boolean[][] grille, int i, int j) {
		int m = grille.length;
		int n = grille[0].length;
		
	    int k = 0;
	    
	    for(int p = i-1; p <= i+1; p++) {
	    	for(int q = j-1; q <= j+1; q++) {
	    		if(p >= 0 && q >= 0 && p <= n - 1 && q <= m - 1) {
	    			if(grille[q][p] == true && !(p == i && q == j)) {
	    				k++;
	    			}
	    		}
	    	}
	    }

	    return k;
	}
	
	public static boolean[][] step(boolean[][] grille) {
		int m = grille.length;
		int n = grille[0].length;
		
		boolean[][] grilleNext = new boolean[m][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int compte = comptage(grille, i, j);
				
				if(compte == 3) {
					grilleNext[j][i] = true;
				} else if (grille[j][i] == true && compte == 2) {
					grilleNext[j][i] = true;
				} else {
					grilleNext[j][i] = false;
				}
			}
		}
		
		return grilleNext;
	}
}
