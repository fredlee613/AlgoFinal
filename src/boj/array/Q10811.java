package boj.array;

import java.io.*;
import java.util.StringTokenizer;

public class Q10811 {

    static void switchBasket(int[] arr, int from, int to) {
        if (from == to) return;
        for (int i = from; i <= (from + to) / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[to + from - i];
            arr[to + from - i] = tmp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] baskets = new int[n + 1];
        for (int i = 1; i <= n; i++) baskets[i] = i;
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(stdIn.readLine());
            switchBasket(baskets, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 1; i <= n; i++) {
            stdOut.write(String.valueOf(baskets[i]));
            if (i != n) stdOut.write(" ");
        }
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
