package tests;

import models.*;

public class Test {
  public static void Test1() {
    Voiture twingo = new Voiture("Twingo", 2016, 16000, "1234 AZ 49", true);
    
    twingo.afficherVoiture();
    
    System.out.println("Cout de location de la Twingo : "+twingo.coutLocation());
    
    System.out.println();
  }
  
  public static void Test2() {
    Camion j9 = new Camion("J9", 2011, 20000, "987 BCD 75", 25);
    
    j9.afficherCamion();
    
    System.out.println("Ce camion peut-il transporter 7m2 ? "+(j9.peutTransporterVolume(7) ? "Oui" : "Non"));
    
    System.out.println("Cout de location du camion J9 : "+j9.coutLocation());
    
    System.out.println();
  }
  
  public static void Test3() {
    Autocar FRI = new Autocar("FRI", 2005, 90000, "4567WX01", 3, 53);
    
    FRI.afficherAutocar();
    
    System.out.println("Cet autocar peut-il transporter 40 passagers ayant chacun 0,1 m3 de baggage ? "+(FRI.peuxTransporterPassagers(40, 40*0.1) ? "Oui" : "Non"));
    
    System.out.println();
  }
}
