package models;

public class Voiture extends Vehicule {
  private Boolean autoradio;
  
  Voiture(String _modele, int _anneeAchat, float _prixAchat, String _immatriculation, char _typePermis, Boolean _autoradio) {
    super(_modele, _anneeAchat, _prixAchat, _immatriculation, _typePermis);
    
    autoradio = _autoradio;
  }
}
