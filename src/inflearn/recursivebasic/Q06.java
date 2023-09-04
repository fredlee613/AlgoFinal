package inflearn.recursivebasic;

import java.io.*;

/**
 * 6. 부분집합 구하기(DFS)
 */
public class Q06 {
    static int n;
    static int[] ch;
    static String answer = "";

    public void DFS (int L) {
        if (L == n + 1) {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) answer += i + " ";
            }
            answer += "\n";
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        Q06 main = new Q06();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(stdIn.readLine());
        ch = new int[n + 1];

        main.DFS(1);

        stdOut.write(answer);
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
