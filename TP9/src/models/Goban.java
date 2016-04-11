package models;

import edu.princeton.cs.introcs.StdDraw;

public class Goban {
  private int taille;
  private Joueur[][] plateau;
  
  public Goban(int _taille) {
    this.taille = _taille;
    
    plateau = new Joueur[this.taille][this.taille];
  }

  public int getTaille() {
    return taille;
  }
  
  public void modifier(int abscisse, int ordonnee, Joueur joueur){
    this.plateau[ordonnee][abscisse] = joueur;
  }
  
  public void affiche() {
    StdDraw.setXscale(-1, this.taille);
    StdDraw.setYscale(-1, this.taille);

    StdDraw.clear();
    StdDraw.line(-0.5, this.taille-0.5, this.taille-0.5, this.taille-0.5);
    StdDraw.line(this.taille-0.5, -0.5, this.taille-0.5, this.taille-0.5);

    for(int i = 0; i < this.taille; i++) {
      for(int j = 0; j < this.taille; j++) {
        StdDraw.line(j-0.5, i-0.5, j-0.5, i+0.5);
        StdDraw.line(j-0.5, i-0.5, j+0.5, i-0.5);
        
        if(plateau[i][j] != null) {
          Joueur joueur = plateau[i][j];
          
          StdDraw.setPenColor(Couleur.getDrawColor(joueur.getCouleur()));
        
          StdDraw.filledCircle(j, i, 0.5);
        }
      }
    }
  }
  
}
