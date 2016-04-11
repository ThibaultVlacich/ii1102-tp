package jeudego;

import java.util.Scanner;

public class Startup {
  
  static Scanner scan = new Scanner(System.in);
  
  static Joueur joueur1;
  static Joueur joueur2;
  
  static Goban goban;

  public static void main(String[] args) {
    joueur1 = new Joueur("blanc");
    joueur2 = new Joueur("noir");
    
    int taille = 0;
    
    while ((taille != 9 && taille != 13 && taille != 19)) {
      System.out.println("Veuillez saisir la taille de la grille (9, 13 ou 19)");
    
      taille = scan.nextInt();
    }
    
    goban = new Goban(taille);
    
    int choix2 = 0;
    int passe = 0;
    while (passe < 2) {
      passe = 0;
      
      if(tourDeJeu(joueur1) == 0) {
        passe++;
      }
      else{
        choix2 = 0;
      }
      if(choix2 == 0){
        if(tourDeJeu(joueur2) == 0) {
          passe++;
          choix2 = 1;
        }
      }
      
      goban.affiche();
    }
  }

  public static int tourDeJeu(Joueur joueur) {
    System.out.println("Tour du joueur "+joueur.getCouleur());
    
    System.out.println("Voulez-vous passer ? (Y/N)");
    
    String commande = scan.next();
    
    if(commande.equalsIgnoreCase("n")){
      System.out.println("Choisissez une case");
      
      System.out.println("Abscisse : ");
      int abscisse = scan.nextInt();
      
      while (abscisse < 0 || abscisse > goban.getTaille()) {
        if(abscisse < 0){
          System.out.println("La valeur choisie en abscisse est négative, veuillez en saisir une positive ! ");
          abscisse = scan.nextInt();
        }
        else{
          System.out.println("La valeur choisie en abscisse est supérieure à " +goban.getTaille()+", veuillez saisir une valeur plus faible ! ");
          abscisse = scan.nextInt();
        }
      }
      
      System.out.println("Ordonnée : ");
      int ordonnee = scan.nextInt();
      
      while (ordonnee < 0 || ordonnee > goban.getTaille()){
        if(ordonnee < 0){
          System.out.println("La valeur choisie en ordonnee est négative, veuillez en saisir une positive ! ");
          ordonnee = scan.nextInt();
        }
        else{
          System.out.println("La valeur choisie en ordonnee est supérieure à " +goban.getTaille()+", veuillez saisir une valeur plus faible ! ");
          ordonnee = scan.nextInt();
        }
      }
      
      goban.modifier(abscisse, ordonnee, joueur);
      
      return 0;
    }
    else{
      return 1;
    }
  }
  
}
