package inflearn.greedy.thirdtry;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q06 {
    static int n, m;
    static int[] unf;

    static int Find(int n) {
        if (n == unf[n]) return unf[n];
        else return unf[n] = Find(unf[n]);
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) unf[i] = i;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(stdIn.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Union(a, b);
        }
//        System.out.println("unf = " + Arrays.toString(unf));
        st = new StringTokenizer(stdIn.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int fa = Find(a);
        int fb = Find(b);

        if (fa == fb) stdOut.write("YES");
        else stdOut.write("NO");

        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
