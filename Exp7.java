// Prim's Algorithm - Minimum Spanning Tree

import java.util.*;

public class PrimMST {

    static int V = 5;

    // Find the vertex with minimum key value
    static int minKey(int key[], boolean mstSet[]) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // Implement Prim's Algorithm
    static void primMST(int graph[][]) {

        int parent[] = new int[V];
        int key[] = new int[V];
        boolean mstSet[] = new boolean[V];

        // Initialize keys and MST set
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Start from vertex 0
        key[0] = 0;
        parent[0] = -1;

        // Find MST
        for (int count = 0; count < V - 1; count++) {

            int u = minKey(key, mstSet);

            mstSet[u] = true;

            // Update adjacent vertices
            for (int v = 0; v < V; v++) {

                if (graph[u][v] != 0 &&
                    !mstSet[v] &&
                    graph[u][v] < key[v]) {

                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print MST
        System.out.println("Edge\tWeight");

        for (int i = 1; i < V; i++) {
            System.out.println(
                parent[i] + " - " + i + "\t" + graph[i][parent[i]]
            );
        }
    }

    public static void main(String args[]) {

        int graph[][] = {
            {0, 5, 0, 6, 0},
            {8, 0, 3, 0, 7},
            {0, 3, 0, 1, 4},
            {6, 8, 0, 0, 9},
            {0, 3, 0, 7, 0},
   
        };

        primMST(graph);
    }
}
