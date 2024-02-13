package boj.array;

import java.io.*;
import java.util.StringTokenizer;

public class Q10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] basket = new int[n + 1];
        for (int i = 1; i <= n; i++) basket[i] = i;
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(stdIn.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int tmp = basket[from];
            basket[from] = basket[to];
            basket[to] = tmp;
        }
        for (int i = 1; i <= n; i++) {
            stdOut.write(String.valueOf(basket[i]));
            if (i != n) stdOut.write(" ");
        }

        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
