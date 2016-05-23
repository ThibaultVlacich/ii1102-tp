package models;

public class Autocar extends Vehicule {
  private int volume;
  private int nbPassagers;
  
  Autocar(String _modele, int _anneeAchat, float _prixAchat, String _immatriculation, char _typePermis, int _volume, int _nbPassagers) {
    super(_modele, _anneeAchat, _prixAchat, _immatriculation, _typePermis);
    
    volume      = _volume;
    nbPassagers = _nbPassagers;
  }
}
