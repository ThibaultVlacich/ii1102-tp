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
    joueur1 = new Joueur(Couleur.BLANC);
    joueur2 = new Joueur(Couleur.NOIR);
    
    int taille = 0;
    
    while ((taille != 9 && taille != 13 && taille != 19)) {
      System.out.println("Veuillez saisir la taille de la grille (9, 13 ou 19)");
    
      taille = Utils.scan.nextInt();
    }
    
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
    System.out.println("Tour du joueur "+Couleur.getColorName(joueur.getCouleur()));
  
    System.out.println("Voulez-vous passer votre tour ? (O/N)");
  
    String commande = Utils.scan.next();
  
    if(commande.equalsIgnoreCase("o")){
      joueur.setPassed(true);
      
      return joueur;
    }
  
    System.out.println("Choisissez une case");
  
    System.out.println("Abscisse : ");
    int abscisse = Utils.scan.nextInt();
  
    while (abscisse < 0 || abscisse > goban.getTaille()) {
      if(abscisse < 0){
        System.out.println("La valeur choisie en abscisse est négative, veuillez en saisir une positive ! ");
        abscisse = Utils.scan.nextInt();
      } else {
        System.out.println("La valeur choisie en abscisse est supérieure à " +goban.getTaille()+", veuillez saisir une valeur plus faible ! ");
        abscisse = Utils.scan.nextInt();
      }
    }
    
    System.out.println("Ordonnée : ");
    int ordonnee = Utils.scan.nextInt();
    
    while (ordonnee < 0 || ordonnee > goban.getTaille()){
      if(ordonnee < 0){
        System.out.println("La valeur choisie en ordonnee est négative, veuillez en saisir une positive ! ");
        ordonnee = Utils.scan.nextInt();
      } else {
        System.out.println("La valeur choisie en ordonnee est supérieure à " +goban.getTaille()+", veuillez saisir une valeur plus faible ! ");
        ordonnee = Utils.scan.nextInt();
      }
    }
    
    goban.modifier(abscisse, ordonnee, joueur);
    
    return joueur;
  }
  
  // Fin de la partie
  private void endGame() {
    System.out.println("Partie terminée");
  }
}
