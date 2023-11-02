package inflearn.greedy.secondtry;

import java.io.*;
import java.util.StringTokenizer;

public class Q06 {
    static int[] unf;

    static int Find(int n) {
        if (n == unf[n]) return n;
        else return unf[n] = Find(unf[n]);
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fb] = unf[fa];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) unf[i] = i;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(stdIn.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Union(a, b);
        }
        st = new StringTokenizer(stdIn.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int fa = Find(a);
        int fb = Find(b);
        String answer = "";
        if (fa == fb) answer = "YES";
        else answer = "NO";

        stdOut.write(answer);
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
