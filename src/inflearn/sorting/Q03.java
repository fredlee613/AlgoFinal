package inflearn.sorting;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 3. 삽입 정렬
 */
public class Q03 {

    public int[] insertionSort(int n, int[] arr) {
        for (int x = 0; x < n; x++) {
            int num = arr[x];
            for (int y = x - 1; y >= 0; y--) {
                // 비교하는 수가 작을 경우 한칸씩 뒤로 미룬다.
                if (num <= arr[y]) {
                    arr[y + 1] = arr[y];
                    arr[y] = num;
                }
                    // 비교하는 수가 클 경우
                else break;
            }
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        Q03 main = new Q03();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        arr = main.insertionSort(n, arr);
        for (int i : arr) {
            stdOut.write(i + " ");
        }
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
