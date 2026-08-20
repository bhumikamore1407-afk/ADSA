import java.util.Scanner;

public class BFSTraversal {

    static final int MAX = 100;

    static int[] queue = new int[MAX];
    static int front = -1;
    static int rear = -1;
    static int[] visited = new int[MAX];

    // ENQUEUE function
    static void enqueue(int vertex) {
        if (rear == MAX - 1) {
            return; // Queue full
        }

        if (front == -1) {
            front = 0;
        }

        rear = rear + 1;
        queue[rear] = vertex;
    }

    // DEQUEUE function
    static int dequeue() {
        if (front == -1) {
            return -1; // Queue empty
        }

        int vertex = queue[front];

        if (front >= rear) {
            front = -1;
            rear = -1;
        } else {
            front = front + 1;
        }

        return vertex;
    }

    // BFS function
    static void BFS(int[][] graph, int startVertex, int vertices) {

        // Initialize visited array
        for (int i = 0; i < vertices; i++) {
            visited[i] = 0;
        }

        // Enqueue starting vertex
        enqueue(startVertex);
        visited[startVertex] = 1;

        System.out.print("BFS Traversal: ");

        // Process queue
        while (front != -1) {

            int currentVertex = dequeue();

            System.out.print(currentVertex + " ");

            // Check all adjacent vertices
            for (int i = 0; i < vertices; i++) {

                if (graph[currentVertex][i] == 1 && visited[i] == 0) {
                    enqueue(i);
                    visited[i] = 1;
                }
            }
        }
    }

    // MAIN function
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int vertices;
        int[][] graph = new int[MAX][MAX];

        // Input number of vertices
        System.out.print("Enter number of vertices: ");
        vertices = sc.nextInt();

        // Input adjacency matrix
        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        // Input starting vertex
        System.out.print("Enter starting vertex: ");
        int startVertex = sc.nextInt();

        // Call BFS
        BFS(graph, startVertex, vertices);

        sc.close();
    }
}