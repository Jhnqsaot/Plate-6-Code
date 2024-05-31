import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Third {

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
            adjList.get(v).add(u); // Because the graph is undirected
        }

        boolean[] visited = new boolean[vertices];
        boolean hasCycle = false;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adjList, visited)) {
                    hasCycle = true;
                    break;
                }
            }
        }

        if (hasCycle) {
            System.out.println("The graph has a cycle.");
        } else {
            System.out.println("The graph does not have a cycle.");
        }

        scanner.close();
    }

    private static boolean dfs(int vertex, int parent, List<List<Integer>> adjList, boolean[] visited) {
        visited[vertex] = true;

        for (int neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, vertex, adjList, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // Found a back edge, so there's a cycle
            }
        }

        return false;
    }
}
