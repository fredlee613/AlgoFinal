package inflearn.recursiveadvance.secondtry;

import java.io.*;
import java.util.StringTokenizer;

public class Q07 {
    static int n, r;
    static int[][] comb;

    static int DFS(int ln, int rn) {
        if (comb[ln][rn] != 0) return comb[ln][rn];
        if (rn == 1) return comb[ln][rn] = ln;
        if (ln == rn) return comb[ln][rn] = 1;
        if (rn == 0) return comb[ln][rn] = 1;
        return comb[ln][rn] = DFS(ln - 1, rn - 1) + DFS(ln - 1, rn);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        comb = new int[n + 1][r + 1];
        int answer = DFS(n, r);
        System.out.print(answer);
    }
}
