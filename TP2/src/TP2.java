import java.util.Scanner;
import java.util.Arrays;

public class TP2 {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Quelle fonction voulez-vous exécuter ? Tapez help pour connaitre la liste des fonctions.");
		
		String fonction = scan.next();

		switch (fonction) {
			case "help":
				System.out.println("Liste des fonctions disponibles : regle, puissance, premier, table, tabledemander, recherche");
			break;

			case "regle":
				regle_graduee();
			break;

			case "puissance":
				puissance();
			break;

			case "premier":
				premier();
			break;

			case "table":
				tableMultiplication();
			break;

			case "tabledemander":
				demanderTable();
			break;

			case "recherche":
				int val1 = 55;
				int[] tab1 = {1, 2, 3, 4, 5};

				int resultat1 = rechercheListeTriee(val1, tab1);

				System.out.println(resultat1);

				int val2 = 5;
				int[] tab2 = {1, 2, 3, 4, 5};

				int resultat2 = rechercheListeTriee(val2, tab2);

				System.out.println(resultat2);

				int val3 = 9;
				int[] tab3 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

				int resultat3 = recherche(val3, tab3);

				System.out.println(resultat3);

				int val4 = 5;
				int[] tab4 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

				int resultat4 = recherche(val4, tab4);

				System.out.println(resultat4);
			break;

			default:
				System.out.println("Cette fonction n'existe pas.");
			break;
		}

		System.out.println(" ");
	}

	public static void regle_graduee() {
		System.out.println("Longueur ?");
		int longueur = demanderValeur();

		System.out.println("Intervalle ?");
		int intervalle = demanderValeur();

		int k = 0;

		for (int i = 0; i < longueur; i++) {
			if (k == 0) {
				System.out.print("|");	
				k++;
			}

			else if (k == intervalle - 1) {
				k = 0;
				System.out.print("-");
			}

			else{
				System.out.print("-");
				k++;
			}

		}
	}

	public static void puissance() {
		System.out.println("Calcul de a^n");

		System.out.println("a ?");
		int a = demanderValeur();

		System.out.println("n ?");
		int n = demanderValeur();

		int resultat = 1;

		if (n%2 == 0) {
			// n est paire
			a *= a;
			n /= 2;
		}

		for (int i = 1; i <= n; i++) {
			resultat *= a;
		}

		System.out.println("Le résultat est : "+resultat);
	}

	public static int premier() {
		System.out.println("Entrer le nombre à tester");
		int nombre = demanderValeur();

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
			return 1;
		} else {
			System.out.println("Le nombre n'est pas premier");
			return 0;
		}
	}

	public static void tableMultiplication() {
		for (int i = 0; i <= 10; i++) {
			for (int k = 0; k <= 10; k++) {
				System.out.print(i*k);
				System.out.print("\t");
			}
			
			System.out.print("\n");
		}
	}

	public static void demanderTable() {
		System.out.println("Quelle table de multiplication voulez-vous ?");
		int nb = demanderValeur();

		System.out.println("Jusqu'à quelle valeur voulez-vous calculer la table ?");
		int max = demanderValeur();

		int[] table = calculerTable(nb, max);

		for (int val: table) {
			System.out.print(val+", ");
		}
	}

	public static int[] calculerTable(int nb, int max) {
		int[] table = new int[max+1];

		for (int i = 0; i <= max; i++) {
			table[i] = nb*i;
		}
		
		return table;
	}

	public static int recherche(int val, int[] tab) {
		for(int i = 0; i < tab.length; i++) {
			if (tab[i] == val) {
				return i;
			}
		}

		return -1;
	}

	public static int rechercheListeTriee(int val, int[] tab) {
		
		int l = tab.length;
		int longueur = l/2;

		do {


			if (tab[longueur] > val) {
				tab = Arrays.copyOfRange(tab, 0, longueur);
				longueur = tab.length/2;
			} else if (tab[longueur] < val) {
				tab = Arrays.copyOfRange(tab, longueur, l + 1);
				longueur = tab.length/2;
			} else if (tab[longueur] == val) {
				return longueur;
			}
			System.out.println("j'ai : "+longueur);
		} while (longueur > 1);

		return -1;
	}

	public static int demanderValeur() {
		Scanner scan = new Scanner(System.in);

		int valeur = scan.nextInt();

		while(valeur < 0) {
			System.out.println("Erreur : la valeur saisie est négative");
			valeur = scan.nextInt();
		}

		return valeur;
	}
}
