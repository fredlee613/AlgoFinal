package inflearn.recursivebasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 4. 피보나치 수열 (메모이제이션 사용)
 */
public class Q04 {
    static int[] fibo;
    public int Recursive(int n) {
        if (n == 1) return fibo[n] = 1;
        if (n == 2) return fibo[n] = 1;
        else {
            if (fibo[n] != 0) return fibo[n];
            else return fibo[n] = Recursive(n - 1) + Recursive(n - 2);
        }
    }

    public static void main(String[] args) throws IOException {
        Q04 main = new Q04();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(stdIn.readLine());
        fibo = new int[n + 1];
        for (int i = 1; i <= n; i++) fibo[n] = main.Recursive(n);
        for (int i = 1; i <= n; i++) System.out.print(fibo[i] + " ");

        stdIn.close();
    }
}
