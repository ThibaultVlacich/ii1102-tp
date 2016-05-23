package models;

public class Autocar extends Vehicule {
  private int volume;
  private int nbPassagers;
  
  public Autocar(String _modele, int _anneeAchat, float _prixAchat, String _immatriculation, char _typePermis, int _volume, int _nbPassagers) {
    super(_modele, _anneeAchat, _prixAchat, _immatriculation, _typePermis);
    
    volume      = _volume;
    nbPassagers = _nbPassagers;
  }
  
  /**
   * Permet d'afficher une chaîne de caractère décrivant l'autocar
   */
  public void afficherAutocar() {
    super.afficherVehicule();
    
    System.out.println("Volume de stockage de l'autocar : "+volume);
    System.out.println("Nombre de passagers dans l'autocar : "+nbPassagers);
  }
  
  public Boolean peuxTransporterPassagers(int _nbPassagers, int _volume) {
    return (nbPassagers >= _nbPassagers && volume >= _volume);
  }
}
