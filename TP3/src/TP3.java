import java.util.Scanner;
import java.util.Arrays;

public class TP3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Quelle fonction voulez-vous exécuter ? Tapez help pour connaitre la liste des fonctions.");
		
		String fonction = scan.next();

		switch (fonction) {
			case "help":
				System.out.println("Liste des fonctions disponibles : tableauuneligne, tableautroislignes, moyenne, partition, triage, rechercheDicho, rechercheExhaustive");
			break;

			case "tableauuneligne":
				int [] tab = demanderTableau(4);
				
				for (int i = 0; i < tab.length; i++) {
					System.out.print(tab[i]);		
				}
			break;
			
			case "tableautroislignes":
				int [][] tab2 = new int[3][4];
				
				for (int k = 0; k < 3; k++) {
					tab2[k] = demanderTableau(4);
				}
				
				for (int j = 0; j < tab2.length; j++) {
					for (int l = 0; l < tab2[j].length; l++) {
						if(l == tab2[j].length - 1){
							System.out.println(tab2[j][l]);
						}
						else{
							System.out.print(tab2[j][l]+"\t");
						}
					}
						
				}
			break;
			
			case "moyenne":
				System.out.println("Indiquez la taille du tableau");
				int valeur = demanderValeur();
				System.out.println("Indiquez les valeur du tableau");
				int [] tab3 = demanderTableau(valeur);
				
				int moyenne = moyenneTab(tab3);
				
				System.out.println("La moyenne est égale à : "+moyenne);
				
				boolean estPresent = false;
				for(int r = 0; r<tab3.length; r++){
					if (moyenne == tab3[r]) {
						System.out.println("indice moyenne : "+r);
						estPresent = true;
						break;
					}
					
				}
				if(!estPresent){
					System.out.println("Aucune valeur n'est égale à la moyenne");
				}
			break;
			
			case "partition":
				System.out.println("Indiquez la taille du tableau");

				int valeur2 = demanderValeur();
				
				System.out.println("Indiquez les valeur du tableau");

				int [] tab4 = demanderTableau(valeur2);
				partitionTab(tab4);
			break;
			
			case "triage":
				System.out.println("Indiquez la taille du tableau");

				int valeur3 = demanderValeur();
				
				System.out.println("Indiquez les valeur du tableau");

				int[] tab5 = demanderTableau(valeur3);
				triageTab(tab5);
			break;	
			
			case "rechercheDicho":
				System.out.println("Indiquez la taille du tableau");

				int valeur4 = demanderValeur();
				
				System.out.println("Indiquez les valeur du tableau");

				int[] tab6 = demanderTableau(valeur4);
				
				System.out.println("Entrez la valeur à rechercher dans le tableau");

				int achercher = demanderValeur();
				
				int aretourner = rechercheDicho(tab6,achercher);
				
				System.out.println("J'ai trouvé la valeur à la position : "+aretourner);
				
			break;
			
			case "rechercheExhaustive":
				System.out.println("Indiquez la taille du tableau");

				int valeur5 = demanderValeur();
				
				System.out.println("Indiquez les valeur du tableau");

				int[] tab7 = demanderTableau(valeur5);
				
				System.out.println("Entrez la valeur à rechercher dans le tableau");

				int achercher2 = demanderValeur();
				
				int aretourner2 = rechercheExhaustive(tab7,achercher2);
				
				System.out.println("J'ai trouvé la valeur à la position : "+aretourner2);
				
			break;
			
			default:
				System.out.println("Cette fonction n'existe pas.");
			break;
		}
	}
	
	public static int[] demanderTableau(int taille) {
		int [] tab = new int[taille];
		
		for(int x = 0; x<taille; x++){
			int valeur = demanderValeur();
			
			tab[x] = valeur;
		}
		
		return tab;
	}
		
	public static int demanderValeur(){
		System.out.println("Saisir une valeur");
		
		Scanner scan = new Scanner(System.in); 
		
		int value = scan.nextInt();
		
		return value;
	}
	
	public static int moyenneTab(int [] tab) {
		int somme = 0;
		
		for (int i = 0; i < tab.length; i++) {
			somme += tab[i];
		}
		
		int moyenne = somme/tab.length;
		
		return moyenne;
	}
	
	public static int[][] partitionTab(int [] tab) {
		int moyenne = moyenneTab(tab);
		int nombreinf = nombreinfTab(tab);
		int [] premieremoitie = new int [nombreinf];
		int [] deuxiememoitie = new int [((tab.length)-nombreinf)];
		
		int compteurinf = 0;
		int compteursup = 0;
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] < moyenne) {
				premieremoitie[compteurinf] = tab[i];
				compteurinf += 1;
			}
			else{
				deuxiememoitie[compteursup] = tab[i];
				compteursup += 1;
			}
		}
		
		for(int t=0; t<premieremoitie.length;t++){
			System.out.println(premieremoitie[t]);
		}
		for(int t=0; t<deuxiememoitie.length;t++){
			System.out.println(deuxiememoitie[t]);
		}
		
		int [][] returnval = {premieremoitie,deuxiememoitie};
		
		return returnval;
	}
	
	public static int nombreinfTab(int [] tab){
		int moyenne = moyenneTab(tab);
		int nombreinf = 0;
		for(int i=0; i<tab.length;i++){
			if(tab[i] < moyenne){
				nombreinf += 1;
			}
		} 
		return nombreinf;
	}
	
	public static void triageTab(int [] tab) {
		for(int i = 0; i < tab.length; i++){
			int pluspetit = tab[i];
			int placepetit = i;
			for(int j = i; j < tab.length; j++){
					if(tab[j] < pluspetit){
						pluspetit = tab[j];
						placepetit = j;
					}
			}
			int stockage = tab[i];
			tab[i] = tab[placepetit];
			tab[placepetit] = stockage;
		}
		for(int t=0; t<tab.length;t++){
			System.out.println(tab[t]);
		}
	}
	
	public static int rechercheDicho(int[] tab, int val){
		
		int l = tab.length;
		int longueur = l/2;

		do {
			if (tab[longueur] > val) {
				longueur = longueur/2;
			} else if (tab[longueur] < val) {
				longueur = 3*longueur/2;
			} else if (tab[longueur] == val) {
				return longueur;
			}
		} while ((longueur >= 1) && (longueur <= tab.length));

		return -1;
	}
	
	public static int rechercheExhaustive(int[] tab, int val) {
		for(int i = 0; i < tab.length; i++) {
			if (tab[i] == val) {
				return i;
			}
		}

		return -1;
	}
}
