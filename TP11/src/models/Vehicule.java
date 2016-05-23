package models;

public abstract class Vehicule {
  private String  modele;
  private int     anneeAchat;
  private float   prixAchat;
  private String  immatriculation;
  private char    typePermis;
  
  Vehicule(String _modele, int _anneeAchat, float _prixAchat, String _immatriculation, char _typePermis) {
    modele          = _modele;
    anneeAchat      = _anneeAchat;
    prixAchat       = _prixAchat;
    immatriculation = _immatriculation;
    typePermis      = _typePermis;
  }
}
