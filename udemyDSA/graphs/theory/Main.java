package udemyDSA.graphs.theory;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodelist = new ArrayList<>();
        nodelist.add(new GraphNode("A", 0));
        nodelist.add(new GraphNode("B", 1));
        nodelist.add(new GraphNode("c", 2));
        nodelist.add(new GraphNode("D", 3));
        nodelist.add(new GraphNode("E", 4));

        Graph g = new Graph(nodelist);
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(1, 4);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(3, 4);
        System.out.println(g.toString());
    }
}

class Adjacency {
    public static void main(String[] args) {
        ArrayList<GraphNodeWithAdjList> nodelist = new ArrayList<>();
        nodelist.add(new GraphNodeWithAdjList("A", 0));
        nodelist.add(new GraphNodeWithAdjList("B", 1));
        nodelist.add(new GraphNodeWithAdjList("c", 2));
        nodelist.add(new GraphNodeWithAdjList("D", 3));
        nodelist.add(new GraphNodeWithAdjList("E", 4));

        GraphWithAdjList g = new GraphWithAdjList(nodelist);
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(1, 4);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(3, 4);
        System.out.println(g.toString());
    }
}
