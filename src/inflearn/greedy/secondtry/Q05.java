package inflearn.greedy.secondtry;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q05 {
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
    static int n, m;
    static int[] dist;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    static void Dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Edge currentEdge = pq.poll();
            int currentCost = currentEdge.cost;
            int currentVertex = currentEdge.vertex;
            // 간선의 값이 현재 정점으로 가는 최소 거리의 값보다 클 경우 연산을 하지 않는다.
            if (dist[currentVertex] < currentCost) continue;
            // 현재 정점에서 갈 수 있는 정점들에 대한 비용을 조회한다.
            for (Edge edge : graph.get(currentVertex)) {
                int nextVertex = edge.vertex;
                int nextCost = edge.cost;
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
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        // 각 정점 별 간선과 거리 비용 값을 가지는 이차원 배열 추가
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(stdIn.readLine());
            int arrIdx = Integer.parseInt(st.nextToken());
            int vertex = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(arrIdx).add(new Edge(vertex, cost));
        }

        // Dijkstra 알고리즘의 경우 이동 가능한 정점 중 비용이 최소가 되는 간선을 선택하기 때문에 배열 내 모든 값을 최대값으로 설정해둔다.
        Arrays.fill(dist, Integer.MAX_VALUE);

        Dijkstra(1);
        for (int i = 2; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) stdOut.write(i + ": impossible");
            else stdOut.write(String.valueOf(i + " : " + dist[i]));

            if (i != n) stdOut.write("\n");
        }
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
