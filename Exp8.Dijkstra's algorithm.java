import java.util.*;

public class Dijkstra {

    static final int INF = 9999;

    public static void dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, INF);
        dist[source] = 0;

        for (int count = 0; count < n - 1; count++) {

            // Find vertex with minimum distance
            int u = -1;
            int min = INF;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && dist[i] < min) {
                    min = dist[i];
                    u = i;
                }
            }

            visited[u] = true;

            // Update distances of adjacent vertices
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0
                        && dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Display shortest distances
        System.out.println("Shortest distances from A:");

        for (int i = 0; i < n; i++) {
            System.out.println("A -> " + (char)('A' + i)
                    + " = " + dist[i]);
        }
    }

    public static void main(String[] args) {

        // Graph:
        // A-B = 1
        // A-C = 5
        // B-C = 2
        // B-D = 4
        // C-D = 1

        int[][] graph = {
            {0, 1, 5, 0},
            {1, 0, 2, 4},
            {5, 2, 0, 1},
            {0, 4, 1, 0}
        };

        // A is the source vertex (index 0)
        dijkstra(graph, 0);
    }
}