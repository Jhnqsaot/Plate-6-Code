import java.util.*;

public class First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt();

        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt();

        List<List<Integer>> adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        System.out.println("Input the edges (u v):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[vertices];
        int connectedComponents = 0;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, adjList, visited);
                connectedComponents++;
            }
        }

        if (connectedComponents == 1) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + connectedComponents);
        }

        scanner.close();
    }

    private static void dfs(int vertex, List<List<Integer>> adjList, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex);
        visited[vertex] = true;

        while (!stack.isEmpty()) {
            int v = stack.pop();
            for (int neighbor : adjList.get(v)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
    }
}
