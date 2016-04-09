import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

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
	
	public static boolean[][] read(String fichier) {
			String line = null;
			
		    ArrayList<boolean[]> list = new ArrayList<boolean[]>();
		    
		    try {
		        BufferedReader reader = new BufferedReader(new FileReader(fichier));
		        
		        while((line = reader.readLine()) != null) {
		            line = line.replace(";", "");
		            
		            boolean[] lineB = new boolean[line.length()];
		            
		            for(int i = 0; i < line.length(); i++) {
		            	boolean val = false;
		            	
		            	if (line.charAt(i) == '1'){
		            		val = true;
		            	}
		            	
		            	lineB[i] = val;
		            }

		            list.add(lineB);
		        }
		        
		        reader.close();
		    } catch (Exception e) {
		        return null;
		    }

		    boolean[][] convList = new boolean[list.size()][list.get(0).length];

		    for(int n = 0; n < list.size(); n++) {
		         convList[n] = list.get(n); 
		    }
		    
		    return convList;
	}
	
	public static void save(boolean[][] grille, String fileName) {
		StringBuffer ligne = new StringBuffer();
		
		PrintWriter writer;
		try {
			writer = new PrintWriter(fileName,"UTF-8");
		
			for (boolean[] line : grille) {
				for(boolean tile : line) {
					String val = tile ? "1" : "0";
					ligne.append(val + ";");
				}
				
				writer.println(ligne);
				ligne.delete(0, ligne.length());
			}
			
			writer.close();
			
			System.out.println("Grille Sauvegardée");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
