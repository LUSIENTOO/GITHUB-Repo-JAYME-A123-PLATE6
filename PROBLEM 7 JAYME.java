import java.util.Scanner;

public class IncidenceMatrix {
    public static void main(String[] args) {  // main method
        Scanner scanner = new Scanner(System.in);

        // Input number of vertices and edges
        System.out.print("Enter the number of vertices: ");
        int JAYME_A123_vertices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int JAYME_A123_edges = scanner.nextInt();

        // Initialize incidence matrix
        int[][] JAYME_A123_incidenceMatrix = new int[JAYME_A123_vertices][JAYME_A123_edges];

        // Input edge pairs and their occurrence
        System.out.println("Enter vertex pairs and their occurrence:");
        for (int i = 0; i < JAYME_A123_edges; i++) {
            System.out.print("Enter edge " + (i + 1) + " vertex pair (separated by space): ");
            int JAYME_A123_vertex1 = scanner.nextInt();
            int JAYME_A123_vertex2 = scanner.nextInt();
            System.out.print("Enter the number of times edge " + (i + 1) + " appears: ");
            int JAYME_A123_occurrence = scanner.nextInt();

            // Update incidence matrix
            JAYME_A123_incidenceMatrix[JAYME_A123_vertex1][i] = JAYME_A123_occurrence;
            JAYME_A123_incidenceMatrix[JAYME_A123_vertex2][i] = JAYME_A123_occurrence;
        }

        // Print incidence matrix
        System.out.println("\nIncidence Matrix:");
        for (int i = 0; i < JAYME_A123_vertices; i++) {
            for (int j = 0; j < JAYME_A123_edges; j++) {
                System.out.print(JAYME_A123_incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
