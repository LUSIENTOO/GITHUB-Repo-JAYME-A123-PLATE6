import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdjacencyMatrixGraph {

    public static void main(String[] args) {
        Scanner Jayme_A123_scanner = new Scanner(System.in);

        // Read the number of vertices
        System.out.println("Enter the number of vertices:");
        int Jayme_A123_n = Jayme_A123_scanner.nextInt();

        // Initialize the adjacency matrix
        int[][] Jayme_A123_adjMatrix = new int[Jayme_A123_n][Jayme_A123_n];

        // Read the adjacency matrix
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < Jayme_A123_n; i++) {
            for (int j = 0; j < Jayme_A123_n; j++) {
                Jayme_A123_adjMatrix[i][j] = Jayme_A123_scanner.nextInt();
            }
        }

        // Map to store edges and their counts
        Map<String, Integer> Jayme_A123_edgeCountMap = new HashMap<>();

        // Process the adjacency matrix to list edges and count their occurrences
        for (int i = 0; i < Jayme_A123_n; i++) {
            for (int j = i; j < Jayme_A123_n; j++) {
                if (Jayme_A123_adjMatrix[i][j] > 0) {
                    String Jayme_A123_edge = "(" + i + ", " + j + ")";
                    Jayme_A123_edgeCountMap.put(Jayme_A123_edge, Jayme_A123_adjMatrix[i][j]);
                }
            }
        }

        // Print the edges and their counts
        System.out.println("Edges and their counts:");
        for (Map.Entry<String, Integer> entry : Jayme_A123_edgeCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
        }
    }
}
