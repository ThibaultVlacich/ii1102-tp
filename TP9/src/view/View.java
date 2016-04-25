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
    
    StdDraw.setXscale(-1, taille + 1);
    StdDraw.setYscale(-1, taille + 1);

    StdDraw.clear(StdDraw.YELLOW);
    
    StdDraw.setPenColor(StdDraw.BLACK);
    
    // Affiche les graduations de la grille
    for(int blabla = 0; blabla <= taille; blabla++) {
      // Abscisses
      StdDraw.text(blabla, -0.5, Integer.toString(blabla));
      // Ordonnées
      StdDraw.text(-0.5, blabla, Integer.toString(blabla));
    }
    
    // Dessine le quadrillage de la grille
    for(int i = 0; i < taille; i++) {
      for(int j = 0; j < taille; j++) {
        StdDraw.square(i + 0.5, j + 0.5, 0.5);
      }
    }
    
    // Place les pions sur la grille
    for(int i = 0; i <= taille; i++) {
      for(int j = 0; j <= taille; j++) {
        if(goban.getPlateau(i, j) != null) {
          Joueur joueur = goban.getPlateau(i, j);
          
          StdDraw.setPenColor(Couleur.getDrawColor(joueur.getCouleur()));
        
          StdDraw.filledCircle(j, i, 0.4);
        }
      }
    }
  }
}
