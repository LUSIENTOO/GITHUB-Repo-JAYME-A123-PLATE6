import java.util.Scanner;

public class Jayme_A123 {   // This class Jayme_A123 represents a graph using an adjacency matrix.
    private final int[][] adjMatrix;
    private final int numVertices;

    // Initialize the matrix
    public Jayme_A123(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    // Add edge
    public void addEdge(int src, int dst, String type) {
        if (src < 1 || src > numVertices || dst < 1 || dst > numVertices) {
            System.out.println("Invalid vertex index. Please enter values between 1 and " + numVertices);
            return;
        }

        src--; dst--; // Convert to 0-based indexing

        if (type.equalsIgnoreCase("u") && src != dst) {
            // Undirected edge
            adjMatrix[src][dst]++;
            adjMatrix[dst][src]++;
        } else {
            // Directed edge, type == D
            adjMatrix[src][dst]++;
        }
    }

    // Print the matrix
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                s.append(adjMatrix[i][j]).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int size = sc.nextInt();
        Jayme_A123 graph = new Jayme_A123(size);

        System.out.println("Enter vertex pairs");
        System.out.println("- Use {} for undirected and () for directed edges");
        System.out.println("- Input format: {num1,num2} for undirected, (num1,num2) for directed");
        System.out.println("- Type 'end' to stop adding edges");

        sc.nextLine(); // Consume the newline character

        while (true) {
            System.out.print("Enter vertex pair: ");
            String input = sc.nextLine();

            if (input.equals("end")) {
                break;
            }

            if (input.startsWith("{") && input.endsWith("}")) {
                // Undirected edge
                input = input.substring(1, input.length() - 1);
                String[] parts = input.split(",");
                int src = Integer.parseInt(parts[0].trim());
                int dst = Integer.parseInt(parts[1].trim());
                graph.addEdge(src, dst, "u");
            } else if (input.startsWith("(") && input.endsWith(")")) {
                // Directed edge
                input = input.substring(1, input.length() - 1);
                String[] parts = input.split(",");
                int src = Integer.parseInt(parts[0].trim());
                int dst = Integer.parseInt(parts[1].trim());
                graph.addEdge(src, dst, "d");
            } else {
                System.out.println("Invalid format. Please use {} for undirected and () for directed edges.");
            }
        }

        System.out.println("Generated matrix:");
        System.out.print(graph);
        sc.close();
    }
}
