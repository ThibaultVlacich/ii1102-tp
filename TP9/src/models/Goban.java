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
    
    plateau = new Joueur[this.taille + 1][this.taille + 1];
  }
  
  public void modifier(int abscisse, int ordonnee, Joueur joueur){
    this.plateau[abscisse][ordonnee] = joueur;
  }
 
  public Joueur[][] getPlateau() {
    return this.plateau;
  }
  
  public int getTaille() {
    return taille;
  }
  
  public Joueur getPlateau(int abscisse, int ordonnee) {
    return this.plateau[abscisse][ordonnee];
  }
  
}
