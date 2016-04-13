package moteur;

/**
 * Jeu de Go - Moteur
 * 
 * @package moteur
 * 
 * @author Thibault Vlacich
 * @author Hugo Michard
 */

import main.Utils;

import models.Couleur;
import models.Goban;
import models.Joueur;

import view.View;

public class Moteur {
  // Liste des joueurs
  private Joueur joueur1;
  private Joueur joueur2;
  
  // Le plateau de jeu
  private Goban goban;
  
  // Constructeur de la classe
  public Moteur() {
    init();
  }
  
  // Initialiser les différentes attributs de la classe
  private void init() {
    joueur1 = new Joueur(Couleur.NOIR);
    joueur2 = new Joueur(Couleur.BLANC);
    
    int taille = 0;
    
    while ((taille != 9 && taille != 13 && taille != 19)) {
      System.out.println("Veuillez saisir la taille de la grille (9, 13 ou 19)");
    
      taille = Utils.scan.nextInt();
    }
    
    System.out.println("");
    
    goban = new Goban(taille);
  }
  
  // Débute la partie
  public void startGame() {
    Joueur joueurActuel;
    
    // Le joueur 1 commence
    joueurActuel = joueur1;
    
    while (true) {
      if (joueur1.passed() && joueur2.passed()) {
        break;
      }
      
      joueurActuel = tourDeJeu(joueurActuel);
      
      View.drawGoban(goban);
      
      joueurActuel = (joueurActuel == joueur1) ? joueur2 : joueur1;
    }
    
    endGame();
  }
  
  // Gère le tour du joueur
  private Joueur tourDeJeu(Joueur joueur) {
    String playerColor = Couleur.getColorName(joueur.getCouleur());
    
    System.out.println("Tour du joueur " + playerColor);
  
    System.out.println("Voulez-vous passer votre tour ? (O/N)");
  
    String commande = Utils.scan.next();
  
    if(commande.equalsIgnoreCase("o")){
      // Le joueur a choisi de passer
      joueur.setPassed(true);
      
      return joueur;
    }
  
    int abscisse, ordonnee;
    int[] choice;
    
    System.out.println("Veuillez choisir une intersection :");
    
    choice = this.askForIntersectionChoice();
    
    abscisse = choice[0];
    ordonnee = choice[1];
    
    // Vérifions que la case n'est pas déjà prise
    while (!isIntersectionFree(abscisse, ordonnee)) {
      // La case n'est pas libre !
      System.out.println("La case que vous avez choisie est déjà prise, veuillez en choisir une autre !");
      
      choice = this.askForIntersectionChoice();
      
      abscisse = choice[0];
      ordonnee = choice[1];
    }
    
    System.out.println("");
    
    // Assignons la case choisie au joueur
    goban.modifier(abscisse, ordonnee, joueur);
    
    return joueur;
  }
  
  // Demande au joueur de saisir les coordonnées de la case qu'il souhaite contrôler
  private int[] askForIntersectionChoice() {
    System.out.println("Abscisse :");
    int abscisse = Utils.scan.nextInt();
  
    while (abscisse < 0 || abscisse > goban.getTaille()) {
      if(abscisse < 0){
        System.out.println("La valeur choisie en abscisse est négative, veuillez en saisir une positive !");
      } else {
        System.out.println("La valeur choisie en abscisse est supérieure à " + goban.getTaille() + ", veuillez saisir une valeur plus faible !");
      }
      
      abscisse = Utils.scan.nextInt();
    }
    
    System.out.println("Ordonnée :");
    int ordonnee = Utils.scan.nextInt();
    
    while (ordonnee < 0 || ordonnee > goban.getTaille()){
      if(ordonnee < 0){
        System.out.println("La valeur choisie en ordonnée est négative, veuillez en saisir une positive ! ");
      } else {
        System.out.println("La valeur choisie en ordonnée est supérieure à " + goban.getTaille() + ", veuillez saisir une valeur plus faible !");
      }
      
      ordonnee = Utils.scan.nextInt();
    }
    
    int[] returnValue = {abscisse, ordonnee};
    
    return returnValue;
  }
  
  // Vérifie si la case est libre
  public boolean isIntersectionFree(int i, int j) {
    if(goban.getPlateau(i, j) == null) {
      return true;
    }
    
    return false;
  }
  
  // Fin de la partie
  private void endGame() {
    System.out.println("Partie terminée");
  }
}
