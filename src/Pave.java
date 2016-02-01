import java.util.Scanner;

public class Pave {
	public static void main(String [] args) {
		float lo = askValue("longueur");
		float la = askValue("largeur");
		float h  = askValue("hauteur");

		float volume = h * lo * la;

		System.out.println("Le volume est égal à : "+volume);
	}

	public static float askValue(String name) {
		Scanner scan = new Scanner(System.in);	

		System.out.println("Veuillez taper la "+name);
		float value = scan.nextFloat();

		while (value < 0) {
			System.out.println("La valeur saisie est négative. Veuillez en saisir une positive.");
			value = scan.nextFloat();
		}

		return value;
	}
}

