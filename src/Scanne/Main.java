package Scanne;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;
public class Main {

  public static void main(String[] args) {
    Path chemin = Paths.get("C:\\Users\\Arthur\\Desktop");
    String filtre = "*.pdf";
    FolderScanner fs = new FolderScanner(chemin, filtre);
    
    //Nous r�cup�rons le nombre de processeurs disponibles
    int processeurs = Runtime.getRuntime().availableProcessors();
    
    //Nous cr�ons notre pool de thread pour nos t�ches de fond
    ForkJoinPool pool = new ForkJoinPool(processeurs);
    Long start = System.currentTimeMillis();     
    //Nous lan�ons le traitement de notre t�che principale via le pool
    pool.invoke(fs);
    Long end = System.currentTimeMillis();
        
    System.out.println("Il y a " + fs.getResultat() + " fichier(s) portant l'extension " + filtre);
    System.out.println("Temps de traitement : " + (end - start));     
  }
}