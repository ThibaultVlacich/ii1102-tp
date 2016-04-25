package main;

/**
 * Jeu de Go - Main class
 * 
 * @package main
 * 
 * @author Thibault Vlacich
 * @author Hugo Michard
 */

// Import the game main class
import moteur.Moteur;

public class Main {
  public static void main(String[] args) {
    System.out.println("###\t\tAlgo et programmation - TP9\t\t###");
    System.out.println("###\tFait par Thibault VLACICH et Hugo MICHARD\t###");
    System.out.println("###\t\t\tJeu de Go\t\t\t###");
    System.out.println("");
    
    Moteur m = new Moteur();
    
    m.startGame();
    
    Utils.scan.close();
  }
}
