package boj.greedy.unionfind;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1976 {
    static int n, m;
    static boolean flag = true;
    static String answer = "YES";
    static int[] unf, ch, compare = new int[3];
    static ArrayList<Integer> plan = new ArrayList<>();

    static int Find(int n) {
        if (n == unf[n]) return n;
        else return unf[n] = Find(unf[n]);
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }

    static void DFS(int L, int S) {
        if (flag) {
            if (L == 3) {
//                System.out.println("Arrays.toString(compare) = " + Arrays.toString(compare));
                if (Find(compare[1]) != Find(compare[2])) {
                    flag = false;
                    answer = "NO";
                }

            } else {
                for (int i = S; i < plan.size(); i++) {
                    compare[L] = plan.get(i);
                    DFS(L + 1, i + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(stdIn.readLine());
        m = Integer.parseInt(stdIn.readLine());
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) unf[i] = i;
        ch = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int j = 1; j <= n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) Union(i, j);
            }
        }
        st = new StringTokenizer(stdIn.readLine());
        while (st.hasMoreTokens()) {
            plan.add(Integer.parseInt(st.nextToken()));
        }

        DFS(1, 0);


//        System.out.println("unf = " + Arrays.toString(unf));
        stdOut.write(answer);
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
