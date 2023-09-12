package inflearn.greedy;

import java.io.*;
import java.util.*;

/**
 * 원더랜드(최소스패닝트리 : 프림, PriorintyQueue)
 */
public class Q08 {

    static class Edge implements Comparable<Edge> {
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

    static int[] ch;
    static ArrayList<ArrayList<Edge>> graph;


    public static void main(String[] args) throws IOException {
        Q08 main = new Q08();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ch = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(stdIn.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, cost));
            graph.get(to).add(new Edge(from, cost));
        }
        int answer = 0;
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(1, 0));
        while (!q.isEmpty()) {
            Edge ce = q.poll();
            int cv = ce.vertex;
            if (ch[cv] == 0) {
                ch[cv] = 1;
                answer += ce.cost;
                for (Edge edge : graph.get(cv)) {
//                    System.out.println("ch[" + edge.vertex + "] = " + ch[edge.vertex]);
                    if (ch[edge.vertex] == 0) q.offer(edge);
                }
            }
        }
        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
