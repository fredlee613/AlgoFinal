package boj.array;

import java.io.*;
import java.util.StringTokenizer;

public class Q10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(stdIn.readLine());
        int[] source = new int[n];

        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) source[i] = Integer.parseInt(st.nextToken());

        int target = Integer.parseInt(stdIn.readLine());
        int cnt = 0;
        for (int i : source) if (target == i) cnt++;

        stdOut.write(String.valueOf(cnt));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
