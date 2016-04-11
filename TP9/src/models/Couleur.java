package models;

/**
 * Jeu de Go
 * Liste des couleurs disponibles pour les pierres
 * 
 * @package models
 * 
 * @author Thibault Vlacich
 * @author Hugo Michard
 */

import java.awt.Color;

public enum Couleur {
  NOIR, BLANC;
  
  public static String getColorName(Couleur c) {
    if(c == BLANC) return "blanc";
    else return "noir";
  }
  
  public static Color getDrawColor(Couleur c) {
    if(c == BLANC) return Color.WHITE;
    else return Color.BLACK;
  }
}
