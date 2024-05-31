import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Second {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of vertices in the graph
        System.out.println("Enter the number of vertices in the graph: ");
        int vertices = scanner.nextInt();

        // Initialize the adjacency matrix
        int[][] adjacencyMatrix = new int[vertices][vertices];

        // Read the adjacency matrix
        System.out.println("Enter the adjacency matrix: ");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        // Map to store the edge and its count
        Map<String, Integer> edgeCount = new HashMap<>();

        // Traverse the adjacency matrix and count the edges
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    String edge = i + "-" + j;
                    edgeCount.put(edge, edgeCount.getOrDefault(edge, 0) + adjacencyMatrix[i][j]);
                }
            }
        }

        // Print the edges and their counts
        System.out.println("Edges and their counts: ");
        for (Map.Entry<String, Integer> entry : edgeCount.entrySet()) {
            System.out.println("Edge: " + entry.getKey() + ", Count: " + entry.getValue());
        }

        scanner.close();
    }
}
