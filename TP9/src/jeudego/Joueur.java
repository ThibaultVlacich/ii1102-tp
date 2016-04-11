package jeudego;

public class Joueur {
  private int nbPrisonniers = 0;
  private String couleur;
  
  public Joueur(String _couleur) {
    this.couleur = _couleur;
  }

  public int getNbPrisonniers() {
    return nbPrisonniers;
  }

  public void setNbPrisonniers(int nbPrisonniers) {
    this.nbPrisonniers = nbPrisonniers;
  }

  public String getCouleur() {
    return couleur;
  }
}
