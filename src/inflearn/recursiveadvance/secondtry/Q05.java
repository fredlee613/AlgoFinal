package inflearn.recursiveadvance.secondtry;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q05 {
    static int N, M, answer = Integer.MAX_VALUE;
    static int[] ch;
    static Integer[] coins;

    static void DFS(int L, int S) {
        if (S > M) return;
        if (L >= answer) return;
        if (S == M) answer = Math.min(L, answer);
        else {
            for (int i = 0; i < N; i++) {
                DFS(L + 1, S + coins[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(stdIn.readLine());
        ch = new int[N];
        coins = new Integer[N];
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < N; i++) coins[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(coins, Collections.reverseOrder());
        M = Integer.parseInt(stdIn.readLine());
        DFS(0, 0);

        System.out.print(answer);
    }

}
