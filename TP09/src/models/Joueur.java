package models;

/**
 * Jeu de Go
 * Classe Joueur
 * 
 * @package models
 * 
 * @author Thibault Vlacich
 * @author Hugo Michard
 */

public class Joueur {
  private int nbPrisonniers = 0;
  
  // Couleur du joueur
  private Couleur couleur;
  
  // Le joueur a-t-il passé au tour précédent ?
  private Boolean passed = false;
  
  public Joueur(Couleur _couleur) {
    this.couleur = _couleur;
  }

  public int getNbPrisonniers() {
    return nbPrisonniers;
  }

  public void setNbPrisonniers(int nbPrisonniers) {
    this.nbPrisonniers = nbPrisonniers;
  }

  public Couleur getCouleur() {
    return couleur;
  }
  
  public Boolean passed() {
    return this.passed;
  }
  
  public void setPassed(Boolean p) {
    this.passed = p;
  }
}
