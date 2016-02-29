
public class Espace {
	public double G = 9.81;
	private double hauteur;
	public double getHauteur() {
		return hauteur;
	}

	public double getLongueur() {
		return longueur;
	}

	private double longueur;
	
	public Espace(double hauteur_, double longueur_) {
		hauteur = hauteur_;
		longueur = longueur_;
	}
	
	public Espace(double hauteur_, double longueur_, double G_) {
		G = G_;
		hauteur = hauteur_;
		longueur = longueur_;
	}
	
}
