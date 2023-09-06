package inflearn.recursiveadvance;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 5. 동전교환
 */
public class Q05 {
    static int n, m;
    static int[] ch, arr;
    static int answer = Integer.MAX_VALUE;

    public void DFS(int L, int sum) {
        if (sum > m) return;
        if (L >= answer) return;
        if (sum == m) answer = Math.min(answer, L);
        else {
            for (int i = 1; i <= n; i++) {
                DFS(L + 1, sum + arr[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Q05 main = new Q05();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(stdIn.readLine());
        arr = new int[n + 1];
        st = new StringTokenizer(stdIn.readLine());
        for (int i = n; i >= 1; i--) arr[i] = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(stdIn.readLine());

        main.DFS(0, 0);
        stdOut.write(String.valueOf(answer));

        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
