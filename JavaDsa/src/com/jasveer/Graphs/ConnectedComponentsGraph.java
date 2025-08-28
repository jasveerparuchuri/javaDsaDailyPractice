package com.jasveer.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
//        System.out.println(detectCycle(graph));
        System.out.println(isCycle(graph));
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

    // Bfs
    public static void bfs(ArrayList<Graph.Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                System.out.print("Component: ");
                bfsUtil(graph, visited, i);
                System.out.println();
            }
        }
    }

    // BFS starting from "start"
    public static void bfsUtil(ArrayList<Graph.Edge>[] graph, boolean[] visited, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;

                for (Graph.Edge e : graph[curr]) {
                    if (!visited[e.des]) {
                        q.add(e.des);
                    }
                }
            }
        }
    }

    public static boolean detectCycle(ArrayList<Graph.Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (detectCycleUtil(graph, visited, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean detectCycleUtil(ArrayList<Graph.Edge>[] graph, boolean[] visited, int curr, int parent) {
        visited[curr] = true;

        for (int j = 0; j < graph[curr].size(); j++) {
            Graph.Edge e = graph[curr].get(j);

            // If neighbor not visited, recurse
            if (!visited[e.des]) {
                if (detectCycleUtil(graph, visited, e.des, curr)) {
                    return true;
                }
            }
            // If neighbor is visited and not parent → cycle found
            else if (e.des != parent) {
                return true;
            }
        }

        return false;
    }
    public static boolean isBipartite(ArrayList<Graph.Edge>[] graph) {
        int[] col = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            col[i] = -1; // no color
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) { // not colored yet
                q.add(i);
                col[i] = 0; // start with color 0

                while (!q.isEmpty()) {
                    int curr = q.remove();

                    for (int j = 0; j < graph[curr].size(); j++) {
                        Graph.Edge e = graph[curr].get(j);

                        if (col[e.des] == -1) { // not visited
                            int nextCol = (col[curr] == 0) ? 1 : 0;
                            col[e.des] = nextCol;
                            q.add(e.des);
                        } else if (col[e.des] == col[curr]) {
                            // same color as current → not bipartite
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isCycle(ArrayList<Graph.Edge>[] graph)
    {
        boolean[] visted = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];
        for(int i = 0;i <graph.length;i++) {
            if (!visted[i]) {
                if (isCycleUtil(graph, i, visted, stack)) {
                    return true;
                }
            }
        }
        return  false;
    }
    public static boolean isCycleUtil(ArrayList<Graph.Edge>[] graph,int curr,boolean[] vis,boolean[] stack){
        vis[curr] = true;
        stack[curr]= true;
        for(int i = 0;i<graph[curr].size();i++)
        {
            Graph.Edge  e = graph[curr].get(i);
            if(stack[e.des]){
                return true;
            }
            if(!vis[e.des] && isCycleUtil(graph, e.des, vis, stack)){
                return true;
            }
        }
        stack[curr] = false;
        return false;

    }
    public static  void topSort(ArrayList<Graph.Edge>[] graph){
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                topSortUtil(graph,i,s,vis);
            }
        }
        while(!s.isEmpty()){
            System.out.println(s.pop()+" ");
        }
    }

    // DAG(directed acyclic graph)  is  required fot topological
    public static  void topSortUtil(ArrayList<Graph.Edge>[] graph,int curr,Stack<Integer> s,boolean[] vis){
        vis[curr] = true;
        for(int i = 0;i<graph[curr].size();i++){
            Graph.Edge e = graph[curr].get(i);

            if(!vis[e.des]){
                topSortUtil(graph, e.des, s, vis);
            }
        }
        s.push(curr);
    }


    // Khan's Algo
    public static void calInDeg(ArrayList<Graph.Edge>[] graph,int[] indeg)
    {
        for(int i = 0;i< graph.length;i++)
        {
            for(int j = 0;j<graph[i].size();i++)
            {
                Graph.Edge e = graph[i].get(j);
                indeg[e.des]++;
            }
        }
    }
    public static  void topSortBfs(ArrayList<Graph.Edge>[] graph)
    {
        int indeg[] = new int[graph.length];
        calInDeg(graph,indeg);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i< graph.length;i++)
        {
            if(indeg[i] == 0)
            {
                q.add(i);
            }
        }

        while(!q.isEmpty())
        {
            int curr = q.remove();
            System.out.println(curr+" ");
            for(int i = 0;i<graph[curr].size();i++)
            {
                Graph.Edge e = graph[curr].get(i);
                indeg[e.des]--;
                if(indeg[e.des] == 0)
                {
                    q.add(e.des);
                }
            }
        }
    }

}
