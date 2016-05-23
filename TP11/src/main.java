import models.*;

public class main {
  public static void main(String[] args) {
    Voiture voiture   = new Voiture("Renault Twingo", 2006, 16000, "24 ZAE 343", 'B', true);
    Camion  camion    = new Camion("Renault truck", 2008, 50000, "54 RTE 34", 'C', 500);
    Autocar autocar   = new Autocar("Scania", 2004, 150000, "54 ER3 34", 'D', 500, 55);
  }
}
