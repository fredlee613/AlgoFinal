package inflearn.dynamic;

import java.io.*;
import java.util.*;

public class Q05 {
    static int napSack(int[] coins, int[] arr, int n, int m) {
        arr[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= m; j++) {
                arr[j] = Math.min(arr[j], arr[j - coins[i]] + 1);
            }
        }
        return arr[m];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(stdIn.readLine());
        int[] coins = new int[n];
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) coins[i] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[m + 1];
        Arrays.fill(arr, m + 1);

        stdOut.write(String.valueOf(napSack(coins, arr, n, m)));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
