package inflearn.recursiveadvance.secondtry;

import java.io.*;
import java.util.StringTokenizer;

public class Q09 {
    static int N, M;
    static int[] arr;

    static void DFS(int L, int K) {
        if (L == M + 1) {
            for (int i = 1; i <= M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = K; i <= N; i++) {
                arr[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M + 1];

        DFS(1, 1);
    }
}
