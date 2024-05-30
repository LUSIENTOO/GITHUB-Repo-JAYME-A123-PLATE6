import java.util.*;

public class Jayme_A123 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read in the number of edges
        System.out.print("Enter number of edges: ");
        int numEdges = sc.nextInt();

        // Create a set to store the vertices
        Set<Integer> Jayme_A123_vertices = new HashSet<>();

        // Create an adjacency list to store the edges
        Map<Integer, List<Integer>> Jayme_A123_adjList = new HashMap<>();

        // Read in the edges and add them to the adjacency list and vertices set
        System.out.println("Enter vertex pairs: ");
        for (int i = 0; i < numEdges; i++) {
            System.out.print("Vertex pair: ");
            int u = sc.nextInt();
            int v = sc.nextInt();
            Jayme_A123_vertices.add(u);
            Jayme_A123_vertices.add(v);

            if (!Jayme_A123_adjList.containsKey(u)) {
                Jayme_A123_adjList.put(u, new ArrayList<>());
            }
            if (!Jayme_A123_adjList.containsKey(v)) {
                Jayme_A123_adjList.put(v, new ArrayList<>());
            }

            Jayme_A123_adjList.get(u).add(v);
            Jayme_A123_adjList.get(v).add(u);
        }

        // Calculate the degree of each vertex and output it
        for (int vertex : Jayme_A123_vertices) {
            int degree = Jayme_A123_adjList.get(vertex).size();
            System.out.printf("Vertex %d has a degree of %d\n", vertex, degree);
        }
    }
}
