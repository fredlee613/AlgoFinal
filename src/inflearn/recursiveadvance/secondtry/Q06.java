package inflearn.recursiveadvance.secondtry;

import java.io.*;
import java.util.StringTokenizer;

public class Q06 {
    static int N, M;
    static int[] pm, arr, ch;

    static void DFS(int L) {
        if (L == M) {
            String tmp = "";
            for (int i = 0; i < M; i++) tmp += pm[i] + " ";
            System.out.println(tmp);
        } else {
            for (int i = 0; i < N; i++) {
                if (ch[i] == 0) {
                    pm[L] = arr[i];
                    ch[i] = 1;
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ch = new int[N];
        pm = new int[M];
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        DFS(0);

    }
}
