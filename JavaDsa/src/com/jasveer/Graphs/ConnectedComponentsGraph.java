package com.jasveer.Graphs;

import java.util.ArrayList;

public class ConnectedComponentsGraph {
    static class Graph {
        static class Edge {
            int src;
            int des;
            int wt;

            public Edge(int src, int des, int wt) {
                this.src = src;
                this.des = des;
                this.wt = wt;
            }
        }
    }

    public static void main(String[] args) {
        int v = 7; // total 7 vertices (0–6)
        ArrayList<Graph.Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        // ---------- Component 1: Has a cycle (0-1-2-0) ----------
        graph[0].add(new Graph.Edge(0, 1, 1));
        graph[1].add(new Graph.Edge(1, 0, 1));

        graph[1].add(new Graph.Edge(1, 2, 1));
        graph[2].add(new Graph.Edge(2, 1, 1));

        graph[2].add(new Graph.Edge(2, 0, 1));
        graph[0].add(new Graph.Edge(0, 2, 1));

        // ---------- Component 2: Just a chain (3-4-5) ----------
        graph[3].add(new Graph.Edge(3, 4, 1));
        graph[4].add(new Graph.Edge(4, 3, 1));

        graph[4].add(new Graph.Edge(4, 5, 1));
        graph[5].add(new Graph.Edge(5, 4, 1));

        // ---------- Component 3: Single isolated node (6) ----------
        // no edges for 6

        // Print adjacency list
//        System.out.println("Adjacency List:");
//        for (int i = 0; i < v; i++) {
//            System.out.print(i + " -> ");
//            for (Graph.Edge e : graph[i]) {
//                System.out.print("(" + e.src + " -> " + e.des + ", wt=" + e.wt + ") ");
//            }
//            System.out.println();
//        }

        // DFS for connected components
        System.out.println("\nConnected Components:");
        dfs(graph);
    }

    // Traverse all components
    public static void dfs(ArrayList<Graph.Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                System.out.print("Component: ");
                dfsUtil(graph, i, visited);
                System.out.println();
            }
        }
    }

    // DFS utility function
    public static void dfsUtil(ArrayList<Graph.Edge>[] graph, int curr, boolean[] visited) {
        visited[curr] = true;
        System.out.print(curr + " ");

        for (Graph.Edge e : graph[curr]) {
            if (!visited[e.des]) {
                dfsUtil(graph, e.des, visited);
            }
        }
    }

}
