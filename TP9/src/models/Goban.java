package models;

/**
 * Jeu de Go
 * Classe Goban
 * 
 * @package models
 * 
 * @author Thibault Vlacich
 * @author Hugo Michard
 */

public class Goban {
  // Taille du plateau de jeu (9, 13 ou 19)
  private int taille;
  
  // Etat actuel du plateau
  private Joueur[][] plateau;
  
  public Goban(int _taille) {
    this.taille = _taille;
    
    plateau = new Joueur[this.taille][this.taille];
  }
  
  public void modifier(int abscisse, int ordonnee, Joueur joueur){
    this.plateau[ordonnee][abscisse] = joueur;
  }
 
  public Joueur[][] getPlateau() {
    return this.plateau;
  }
  
  public int getTaille() {
    return taille;
  }
  
  public Joueur getPlateau(int i, int j) {
    return this.plateau[i][j];
  }
  
}
