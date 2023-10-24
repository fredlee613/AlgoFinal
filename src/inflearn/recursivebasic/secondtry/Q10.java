package inflearn.recursivebasic.secondtry;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q10 {
    static int n, m, answer;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static void DFS(int L) {
        if (L == n) {
            answer++;
        } else {
            for (Integer x : graph.get(L)) {
                if (ch[x] == 0) {
                    ch[x] = 1;
                    DFS(x);
                    ch[x] = 0;
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
        ch = new int[n + 1];
        ch[1] = 1;
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(stdIn.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }
        DFS(1);
        System.out.print(answer);
    }
}
