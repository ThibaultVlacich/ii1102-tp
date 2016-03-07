import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TP5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Quelle fonction voulez-vous exécuter ? Tapez help pour connaitre la liste des fonctions.");
		
		String fonction = scan.next();

		switch (fonction) {
			case "help":
				System.out.println("Liste des fonctions disponibles : palindrome_1, palindrome_boolean_2, palindrome_3, premiers, FIFO, erathostheneR");
			break;
			
			case "palindrome_1":
				System.out.println("Entrez la phrase à tester :");
				String phrase = new String(scan.next());
				palindrome(phrase);
			break;
			
			case "palindrome_boolean_2":
				System.out.println("Entrez la phrase à tester :");
				String phrase2 = new String(scan.next());
				System.out.println(isPalindrome(phrase2));
			break;
			
			case "palindrome_3":
				System.out.println("Entrez la phrase à tester :");
				String phrase3 = new String(scan.next());
				if(isPalindrome(phrase3))
					System.out.println("La phrase est bien un palindrome");
				else
					System.out.println("La phrase n'est pas un palindrome");
			break;
			
			case "premiers":
				System.out.println("Entrez n :");
				int n = scan.nextInt();
				premiers(n);
			break;
			
			case "FIFO":
				System.out.println("Voulez-vous créer une liste ? Y/N ");
				String command = scan.next(); 

				if(command.equalsIgnoreCase("Y")) {
					definirFile();
				}
				else{
					System.out.println("Dommage");
				}
			break;
			
			case "erasthotheneR" : 
				System.out.println("Choisir la longueur du tableau : ");
				int n2 = scan.nextInt();
				int tableau[] = new int[n2];
				for(int i = 0; i < n2; i++){
					tableau[i] = i;
				}
				erasthotheneR(tableau);
			break;
			
			default:
				System.out.println("Cette fonction n'existe pas.");
			break;
		}
		
	}
	
	public static void palindrome(String phrase){
		String inverse = "";
		int longueur = phrase.length();
		for(int i = longueur - 1; i >= 0; i--)
			inverse = inverse + phrase.charAt(i);
		if(phrase.equals(inverse))
			System.out.println("La phrase est bien un palindrome");
		else
			System.out.println("La phrase n'est pas un palindrome");
	}
	
	public static boolean isPalindrome(String phrase){
		if(phrase.length() <= 1)
			return true;
		else {
			if(phrase.charAt(0) == phrase.charAt(phrase.length() - 1))
				return isPalindrome(phrase.substring(1, phrase.length() - 1));
			else{
				return false;
			}	
		}
	}	
	
	public static void erathosthene(int[] tableau){
		for(int i = 0; i <= tableau.length - 1; i++){
			if(tableau[i] <= 1){
				tableau[i] = 0;
			}
			else{
				if(tableau[i] > 1){
					int k = 2;
					while(k*i < tableau.length){
						tableau[k*i] = 0;
						k++;
					}
				}
			}
		}	
	}
		
	public static void premiers(int n){
		int tableau[] = new int[n];
		for(int i = 0; i <= n - 1; i++){
			tableau[i] = i;
		}
		erathosthene(tableau);
		tableau = suppression(tableau);
		System.out.println("Voici le tableau des nombres premiers jusqu'à " + n + " : ");
		for(int i = 0; i <= tableau.length - 1; i++){ 
			System.out.print(tableau[i] + ", "); 
		}
	}
	
	public static void erasthotheneR(int[] tableau){
		int taille = tableau.length;
		for(int i = 0; i < tableau.length; i++){
			tableau[i] = i;
		}
		tableau[1] = 0;
		erasthotheneR(tableau, 0);
		tableau = suppression(tableau);
		System.out.println("Voici le tableau des nombres premiers jusqu'à " + taille + " : ");
		for(int i = 0; i <= tableau.length - 1; i++){ 
			System.out.print(tableau[i] + ", "); 
		}
	}
	
	public static void erasthotheneR(int[] tab, int i){
		if(tab[i] != 0){
			for(int k = i*i; k < tab.length; k+=i){
				tab[k] = 0;
			}
		}
		if(i != tab.length - 1) erasthotheneR(tab, i+1);
	}
	
	public static int[] suppression(int[] tableau){
		int compteur = 0;
		for(int i = 0; i <= tableau.length - 1; i++){
			if(tableau[i] != 0){
				compteur = compteur + 1;
			}
		}
		int nouveau_tab[] = new int[compteur];
		int k = 0;
		for(int i = 0; i <= tableau.length - 1; i++){
			if(tableau[i] != 0){
				nouveau_tab[k] = tableau[i];
				k = k + 1;
			}
		}
		tableau = nouveau_tab;
		return tableau;
	}
	
	public static void definirFile(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Définissez la longueur de la liste : ");
		int longueur = scan.nextInt();
		int file[] = new int[longueur];
		for(int i = 0; i < longueur; i++){
			System.out.println("Entrez la valeur numéro " + (i+1) +  " de la file : ");
			file[i] = scan.nextInt();
		}
	}
	
	public void add(int n){
	}
}
