package models;

import java.time.Year;

public abstract class Vehicule {
  private String  modele;
  private int     anneeAchat;
  private float   prixAchat;
  private String  immatriculation;
  private char    typePermis;
  
  public Vehicule(String _modele, int _anneeAchat, float _prixAchat, String _immatriculation, char _typePermis) {
    modele          = _modele;
    anneeAchat      = _anneeAchat;
    prixAchat       = _prixAchat;
    immatriculation = _immatriculation;
    typePermis      = _typePermis;
  }
  
  
  /**
   * Retourne l'âge du véhicule
   * 
   * @return  int
   */
  public final int age() {
    int anneeActuelle = Year.now().getValue();
    
    return anneeActuelle - anneeAchat;
  }
  
  /**
   * Permet d'afficher une chaîne de caractère décrivant le véhicule
   */
  public void afficherVehicule() {
    System.out.println("Modèle du véhicule : "+modele);
    System.out.println("Annee d'achat : "+anneeAchat);
    System.out.println("Prix achat : "+prixAchat);
    System.out.println("Immatriculation : "+immatriculation);
    System.out.println("Type de permis requis : "+typePermis);
  }
  
  /**
   * Permet de calculer le coût de location du véhicule
   * 
   * @return  float Le coût de location du véhicule
   */
  public float coutLocation() {
    int age = age();
    
    return prixAchat / ((age <= 1) ? 200 : 250);
  }
}
