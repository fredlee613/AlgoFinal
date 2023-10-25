package inflearn.recursiveadvance.secondtry;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q02 {
    static int c, n, answer = Integer.MIN_VALUE;
    static int[] ch;
    static Integer[] pubs;

    static void DFS(int L) {
        if (L == n) {
            int tmp = 0;
            for (int i = 0; i < n; i++) if (ch[i] == 1) tmp += pubs[i];
            if (tmp <= c) answer = Math.max(tmp, answer);
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        pubs = new Integer[n];
        ch = new int[n];

        for (int i = 0; i < n; i++) pubs[i] = Integer.parseInt(stdIn.readLine());
        Arrays.sort(pubs, Collections.reverseOrder());
        DFS(0);

        stdOut.write(String.valueOf(answer));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
