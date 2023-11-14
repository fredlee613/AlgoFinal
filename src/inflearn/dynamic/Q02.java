package inflearn.dynamic;

import java.io.*;

public class Q02 {
    static int[] dy;

    static int dp(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n + 1; i++) dy[i] = dy[i - 2] + dy[i - 1];
        return dy[n + 1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());
        dy = new int[n + 2];
        stdOut.write(String.valueOf(dp(n)));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
