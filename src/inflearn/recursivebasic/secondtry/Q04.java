package inflearn.recursivebasic.secondtry;

import java.io.*;

public class Q04 {
    static int[] arr;

    static int Recursive(int N) {
        if (N == 1) return 1;
        if (N == 2) return 1;
        else {
            if (arr[N] != 0) return arr[N];
            else return arr[N] = Recursive(N - 1) + Recursive(N - 2);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(stdIn.readLine());
        arr = new int[N + 1];
        arr[1] = arr[2] = 1;

        for (int i = 3; i <= N; i++) arr[i] = Recursive(i);
        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i]);
            if (i != N) System.out.print(" ");
        }
        stdOut.close();
        stdIn.close();
    }
}
