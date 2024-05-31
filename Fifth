import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Fifth {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices in the graph:");
        int vertices = scanner.nextInt();

        System.out.println("Enter the number of edges in the graph:");
        int edges = scanner.nextInt();

        List<List<Integer>> adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        if (isBipartite(adjList, vertices)) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }

        scanner.close();
    }

    private static boolean isBipartite(List<List<Integer>> adjList, int vertices) {
        int[] colors = new int[vertices]; // 0: uncolored, 1: red, -1: blue
        for (int i = 0; i < vertices; i++) {
            colors[i] = 0;
        }

        for (int i = 0; i < vertices; i++) {
            if (colors[i] == 0) {
                if (!bfsCheck(adjList, colors, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean bfsCheck(List<List<Integer>> adjList, int[] colors, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 1; // Start coloring with red

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adjList.get(node)) {
                if (colors[neighbor] == 0) {
                    colors[neighbor] = -colors[node]; // Color with opposite color
                    queue.add(neighbor);
                } else if (colors[neighbor] == colors[node]) {
                    return false; // Found same color in adjacent nodes
                }
            }
        }

        return true;
    }
}
