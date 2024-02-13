package boj.array;

import java.io.*;
import java.util.StringTokenizer;

public class Q10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] basket = new int[n + 1];
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(stdIn.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            for (int j = from; j <= to; j++) basket[j] = ball;
        }
        for (int i = 1; i <= basket.length - 1; i++) {
            stdOut.write(String.valueOf(basket[i]));
            if (i != basket.length - 1) stdOut.write(" ");
        }
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
