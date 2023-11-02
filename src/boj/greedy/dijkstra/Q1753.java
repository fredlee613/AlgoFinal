package boj.greedy.dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1753 {
    static class Edge implements Comparable<Edge>{
        int vertex;
        int cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }
    static int numberOfEdge, numberOfVertex;
    static int[] dist;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    static void Dijkstra(int startEdge) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(startEdge, 0));
        dist[startEdge] = 0;
        while (!pq.isEmpty()) {
            Edge currentEdge = pq.poll();
            int currentCost = currentEdge.cost;
            int currentVertex = currentEdge.vertex;
            if (dist[currentVertex] < currentCost) continue;
            for (Edge edge : graph.get(currentVertex)) {
                int nextCost = edge.cost;
                int nextVertex = edge.vertex;
                if (dist[nextVertex] > currentCost + nextCost) {
                    dist[nextVertex] = currentCost + nextCost;
                    pq.offer(new Edge(nextVertex, currentCost + nextCost));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        numberOfEdge = Integer.parseInt(st.nextToken());
        numberOfVertex = Integer.parseInt(st.nextToken());
        dist = new int[numberOfEdge + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        int startEdge = Integer.parseInt(stdIn.readLine());
        for (int i = 0; i <= numberOfEdge; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < numberOfVertex; i++) {
            st = new StringTokenizer(stdIn.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, cost));
        }

        Dijkstra(startEdge);
        for (int i = 1; i <= numberOfEdge; i++) {
            if (i == startEdge) stdOut.write(String.valueOf(0));
            else if (dist[i] == Integer.MAX_VALUE) stdOut.write("INF");
            else stdOut.write(String.valueOf(dist[i]));

            if (i != numberOfEdge) stdOut.write("\n");
        }

        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
