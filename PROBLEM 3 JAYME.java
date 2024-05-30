import java.util.*;

class Jayme_A123 {
    private int V; // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency List

    Jayme_A123(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v - 1].add(w - 1); // Adjust indexing to start from 0
        adj[w - 1].add(v - 1); // If the graph is undirected, add this line
    }

    // A recursive function that uses visited[] and parent to detect cycle in subgraph reachable from vertex v.
    boolean isCyclicUtil(int v, boolean visited[], int parent) {
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();

            // If an adjacent is not visited, then recur for that adjacent
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v))
                    return true;
            }

            // If an adjacent is visited and not parent of current vertex, then there is a cycle
            else if (i != parent)
                return true;
        }
        return false;
    }

    // Returns true if the graph contains a cycle, else false.
    boolean isCyclic() {
        // Mark all the vertices as not visited and not part of recursion stack
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);

        // Call the recursive helper function to detect cycle in different DFS trees
        for (int u = 0; u < V; u++)
            if (!visited[u]) // Don't recur for u if already visited
                if (isCyclicUtil(u, visited, -1))
                    return true;

        return false;
    }
}
