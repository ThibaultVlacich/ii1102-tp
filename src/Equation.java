import java.util.Scanner;


public class Equation {
    public static void main(String [] args) {

	System.out.println("Calcul des solutions d'une équation du second degré ax² + bx + c =0");

	Scanner scan = new Scanner(System.in);
	
	System.out.println("Veuillez saisir la valeur de a");
	double a = scan.nextDouble();

	System.out.println("Veuillez saisir la valeur de b");
	double b = scan.nextDouble();

	System.out.println("Veuillez saisir la valeur de c");
	double c = scan.nextDouble();

	double discriminant = b*b - 4*a*c;

	if (discriminant < 0) {
		System.out.println("Erreur : il n'y a pas de solutions réelles à l'équation "+a+"x² + "+b+"x + "+c+" = 0");
	} else if (discriminant == 0) {
		double solution = -b/(2*a);

		System.out.println("L'unique solution à l'équation "+a+"x² + "+b+"x + "+c+" = 0 est : "+solution);
	} else {
		double solution1 = (-b + Math.sqrt(discriminant))/(2*a);
		double solution2 = (-b - Math.sqrt(discriminant))/(2*a);

		System.out.println("Les deux solutions à l'équation "+a+"x² + "+b+"x + "+c+" = 0 sont : "+solution1+" et "+solution2);
	}
    }
}
