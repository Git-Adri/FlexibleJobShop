import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String args[]) throws FileNotFoundException {

        int bestSolution = Integer.MAX_VALUE;
        //Dessous, veullez donner le "PATH" complet de votre fichier de test.
        Solution solution= new Solution("/home/adrien/Téléchargements/FlexibleJobShop-master-6/Flexible_Job_Shop/Mk01.txt");
        ArrayList<Interval<Integer,Integer,Integer,Integer, Integer>> bestInterval = new ArrayList<>(solution.getIntervals());
        System.out.println("Solution initial: " + solution.getTime());
        solution.print_solution();

        System.out.println("\n\n VOISINAGE");
        for (int i = 0 ; i<200; i++){  //change le <100 pour plus/moins d'iterations de HillClimb
            int res = solution.HillClimb();
            System.out.println( i + " Resultat: " + res );
            if (res < bestSolution){
                System.out.println( "Changement MAOS " );
                bestSolution = res;
                bestInterval = new ArrayList<>(solution.getIntervals());
            }
        }

        System.out.println("\nFinal solution :" + bestSolution);
        solution.setIntervals(bestInterval);
        solution.print_solution();


    }
}
