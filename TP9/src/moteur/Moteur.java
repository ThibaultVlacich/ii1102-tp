package moteur;

import edu.princeton.cs.introcs.StdDraw;

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
    
    int taille = View.drawGridSizeChoice();
    
    goban = new Goban(taille);
  }
  
  // Débute la partie
  public void startGame() {
    Joueur joueurActuel;
    
    // On dessine le plateau de jeu initial
    View.drawGoban(goban, true);
    
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
  
    /*System.out.println("Voulez-vous passer votre tour ? (O/N)");
  
    String commande = Utils.scan.next();
  
    if(commande.equalsIgnoreCase("o")){
      // Le joueur a choisi de passer
      joueur.setPassed(true);
      
      return joueur;
    }*/
  
    int abscisse, ordonnee;
    
    System.out.println("Veuillez choisir une intersection en cliquant sur la grille.");
    
    while (true) {
      if (StdDraw.mousePressed()) {
        abscisse = (int) Math.round(StdDraw.mouseY());
        ordonnee = (int) Math.round(StdDraw.mouseX());
        
        // Tempo pour éviter que StdDraw.mousePressed() reste à true
        try {
          Thread.sleep(100);
        } catch (Exception e) { }
        
        System.out.println("Abscisse : "+abscisse+", ordonnée : "+ordonnee);
        
        // Vérifions que la case est bien libre
        if (isIntersectionFree(abscisse, ordonnee)) {
          break;
        } else {
          System.out.println("La case que vous avez choisie est déjà prise, veuillez en choisir une autre !");
        }
      }
    }
    
    // Assignons la case choisie au joueur
    goban.modifier(abscisse, ordonnee, joueur);
    
    return joueur;
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
