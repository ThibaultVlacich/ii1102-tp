
public class Espace {
	public double G = 9.81;

	private double hauteur;
	private double longueur;

	/**
	 * Constructeur de la classe Espace
	 * 
	 * @param double	hauteur_	Hauteur de l'espace
	 * @param double	longueur_	Longueur de l'espace
	 */
	public Espace(double hauteur_, double longueur_) {
		hauteur = hauteur_;
		longueur = longueur_;
	}

	/**
	 * Constructeur de la classe Espace
	 * 
	 * @param double	hauteur_	Hauteur de l'espace
	 * @param double	longueur_	Longueur de l'espace
	 * @param double	G_			Valeur de la gravitation dans l'espace
	 */
	public Espace(double hauteur_, double longueur_, double G_) {
		G = G_;
		hauteur = hauteur_;
		longueur = longueur_;
	}

	public double getHauteur() {
		return hauteur;
	}

	public double getLongueur() {
		return longueur;
	}
}
