package leetCode;

import java.util.*;

class minimumDistanceGraphs {

    public static int minScore(int n, int[][] roads) {
        int m = roads.length;
        Queue<Pair> que = new ArrayDeque<>();
        int min = Integer.MAX_VALUE;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        que.add(new Pair(1, Integer.MAX_VALUE));
        int[] visited = new int[n + 1];

        while (que.size() > 0) {
            int dest = que.peek().dest;
            int cost = que.peek().cost;
            que.remove();
            min = Math.min(min, cost);
            if (visited[dest] == 0) {
                for (int i = 0; i < adj.get(dest).size(); i++) {
                    int a = adj.get(dest).get(i).dest;
                    int b = adj.get(dest).get(i).cost;
                    que.add(new Pair(a, b));
                }
            }
            visited[dest] = 1;
        }
        return min;
    }

    public static void main(String[] args) {
        int roads[][] = { { 1, 2, 2 }, { 1, 3, 4 }, { 3, 4, 7 } }, n = 4;
        System.out.println("Minimum cost path : " + minScore(n, roads));

    }

}

class Pair {
    int dest;
    int cost;

    Pair(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }
}