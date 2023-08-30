package inflearn.array;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 2. 보이는 학생
 */
public class Q02 {
    public String printBiggerInt(int n, int[] arr) {
        int answer = 1;
        int biggest = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > biggest) {
                biggest = arr[i];
                answer++;
            }
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Q02 main = new Q02();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        stdOut.write(main.printBiggerInt(n, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
