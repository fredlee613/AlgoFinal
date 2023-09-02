package inflearn.sorting;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 선택 정렬
 */
public class Q01 {

    public int[] selectionSort(int n, int[] arr) {
        for (int x = 0; x < n; x++) {
            int standard = arr[x];
            for (int y = x + 1; y < n; y++) {
                if (arr[y] < standard) {
                    standard = arr[y];
                    int tmp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = tmp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) throws IOException {
        Q01 main = new Q01();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        arr = main.selectionSort(n, arr);
        for (int i : arr) {
            stdOut.write(i + " ");
        }
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
