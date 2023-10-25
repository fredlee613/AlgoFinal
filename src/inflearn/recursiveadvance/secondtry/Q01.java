package inflearn.recursiveadvance.secondtry;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q01 {
    static int n, sum;
    static int[] arr, ch;

    static String answer = "NO";

    static void DFS(int L) {
        if (L == n) {
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                if (ch[i] != 0) tmp += arr[i];
            }
            if (tmp == (sum - tmp)) answer = "YES";
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(stdIn.readLine());
        arr = new int[n];
        ch = new int[n];
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        sum = Arrays.stream(arr).sum();
        DFS(0);

        stdOut.write(answer);
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
