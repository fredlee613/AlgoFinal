package inflearn.greedy;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 6. 친구인가? (Disjoint-Set : Union&Find)
 */
public class Q06 {
    static int[] unf;

    public int find(int a) {
        if (a == unf[a]) return a;
        else return unf[a] = find(unf[a]);
    }

    public void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fa] = unf[b];
    }

    public static void main(String[] args) throws IOException {
        Q06 main = new Q06();
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
            main.union(a, b);
        }
        st = new StringTokenizer(stdIn.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        String answer = "YES";
        if (main.find(a) != main.find(b)) answer = "NO";
        stdOut.write(answer);
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
