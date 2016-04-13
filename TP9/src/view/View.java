package view;

/**
 * Jeu de Go - View
 * 
 * @package view
 * 
 * @author Thibault Vlacich
 * @author Hugo Michard
 */

// Importe le package StdDraw
import edu.princeton.cs.introcs.StdDraw;

// Importe les modèles nécessaires
import models.Couleur;
import models.Goban;
import models.Joueur;

public class View {
  // Permet d'afficher le plateau de jeu
  public static void drawGoban(Goban goban) {
    int taille = goban.getTaille();
    
    StdDraw.setXscale(-2, taille + 1);
    StdDraw.setYscale(-2, taille + 1);

    StdDraw.clear(StdDraw.YELLOW);
    
    // Dessine les graduations de la grille
    for(int blabla = 0; blabla <= taille; blabla++) {
      // Abscisses
      StdDraw.text(blabla - 0.5, -1.5, Integer.toString(blabla));
      // Ordonnées
      StdDraw.text(-1.5, blabla - 0.5, Integer.toString(blabla));
    }

    for(int i = 0; i < taille; i++) {
      for(int j = 0; j < taille; j++) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(i, j, 0.5);
        
        if(goban.getPlateau(i, j) != null) {
          Joueur joueur = goban.getPlateau(i, j);
          
          StdDraw.setPenColor(Couleur.getDrawColor(joueur.getCouleur()));
        
          StdDraw.filledCircle(j - 0.5, i - 0.5, 0.4);
        }
      }
    }
  }
}
