import java.util.*;

/*
 * https://leetcode.com/problems/clone-graph/
 * Given a reference of a node in a connected undirected graph.
Return a deep copy (clone) of the graph.
Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors
 */
public class deepCloneOfGraph {
    public static void main(String[] args) {
        int[][] adjList = { { 2, 4 }, { 1, 3 }, { 2, 4 }, { 1, 3 } };
        System.out.println("Deep copy of the undirected graph : ");
        // + deepCopy(adjList));

    }

    private static Node deepCopy(Node node) {
        if (node == null) {
            return null;
        }

        Node graph = new Node(node.val);
        HashMap<Node, Node> mp = new HashMap<>();
        mp.put(node, graph);

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node valNode : curr.neighbors) {
                if (!mp.containsKey(valNode)) {
                    mp.put(valNode, new Node(valNode.val));
                    queue.add(valNode);
                }
                mp.get(curr).neighbors.add(mp.get(valNode));
            }
        }
        return graph;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
