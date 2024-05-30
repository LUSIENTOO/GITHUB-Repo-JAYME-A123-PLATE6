import java.util.*;

class Bipartite {

    public static int jayme_A123;

    public static boolean isBipartiteUtil(int G[][], int src, int colorArr[]) {
        colorArr[src] = 1;
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(src);

        while (!q.isEmpty()) {
            int u = q.getFirst();
            q.pop();

            if (G[u][u] == 1)
                return false;

            for (int v = 0; v < jayme_A123; ++v) {
                if (G[u][v] == 1 && colorArr[v] == -1) {
                    colorArr[v] = 1 - colorArr[u];
                    q.push(v);
                } else if (G[u][v] == 1 && colorArr[v] == colorArr[u])
                    return false;
            }
        }
        return true;
    }

    public static boolean isBipartite(int G[][]) {
        int colorArr[] = new int[jayme_A123];
        for (int i = 0; i < jayme_A123; ++i)
            colorArr[i] = -1;

        for (int i = 0; i < jayme_A123; i++)
            if (colorArr[i] == -1)
                if (isBipartiteUtil(G, i, colorArr) == false)
                    return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        jayme_A123 = sc.nextInt();

        int G[][] = new int[jayme_A123][jayme_A123];

        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < jayme_A123; i++) {
            for (int j = 0; j < jayme_A123; j++) {
                G[i][j] = sc.nextInt();
            }
        }

        if (isBipartite(G))
            System.out.println("Yes, the graph is Bipartite.");
        else
            System.out.println("No, the graph is not Bipartite.");
    }
}
