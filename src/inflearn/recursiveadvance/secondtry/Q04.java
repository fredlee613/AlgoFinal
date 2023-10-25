package inflearn.recursiveadvance.secondtry;

import java.io.*;
import java.util.StringTokenizer;

public class Q04 {
    static int N, M;
    static int[] ch;

    static void DFS(int L) {
        if (L == N){
            for (int i = 1; i <= M; i++) System.out.print(ch[i] + " ");
            System.out.println();
        } else {
            for (int i = 1; i <= N; i++) {
                ch[L] = i;
                DFS(L + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ch = new int[N + 1];

        DFS(1);

    }
}
