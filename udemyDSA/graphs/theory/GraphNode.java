package udemyDSA.graphs.theory;

import java.util.ArrayList;

public class GraphNode {
    public String name;
    public int index;
    public boolean isVisited = false;

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }
}

class GraphNodeWithAdjList {
    public String name;
    public int index;

    public ArrayList<GraphNodeWithAdjList> neighbours = new ArrayList<>();

    public GraphNodeWithAdjList(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
