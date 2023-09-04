package inflearn.recursivebasic;

import java.io.*;
import java.util.*;

/**
 * 10. 경로 탐색(인접행렬)
 */
public class Q10 {
    static int n, m, answer = 0;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public void DFS(int v) {
        if (v == n) answer++;
        else {
            for (Integer nv : graph.get(v)) {
                if (ch[nv] != 1) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Q10 main = new Q10();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());

        n = Integer.parseInt(st.nextToken());
        ch = new int[n + 1];
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(stdIn.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        ch[1] = 1;
        main.DFS(1);


        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();

    }
}
