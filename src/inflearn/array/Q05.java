package inflearn.array;

import java.io.*;
import java.util.ArrayList;

/**
 * 5. 소수(에라토스테네스 체)
 */
public class Q05 {
    public String printFibonacci(int n, int[] arr, ArrayList<Integer> ch) {
        int tmp = 3;
        ch.add(2); // 소수 리스트에 2 추가
        for (int i = 3; i <= n; i++) { // 2의 배수들은 전부 0 처리
            if (arr[i] % 2 == 0) arr[i] = 0;
        }
        while (true) {
            if (arr[tmp] != 0) {
                boolean flag = true;
                for (Integer integer : ch) {
                    if (tmp % integer == 0) { // 소수들로 나누어질 경우 소수가 아님 => flag = false
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    ch.add(tmp);
                    for (int x = tmp + 1; x <= n; x++) {
                        if (arr[x] != 0 && arr[x] % tmp == 0) arr[x] = 0;
                    }
                }
            }
            if (Math.pow(tmp, 2) > n) break;
            tmp++;
        }
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (arr[i] != 0) answer++;
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Q05 main = new Q05();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[n + 1];
        ArrayList<Integer> ch = new ArrayList<>();
        for (int i = 1; i <= n; i++) arr[i] = i;

        stdOut.write(main.printFibonacci(n, arr, ch));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
