package inflearn.recursiveadvance;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 2. 바둑이 승차(DFS)
 */
public class Q02 {
    static int n, c;
    static int[] ch, arr;
    static int answer = Integer.MIN_VALUE;

    public void DFS(int L) {
        if (L == n + 1) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) sum += arr[i];
            }
            if (sum <= c) {
                answer = Math.max(sum, answer);
            }
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        Q02 main = new Q02();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());

        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        ch = new int[n + 1];
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(stdIn.readLine());

        main.DFS(1);
        stdOut.write(String.valueOf(answer));

        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
