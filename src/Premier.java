import java.util.Scanner;

public class Premier {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
	
		System.out.println("Entrer le nombre à tester");
		int nombre = scan.nextInt();

		double racine = Math.sqrt(nombre);

		int k = 2;

		boolean isPremier = true;
		
		if (nombre < 0) {
		  isPremier = false;
		}

		while (k <= racine) {
			if (nombre % k == 0) {
				isPremier = false;			
			}

			k = k+1;		
		}

		if (isPremier) {
			System.out.println("Le nombre est premier");		
		} else {
			System.out.println("Le nombre n'est pas premier");
		}
	}
}
