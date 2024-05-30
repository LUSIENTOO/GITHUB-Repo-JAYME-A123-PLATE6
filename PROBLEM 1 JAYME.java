import java.util.*;

public class GraphConnectivity {

    // Adjacency list representing the graph, where each key is a node and the value is a list of adjacent nodes.
    private static Map<Character, List<Character>> Jayme_A123_adjList = new HashMap<>();
    // Set to keep track of visited nodes during DFS traversal.
    private static Set<Character> Jayme_A123_visited = new HashSet<>();
    // List to store the connected components of the graph.
    private static List<List<Character>> Jayme_A123_components = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner object to read input from the console.
        System.out.println("Enter the number of edges:"); // Prompt user for the number of edges.
        int edges = scanner.nextInt(); // Read the number of edges.
        System.out.println("Enter edges (u v) or '-1' to stop:"); // Prompt user to enter edges.

        // Loop to read edges from input.
        for (int i = 0; i < edges; i++) {
            String input = scanner.next(); // Read the next input token.
            if (input.equals("-1")) { // Break the loop if input is '-1'.
                break;
            }
            char u = input.charAt(0); // Extract the first node.
            char v = scanner.next().charAt(0); // Extract the second node.
            addEdge(u, v); // Add the edge to the adjacency list.
        }

        int connectedComponents = findConnectedComponents(); // Find the connected components of the graph.

        // Sort the components and their nodes.
        Jayme_A123_components.sort(Comparator.comparing(list -> list.get(0))); // Sort components based on their first element.
        for (List<Character> component : Jayme_A123_components) {
            Collections.sort(component); // Sort each component.
        }

        // Print each connected component.
        for (int i = 0; i < Jayme_A123_components.size(); i++) {
            System.out.print("Connected component " + (i + 1) + ": ");
            for (char node : Jayme_A123_components.get(i)) {
                System.out.print(node + " "); // Print each node in the component.
            }
            System.out.println();
        }

        // Print if the graph is connected or not.
        if (connectedComponents == 1) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
        }
        System.out.println("Number of connected components: " + connectedComponents); // Print the number of connected components.
    }

    // Method to add an edge between two nodes in the adjacency list.
    private static void addEdge(char u, char v) {
        Jayme_A123_adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v); // Add v to the adjacency list of u.
        Jayme_A123_adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u); // Add u to the adjacency list of v.
    }

    // Method to find and count the connected components of the graph.
    private static int findConnectedComponents() {
        int count = 0; // Initialize the count of connected components.

        // Iterate over each node in the adjacency list.
        for (Character node : Jayme_A123_adjList.keySet()) {
            if (!Jayme_A123_visited.contains(node)) { // Check if the node has been visited.
                List<Character> component = new ArrayList<>(); // Create a new list to store the current component.
                dfs(node, component); // Perform DFS to find all nodes in the component.
                Jayme_A123_components.add(component); // Add the component to the list of components.
                count++; // Increment the count of connected components.
            }
        }
        return count; // Return the count of connected components.
    }

    // Method to perform an iterative DFS using a stack.
    private static void dfs(char node, List<Character> component) {
        Stack<Character> stack = new Stack<>(); // Create a stack for DFS.
        stack.push(node); // Push the starting node onto the stack.

        // Continue while the stack is not empty.
        while (!stack.isEmpty()) {
            char current = stack.pop(); // Pop the top node from the stack.
            if (!Jayme_A123_visited.contains(current)) { // Check if the node has been visited.
                Jayme_A123_visited.add(current); // Mark the node as visited.
                component.add(current); // Add the node to the current component.
                // Iterate over the neighbors of the current node.
                for (Character neighbor : Jayme_A123_adjList.get(current)) {
                    if (!Jayme_A123_visited.contains(neighbor)) { // Check if the neighbor has been visited.
                        stack.push(neighbor); // Push the unvisited neighbor onto the stack.
                    }
                }
            }
        }
    }
}
