package inflearn.array;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 6. 뒤집은 소수
 */
public class Q06 {
    public String printReversePrimeNumber(int n, String[] arr) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            String tmp = arr[i];
            if (isPrimeNumber(Integer.parseInt(flipWord(tmp)))) {
                answer += Integer.parseInt(flipWord(tmp)) + " ";
            }
        }
        return answer;
    }

    private static String flipWord(String word) {
        char[] arr = word.toCharArray();
        int n = word.length();
        for (int i = 0; i < n / 2; i++) {
            char tmp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = tmp;
        }
        return new String(arr);
    }

    private static boolean isPrimeNumber(int number) {
        if (number == 1) return false;
        if (number == 2) return true;
        int[] ch = new int[number + 1];
        for (int i = 2; i <= number; i++) ch[i] = i;
        int tmp = 2;
        while (true) {
            if (ch[tmp] != 0) {
                if (number % tmp != 0) { // tmp로 안나눠질 경우
                    for (int i = tmp + 1; i <= number; i++) { // tmp의 배수들을 0으로 처리
                        if (ch[i] % tmp == 0) ch[i] = 0;
                    }
                } else {
                    return false;
                }
            }
            if (Math.pow(tmp, 2) > number) break;
            tmp++;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Q06 main = new Q06();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(stdIn.readLine());
        String[] arr = new String[n];
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = st.nextToken();

        stdOut.write(main.printReversePrimeNumber(n, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
