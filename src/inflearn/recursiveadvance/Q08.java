package inflearn.recursiveadvance;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 8. 수열 추측하기
 */
public class Q08 {
    static int n, f;

    static int[] ch, arr, b;
    static int[][] pm;
    static String answer = "";
    static boolean flag = false;

    public int makePermutation(int n, int r) {
        if (pm[n][r] > 0) return pm[n][r];
        if (n == r || r == 0) return 1;
        else {
            return pm[n][r] = makePermutation(n - 1, r - 1) + makePermutation(n - 1, r);
        }
    }

    public void findList(int L, int sum) {
        if (flag) return;
        if (L == n + 1) {
            if (sum == f) {
                for (int i = 1; i <= n; i++) {
                    answer += arr[i] + " ";
                }
                flag = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] != 1) {
                    ch[i] = 1;
                    arr[L] = i;
                    findList(L + 1, sum + (arr[L] * b[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Q08 main = new Q08();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        ch = new int[n + 1];
        arr = new int[n + 1];
        b = new int[n + 1];
        pm = new int[35][35];

        for (int i = 0; i < n; i++) {
            b[i+1] = main.makePermutation(n - 1, i);
        }

        main.findList(1, 0);

        stdOut.write(String.valueOf(answer));

        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
