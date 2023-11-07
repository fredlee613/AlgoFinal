package boj.greedy.mst;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1197 {
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
    static int[] ch;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    static int Prim(int start) {
        int answer = 0;
        int cnt = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        while (!pq.isEmpty()) {
            if (cnt == n) break;
            Edge cp = pq.poll();
            if (ch[cp.vertex] == 0) {
                answer += cp.cost;
                ch[cp.vertex] = 1;
                for (Edge edge : graph.get(cp.vertex)) {
                    if (ch[edge.vertex] == 0) pq.offer(edge);
                }
                cnt++;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(stdIn.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        stdOut.write(String.valueOf(Prim(1)));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
