package inflearn.array;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 8. 등수구하기
 */
public class Q08 {
    public String calculateRanking(int n, int[] arr) {
        String answer = "";
        int[] ranking = new int[n];
        for (int x = 0; x < n; x++) {
            int tmp = 1;
            for (int y = 0; y < n; y++) {
                if (x != y) {
                    if (arr[x] < arr[y]) tmp++;
                }
            }
            ranking[x] = tmp;
        }
        for (int x = 0; x < n; x++) {
            answer += ranking[x];
            if (x != n - 1) answer += " ";
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {
        Q08 main = new Q08();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        stdOut.write(main.calculateRanking(n, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
