package com.jasveer.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Graphs {

    static class Edge {
        int src;
        int des;
        int wei;

        Edge(int src, int des, int wei) {
            this.src = src;
            this.des = des;
            this.wei = wei;
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex 0
        graph[0].add(new Edge(0, 1, 5));

        // vertex 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // vertex 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));

        // vertex 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // vertex 4
        graph[4].add(new Edge(4, 2, 2));

        // Print neighbors of vertex 2
        System.out.println("Neighbors of 2:");
        for (Edge e : graph[2]) {
            System.out.println("To: " + e.des + ", weight: " + e.wei);
        }

        // Run BFS from vertex 0
        System.out.println("\nBFS traversal starting from node 0:");
        bfs(graph, v);
        System.out.println("\nDFS traversal starting from node 0:");
        dfs(graph,0,new boolean[v]);
        System.out.println();
        System.out.println(hasPath(graph,0,5,new boolean[v]));
    }

    public static void bfs(ArrayList<Edge>[] graph, int vertices)
    {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[vertices];

        q.add(0); // starting from node 0

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;

                for(int i= 0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.des);
                }
            }
        }
    }
    public static void dfs(ArrayList<Edge>[] graph,int curr,boolean[] vis)
    {
        System.out.print(curr+" ");
        vis[curr] = true;
        for(Edge e: graph[curr])
        {
            if(!vis[e.des])
            {
                dfs(graph, e.des, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph,int src,int des,boolean[] vis)
    {

        if(src == des){
            return true;
        }
        vis[src] =true;
        for(int i = 0;i<graph[src].size();i++)
        {
            Edge e = graph[src].get(i);
            if(!vis[e.des] && hasPath(graph, e.des, des, vis)){
                return true;
            }
        }
        return false;
    }

}