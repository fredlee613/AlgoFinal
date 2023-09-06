package inflearn.recursiveadvance;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 7. 조합수(메모이제이션)
 */
public class Q07 {
    static int n, r;
    static int[][] pm;

    public int DFS(int n, int r) {
        if (pm[n][r] > 0) return pm[n][r];
        if (n == r || r == 0) return 1;
        else {
            return pm[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
        }
    }

    public static void main(String[] args) throws IOException {
        Q07 main = new Q07();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        pm = new int[n + 1][r + 1];


        stdOut.write(String.valueOf(main.DFS(n, r)));

        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
