package inflearn.array;

import java.io.*;

/**
 * 4. 피보나치 수열
 */
public class Q04 {
    public String printFibonacci(int n, int[] arr) {
        String answer = "";
        for (int i = 0; i < 3; i++) {
            answer += arr[i] + " ";
        }
        for (int i = 3; i < n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
            answer += String.valueOf(arr[i]);
            if (i != n -1) answer += " ";
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q04 main = new Q04();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;


        stdOut.write(main.printFibonacci(n, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
