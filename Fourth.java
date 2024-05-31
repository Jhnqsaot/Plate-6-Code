import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fourth {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices in the graph:");
        int vertices = scanner.nextInt();

        System.out.println("Enter the number of edges in the graph:");
        int edges = scanner.nextInt();

        Map<Integer, Integer> degreeMap = new HashMap<>();

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            // Increment the degree for both vertices u and v
            degreeMap.put(u, degreeMap.getOrDefault(u, 0) + 1);
            degreeMap.put(v, degreeMap.getOrDefault(v, 0) + 1);
        }

        System.out.println("Degrees of vertices:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + ": " + degreeMap.getOrDefault(i, 0));
        }

        scanner.close();
    }
}
