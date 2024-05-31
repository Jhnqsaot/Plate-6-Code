import java.util.*;

public class Eighth {
    private int[][] adjacencyMatrix1;
    private int[][] adjacencyMatrix2;
    private int numVertices;

    public Eighth(int numVertices, int[][] adjacencyMatrix1, int[][] adjacencyMatrix2) {
        this.numVertices = numVertices;
        this.adjacencyMatrix1 = adjacencyMatrix1;
        this.adjacencyMatrix2 = adjacencyMatrix2;
    }

    public boolean areIsomorphic() {
        int[] mapping = new int[numVertices];
        boolean[] used = new boolean[numVertices];
        Arrays.fill(mapping, -1);
        return checkIsomorphism(mapping, used, 0);
    }

    private boolean checkIsomorphism(int[] mapping, boolean[] used, int vertex) {
        if (vertex == numVertices) {
            return isMappingValid(mapping);
        }

        for (int i = 0; i < numVertices; i++) {
            if (!used[i]) {
                mapping[vertex] = i;
                used[i] = true;
                if (checkIsomorphism(mapping, used, vertex + 1)) {
                    return true;
                }
                used[i] = false;
                mapping[vertex] = -1;
            }
        }
        return false;
    }

    private boolean isMappingValid(int[] mapping) {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (adjacencyMatrix1[i][j] != adjacencyMatrix2[mapping[i]][mapping[j]]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int numVertices = scanner.nextInt();

        int[][] adjacencyMatrix1 = new int[numVertices][numVertices];
        int[][] adjacencyMatrix2 = new int[numVertices][numVertices];

        System.out.println("Enter the adjacency matrix for the first graph:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjacencyMatrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the adjacency matrix for the second graph:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjacencyMatrix2[i][j] = scanner.nextInt();
            }
        }

        Eighth graphIsomorphism = new Eighth(numVertices, adjacencyMatrix1, adjacencyMatrix2);

        if (graphIsomorphism.areIsomorphic()) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }
    }
}
