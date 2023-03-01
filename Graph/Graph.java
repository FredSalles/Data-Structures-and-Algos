package Practice.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    public static void main(String[] args) {

        AdjGraph graph = new AdjGraph(5);

        graph.addAdjacency(0, 1);
        graph.addAdjacency(0, 2);

        graph.addAdjacency(1, 0);
        graph.addAdjacency(1, 2);
        graph.addAdjacency(1, 4);

        graph.addAdjacency(2, 0);
        graph.addAdjacency(2, 1);
        graph.addAdjacency(2, 3);

        graph.addAdjacency(3, 1);
        graph.addAdjacency(4, 2);

        System.out.print("\nBFSTraversal -> ");
        BFSTraversal(graph, 5);
        System.out.print("\nDFSTraversal -> ");
        DFSTraversal(graph, 5);

    }

    //
    // BFS
    //
    // queue for nodes to visit
    // visited boolean to not repeat visit
    //
    private static void BFSTraversal(AdjGraph graph, int count) {

        boolean visited[] = new boolean[count];
        BFSTraversal(graph, visited, 0);
    }

    private static void BFSTraversal(AdjGraph graph, boolean[] visited, int pos) {

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(pos);

        while (!queue.isEmpty()) {

            int vertex = queue.poll();
            if (!visited[vertex]) {
                System.out.print(vertex + " ");
                visited[vertex] = true;
            }
            for (Integer connection : graph.adjacencyArray[vertex]) {
                if (!visited[connection]) {
                    queue.add(connection);
                }
            }
        }
    }

    private static void DFSTraversal(AdjGraph graph, int count) {
        boolean visited[] = new boolean[count];
        DFSTraversal(graph, visited, 0);
    }

    private static void DFSTraversal(AdjGraph graph, boolean[] visited, int pos) {

        visited[pos] = true;
        System.out.print(pos + " ");

        for (Integer connection : graph.adjacencyArray[pos]) {
            if (!visited[connection]) {
                DFSTraversal(graph, visited, connection);
            }
        }

    }

}
