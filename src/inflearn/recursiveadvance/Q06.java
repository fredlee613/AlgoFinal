package inflearn.recursiveadvance;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 6. 순열 구하기
 */
public class Q06 {
    static int n, m;
    static int[] ch, arr, pm;
    static String answer = "";

    public void DFS(int L) {
        if (L == m + 1) {
            for (int i = 1; i <= m; i++) {
                answer += pm[i] + " ";
            }
            answer += "\n";
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] != 1) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Q06 main = new Q06();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        ch = new int[n + 1];
        pm = new int[m + 1];

        st = new StringTokenizer(stdIn.readLine());
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        main.DFS(1);
        stdOut.write(String.valueOf(answer));

        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
