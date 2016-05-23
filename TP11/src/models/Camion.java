package models;

public class Camion extends Vehicule {
  private int volume;
  
  public Camion(String _modele, int _anneeAchat, float _prixAchat, String _immatriculation, char _typePermis, int _volume) {
    super(_modele, _anneeAchat, _prixAchat, _immatriculation, _typePermis);
    
    volume = _volume;
  }
}
