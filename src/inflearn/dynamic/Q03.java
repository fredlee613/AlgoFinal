package inflearn.dynamic;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q03 {
    static int[] seq, dy;

    static int dp(int n) {
        dy[1] = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = 0;
            for (int j = i - 1; j > 0; j--) {
                if (seq[j] < seq[i]) tmp = Math.max(tmp, dy[j]);
            }
            dy[i] = tmp + 1;
        }
        return Arrays.stream(dy).max().getAsInt();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());
        seq = new int[n + 1];
        dy = new int[n + 1];
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 1; i <= n; i++) seq[i] = Integer.parseInt(st.nextToken());
        stdOut.write(String.valueOf(dp(n)));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
