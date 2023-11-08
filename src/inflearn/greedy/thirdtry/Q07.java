package inflearn.greedy.thirdtry;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q07 {
    static class Edge implements Comparable<Edge>{
        int v1;
        int v2;
        int cost;
        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }
    static int[] unf;

    static int Find(int n) {
        if (n == unf[n]) return n;
        else return unf[n] = Find(unf[n]);
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb)  unf[fa] = fb;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) unf[i] = i;
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(stdIn.readLine());
            edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(edges);
        int cnt = 0;
        int answer = 0;
        for (Edge edge : edges) {
            if (cnt == n - 1) break;
            if (Find(edge.v1) != Find(edge.v2)) {
                Union(edge.v1, edge.v2);
                answer += edge.cost;
                cnt++;
            }
         }
        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
