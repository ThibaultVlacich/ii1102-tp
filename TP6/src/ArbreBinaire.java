
import java.util.ArrayList;

public class ArbreBinaire {
	public String sommet;
	public ArbreBinaire filsGauche = null;
	public ArbreBinaire filsDroit = null;
	
	public ArbreBinaire(String sommet) {
		this.sommet = sommet;
	}
	
	public ArbreBinaire(String sommet, String filsGauche, String filsDroit) {
		this.sommet = sommet;
		this.filsGauche = new ArbreBinaire(filsGauche);
		this.filsDroit = new ArbreBinaire(filsDroit);
	}
	
	public ArbreBinaire(String sommet, ArbreBinaire filsGauche, ArbreBinaire filsDroit) {
		this.sommet = sommet;
		this.filsGauche = filsGauche;
		this.filsDroit = filsDroit;
	}
	
	public ArbreBinaire(String sommet, String filsGauche, ArbreBinaire filsDroit) {
		this.sommet = sommet;
		this.filsGauche = new ArbreBinaire(filsGauche);
		this.filsDroit = filsDroit;
	}
	
	public ArbreBinaire(String sommet, ArbreBinaire filsGauche, String filsDroit) {
		this.sommet = sommet;
		this.filsGauche = filsGauche;
		this.filsDroit = new ArbreBinaire(filsDroit);
	}
}
