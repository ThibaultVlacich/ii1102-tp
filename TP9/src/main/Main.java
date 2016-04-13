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
    System.out.println("### Algorithmique et programmation - TP4 ###");
    System.out.println("### Fait par Thibault VLACICH et Hugo MICHARD ###");
    System.out.println("### Jeu de Go ###");
    
    Moteur m = new Moteur();
    
    m.startGame();
    
    Utils.scan.close();
  }
  
}
