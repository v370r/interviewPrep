package udemyDSA.graphs.theory;

import java.util.ArrayList;

public class Graph {
    ArrayList<GraphNode> nodeList = new ArrayList<>();
    int[][] adjacentMatrix;

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        adjacentMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int i, int j) {
        adjacentMatrix[i][j] = 1;
        adjacentMatrix[j][i] = 1;

    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + " ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j : adjacentMatrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

}

class GraphWithAdjList {
    ArrayList<GraphNodeWithAdjList> nodeList = new ArrayList<>();

    public GraphWithAdjList(ArrayList<GraphNodeWithAdjList> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNodeWithAdjList first = nodeList.get(i);
        GraphNodeWithAdjList second = nodeList.get(j);
        first.neighbours.add(second);
        second.neighbours.add(first);

    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j = 0; j < nodeList.get(i).neighbours.size(); j++) {
                if (j == nodeList.get(i).neighbours.size() - 1) {
                    s.append((nodeList.get(i).neighbours.get(j).name));
                } else {
                    s.append((nodeList.get(i).neighbours.get(j).name) + " -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }
}
