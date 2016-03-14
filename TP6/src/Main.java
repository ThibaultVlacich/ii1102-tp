
public class Main {

	public static void main(String[] args) {
		ArbreBinaire arbre = new ArbreBinaire("B", "D", "E");
		
		ArbreBinaire arbre2 = new ArbreBinaire("A", arbre, "C");

		int profondeur = profondeurArbre(arbre2);
		
		System.out.println(profondeur);
	}
	
	private static int profondeurArbre(ArbreBinaire arbre) {
		int profondeur = 0;
		int profondeurGauche = 0;
		int profondeurDroite = 0;
		
		if(arbre.filsGauche != null) {
			profondeurGauche = profondeurArbre(arbre.filsGauche);
		}
		
		if(arbre.filsDroit != null) {
			profondeurDroite = profondeurArbre(arbre.filsDroit);
		}
		
		profondeur += Math.max(profondeurGauche, profondeurDroite);
		
		return profondeur;
	}

}
