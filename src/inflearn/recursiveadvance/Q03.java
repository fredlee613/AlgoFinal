package inflearn.recursiveadvance;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 3. 최대점수 구하기(DFS)
 */


public class Q03 {
    static class Quiz {
        int point;
        int time;

        public Quiz(int point, int time) {
            this.point = point;
            this.time = time;
        }
    }
    static int n, m;
    static int[] ch;
    static Quiz[] arr;
    static int answer = Integer.MIN_VALUE;

    public void DFS(int L) {
        if (L == n + 1) {
            int sumOfTime = 0;
            int sumOfPoint = 0;
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    sumOfPoint += arr[i].point;
                    sumOfTime += arr[i].time;
                }
            }
            if (sumOfTime <= m) {
                answer = Math.max(sumOfPoint, answer);
            }
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        Q03 main = new Q03();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ch = new int[n + 1];
        arr = new Quiz[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            arr[i] = new Quiz(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        main.DFS(1);
        stdOut.write(String.valueOf(answer));

        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
