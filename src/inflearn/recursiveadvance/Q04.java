package inflearn.recursiveadvance;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 4. 중복순열 구하기
 */
public class Q04 {
    static int n, m;
    static int[] arr;
    static String answer = "";
    public void DFS(int L) {
        if (L == m + 1) {
            for (int i = 1; i <= m; i++) answer += arr[i] + " ";
            answer += "\n";
        } else {
            for (int i = 1; i <= n; i++) {
                arr[L] = i;
                DFS(L + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Q04 main = new Q04();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = i;
        m = Integer.parseInt(st.nextToken());

        main.DFS(1);

        stdOut.write(answer);
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
