package models;

public class Camion extends Vehicule {
  private int volume;
  
  public Camion(String _modele, int _anneeAchat, float _prixAchat, String _immatriculation, int _volume) {
    super(_modele, _anneeAchat, _prixAchat, _immatriculation, 'C');
    
    volume = _volume;
  }
  
  /**
   * Permet d'afficher une chaîne de caractère décrivant le camion
   */
  public void afficherCamion() {
    super.afficherVehicule();
    
    System.out.println("Volume de stockage du camion : "+volume);
  }
  
  /**
   * Détermine si le camion peut transporter un volume donner
   * 
   * @param _volume Le volume à transporter
   * 
   * @return  Boolean
   */
  public Boolean peutTransporterVolume(int _volume) {
    return (volume > _volume);
  }
}
