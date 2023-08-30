package inflearn.array;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 7. 점수계산
 */
public class Q07 {
    public String calculateScore(int n, String[] arr) {
        int score = 0, tmp = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].equals("1")) tmp++;
            else tmp = 0;
            score += tmp;
        }
        return String.valueOf(score);
    }


    public static void main(String[] args) throws IOException {
        Q07 main = new Q07();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(stdIn.readLine());
        String[] arr = new String[n];
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = st.nextToken();

        stdOut.write(main.calculateScore(n, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
