package inflearn.recursiveadvance;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 합이 같은 부분집합(DFS : 아마존 인터뷰)
 */
public class Q01 {
    static int n, total;
    static int[] ch, arr;
    static String answer = "NO";

    public void DFS(int L) {
        if (L == n + 1) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) sum += arr[i];
            }
            if (sum == total - sum) answer =  "YES";
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        Q01 main = new Q01();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(stdIn.readLine());
        ch = new int[n + 1];
        arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        total = Arrays.stream(arr).sum();
        main.DFS(1);
        stdOut.write(answer);

        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
