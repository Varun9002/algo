package algo;

import java.util.Arrays;

public class Prims {

    private static int findMin(boolean[] visited, int[] dist) {
        int minDist = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < minDist) {
                minDist = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void prims(int[][] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        int[] dist = new int[V];

        Arrays.fill(visited, false);
        Arrays.fill(dist, Integer.MAX_VALUE);

        int[] parent = new int[V];
        dist[0] = 0;
        for (int count = 0; count < V - 1; count++) {
            int minIndex = findMin(visited, dist);
            visited[minIndex] = true;

            for (int i = 0; i < V; i++) {
                if (graph[minIndex][i] != 0 && !visited[i] && dist[i] > graph[minIndex][i]) {
                    dist[i] = graph[minIndex][i];
                    parent[i] = minIndex;
                }
            }
        }

        for (int i = 1; i < parent.length; i++) {
            System.out.println(
                    "(" + (char) (parent[i] + 'A' - 1) + ")---" + dist[i] + "---(" + (char) (i + 'A' - 1) + ")");
        }
    }

    public static void main(String[] args) {
        int graph[][] = { { 0, 3, 5, 7, 0, 0, 0, 0, 0 }, // s
                { 3, 0, 2, 0, 7, 0, 12, 0, 0 }, // a
                { 5, 2, 0, 5, 9, 8, 0, 0, 0 }, // b
                { 7, 0, 5, 0, 0, 6, 0, 0, 0 }, // c
                { 0, 7, 9, 0, 0, 0, 0, 8, 0 }, // d
                { 0, 0, 8, 6, 0, 0, 0, 0, 10 }, // e
                { 0, 0, 12, 0, 0, 0, 0, 15, 0 }, // f
                { 0, 7, 9, 0, 0, 0, 15, 0, 5 }, // g
                { 0, 7, 9, 0, 0, 10, 0, 5, 0 } }; // h
        prims(graph);
    }
}
