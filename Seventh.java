import java.util.*;

public class Seventh {
    private int[][] incidenceMatrix;
    private int numVertices;
    private int numEdges;

    public Seventh(int numVertices, int numEdges) {
        this.numVertices = numVertices;
        this.numEdges = numEdges;
        incidenceMatrix = new int[numVertices][numEdges];
    }

    public void addEdge(int edgeIndex, int vertex1, int vertex2, int count) {
        incidenceMatrix[vertex1][edgeIndex] += count;
        incidenceMatrix[vertex2][edgeIndex] += count;
    }

    public void printIncidenceMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numEdges; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int numVertices = scanner.nextInt();
        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();

        Seventh graph = new Seventh(numVertices, numEdges);

        System.out.println("Enter the edges in the format 'vertex1 vertex2 count':");
        for (int i = 0; i < numEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            int count = scanner.nextInt();
            graph.addEdge(i, vertex1, vertex2, count);
        }

        System.out.println("Incidence Matrix:");
        graph.printIncidenceMatrix();
    }
}
