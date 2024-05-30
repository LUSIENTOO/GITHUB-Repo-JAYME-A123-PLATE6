import java.util.*;

public class JAYME_A123 {

    public static boolean areIsomorphic(int[][] JAYME_A123, int[][] JAYME_A1232) {
        int n1 = JAYME_A123.length;
        int n2 = JAYME_A1232.length;

        if (n1 != n2) return false; // Different number of vertices

        int[] mapping = new int[n1];
        Arrays.fill(mapping, -1);

        boolean[] used = new boolean[n1];

        return isomorphicUtil(JAYME_A123, JAYME_A1232, mapping, used, 0);
    }

    private static boolean isomorphicUtil(int[][] JAYME_A123, int[][] JAYME_A1232, int[] mapping, boolean[] used, int v) {
        int n = JAYME_A123.length;
        if (v == n) return true;

        for (int i = 0; i < n; i++) {
            if (!used[i] && isSafe(JAYME_A123, JAYME_A1232, mapping, v, i)) {
                mapping[v] = i;
                used[i] = true;

                if (isomorphicUtil(JAYME_A123, JAYME_A1232, mapping, used, v + 1)) {
                    return true;
                }

                mapping[v] = -1;
                used[i] = false;
            }
        }

        return false;
    }

    private static boolean isSafe(int[][] JAYME_A123, int[][] JAYME_A1232, int[] mapping, int v, int u) {
        for (int i = 0; i < v; i++) {
            if (JAYME_A123[v][i] != JAYME_A1232[u][mapping[i]]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices for both graphs: ");
        int vertices = sc.nextInt();

        System.out.println("Enter adjacency matrix for Graph 1:");
        int[][] JAYME_A123 = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                JAYME_A123[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter adjacency matrix for Graph 2:");
        int[][] JAYME_A1232 = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                JAYME_A1232[i][j] = sc.nextInt();
            }
        }

        if (areIsomorphic(JAYME_A123, JAYME_A1232)) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }

        sc.close();
    }
}
