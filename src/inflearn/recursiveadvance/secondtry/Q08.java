package inflearn.recursiveadvance.secondtry;

import java.io.*;
import java.util.StringTokenizer;

public class Q08 {
    static int n, r;
    static int[] arr, ch;
    static int[][] comb;
    static boolean flag = true;

    static int combination(int ln, int rn) {
        if (comb[ln][rn] != 0) return comb[ln][rn];
        if (rn == 1) return comb[ln][rn] = ln;
        if (ln == rn) return comb[ln][rn] = 1;
        if (rn == 0) return comb[ln][rn] = 1;
        return comb[ln][rn] = combination(ln - 1, rn - 1) + combination(ln - 1, rn);
    }

    static void DFS(int L, int sum) {
        if (sum > r) return;
        if (flag) {
            if (L == n) {
                if (sum == r) {
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    flag = false;
                }
            } else {
                for (int i = 1; i <= n; i++) {
                    if (ch[i] == 0) {
                        ch[i] = 1;
                        arr[L] = i;
                        DFS(L + 1, sum + combination(n - 1, L) * i);
                        ch[i] = 0;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        comb = new int[n + 1][r + 1];
        arr = new int[n];
        ch = new int[n + 1];
        DFS(0, 0);
    }
}
