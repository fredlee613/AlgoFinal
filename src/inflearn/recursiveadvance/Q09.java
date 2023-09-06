package inflearn.recursiveadvance;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 9. 조합 구하기
 */
public class Q09 {
    static int n, m;
    static int[] arr;
    static String answer = "";

    public void DFS(int L, int S) {
        if (L == m + 1) {
            for (int i = 1; i <= m; i++) {
                answer += arr[i] + " ";
            }
            answer += "\n";
        } else {
            for (int i = S; i <= n; i++) {
                arr[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Q09 main = new Q09();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =  new StringTokenizer(stdIn.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr =new int[m + 1];

        main.DFS(1, 1);
        stdOut.write(String.valueOf(answer));

        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
