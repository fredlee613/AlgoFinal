package inflearn.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Q01 {
    static int[] dy;

    static int dp(int hop, int n) {
        for (int i = 1; i <= hop; i++) dy[i] = i;
        for (int i = hop + 1; i <= n; i++) dy[i] = dy[i - hop] + dy[i - hop + 1];
        return dy[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());
        dy = new int[n + 1];
        int result = dp(2, n);
        stdOut.write(String.valueOf(result));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
