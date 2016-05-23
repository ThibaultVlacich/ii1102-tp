package models;

import java.util.ArrayList;

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
  
  public int getLibertespropre(int abscisse, int ordonnee, Joueur joueur){
    int libertespropre = 0;
    if(abscisse > 0 && this.plateau[abscisse-1][ordonnee] == null){
      libertespropre ++;
    }
    if(abscisse < taille && this.plateau[abscisse+1][ordonnee] == null){
      libertespropre ++;
    }
    if(ordonnee > 0 && this.plateau[abscisse][ordonnee-1] == null){
      libertespropre ++;
    }
    if(ordonnee < taille && this.plateau[abscisse][ordonnee+1] == null){
      libertespropre ++;
    }
    return libertespropre;
  }
  
 public int getLibertes(int abscisse, int ordonnee, Joueur joueur, ArrayList<Integer[]> listetest){
   int libertes = 0;
   libertes = getLibertespropre(abscisse, ordonnee, joueur);
   
   Integer[] coordonees = {abscisse-1, ordonnee};
   if(abscisse > 0 && this.plateau[abscisse-1][ordonnee] == joueur && !listetest.contains(coordonees)){
     listetest.add(coordonees);
     libertes += getLibertes(abscisse-1,ordonnee,joueur, listetest);
   }
   
   Integer[] coordonees2 = {abscisse+1, ordonnee};
   if(taille < abscisse && this.plateau[abscisse+1][ordonnee] == joueur && !listetest.contains(coordonees2)){
     listetest.add(coordonees2);
     libertes += getLibertes(abscisse+1,ordonnee,joueur, listetest);
   }
   
   Integer[] coordonees3 = {abscisse, ordonnee-1};
   if(ordonnee > 0 && this.plateau[abscisse][ordonnee-1] == joueur && !listetest.contains(coordonees3)){
     listetest.add(coordonees3);
     libertes += getLibertes(abscisse,ordonnee-1,joueur, listetest);
   }
   
   Integer[] coordonees4 = {abscisse, ordonnee+1};
   if(taille < ordonnee && this.plateau[abscisse][ordonnee+1] == joueur && !listetest.contains(coordonees4)){
     listetest.add(coordonees4);
     libertes += getLibertes(abscisse,ordonnee+1,joueur, listetest);
   }
   
   
   return libertes;
 }
 
 public int getLibertes(int abscisse, int ordonnee, Joueur joueur){
   
   return getLibertes(abscisse, ordonnee, joueur, new ArrayList<Integer[]>());
 }
  
  
}
