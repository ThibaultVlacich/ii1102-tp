package models;

public class Voiture extends Vehicule {
  private Boolean autoradio;
  
  public Voiture(String _modele, int _anneeAchat, float _prixAchat, String _immatriculation, Boolean _autoradio) {
    super(_modele, _anneeAchat, _prixAchat, _immatriculation, 'B');
    
    autoradio = _autoradio;
  }
  
  /**
   * Permet d'ajouter un autoradio à la voiture
   */
  public void ajouterAutoradio() {
    autoradio = true;
  }
  
  /**
   * Permet d'enlever l'autoratio à la voiture
   */
  public void enleverAutoradio() {
    autoradio = false;
  }
  
  /**
   * Permet d'afficher une chaîne de caractère décrivant la voiture
   */
  public void afficherVoiture() {
    super.afficherVehicule();
    
    System.out.println("Possède un autoradio : "+(autoradio ? "Oui" : "Non"));
  }
}
