package inflearn.recursiveadvance.secondtry;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q03 {
    static int N, M, answer = Integer.MIN_VALUE;
    static int[] ch;
    static ArrayList<Questions> arr = new ArrayList<>();

    static class Questions {
        int score;
        int time;

        public Questions(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    static void DFS(int L) {
        if (L == N) {
            int score = 0, time = 0;
            for (int i = 0; i < N; i++) {
                if (ch[i] == 1) {
                    score += arr.get(i).score;
                    time += arr.get(i).time;
                }
            }
            if (time <= M) answer = Math.max(score, answer);
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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ch = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(stdIn.readLine());
            arr.add(new Questions(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        DFS(0);

        stdOut.write(String.valueOf(answer));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
