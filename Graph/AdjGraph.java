package Practice.Graph;

import java.util.LinkedList;
import java.util.List;

public class AdjGraph {
    
    List<Integer> adjacencyArray[];

    public AdjGraph(int vertilesCount) {
        adjacencyArray = new LinkedList[vertilesCount];
        for (int i=0 ; i< vertilesCount ; i++) {
            adjacencyArray[i] = new LinkedList<Integer>();
        }
         
    }

    public void addAdjacency(int i, int j) {
        adjacencyArray[i].add(j);
    }
}
