import java.io.IOException;
import java.util.Scanner;

public class TP8 {

  static int nLetterKeycode = 78;
  static int sLetterKeycode = 83;

  static boolean [][] defaultGrid = {
    {false, false, true, false},
    {true,  true,  true, false},
    {false, true, false, false}
  };

  public static void main(String [] args) throws IOException {
    if(args.length > 0 && args[0].equals("console")) {
        handleConsole();
    } else {
      handle2D();
    }
  }

  /**
   * Permet de gérer l'affichage en 2D du jeu
   */
  private static void handle2D() {
    boolean[][] grille = defaultGrid;

    boolean[][] savedGrille = Jeu.read("save.txt");

    if(savedGrille != null) {
      grille = savedGrille;
      System.out.println("Grille lue depuis le fichier de sauvegarde");
    }

    while(true) {
      if (StdDraw.hasNextKeyTyped()) {
        if(StdDraw.isKeyPressed(nLetterKeycode)) {
          // Appui sur la touche n
          // Permet de passer à l'étape suivante du jeu
          grille = Jeu.step(grille);
        }

        if(StdDraw.isKeyPressed(sLetterKeycode)) {
          // Appui sur la touche s
          // Permet de sauvegarder l'état actuel du jeu
          Jeu.save(grille, "save.txt");
        }
      }

      StdDraw.clear();
      Jeu.affiche2D(grille);
      StdDraw.show(1000/Jeu.FPS);
    }
  }

  /**
   * Permet de gérer l'affichage en mode console du jeu
   */
  public static void handleConsole() {
    boolean[][] grille = defaultGrid;

    String ch = "a";
    Scanner scan = new Scanner(System.in);

    while(!ch.equals("q")) { // On quitte en appuyant sur "q" puis entrer
      Jeu.afficheConsole(grille);
      ch = scan.nextLine();
      grille = Jeu.step(grille);
    }

    scan.close();
  }
}
