package udemyDSA.graphs.theory;

import java.util.ArrayList;

public class Graph {
    ArrayList<GraphNode> nodeList = new ArrayList<>();
    int[][] adjacentMatrix;

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        adjacentMatrix = new int[nodeList.size()][nodeList.size() ]
    }

    public void addUndirectedEdge(int i, int j) {
        adjacentMatrix[i][j] = 1;
        adjacentMatrix[j][i] = 1;

    }

}
