package inflearn.sorting;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 2. 버블 정렬
 */
public class Q02 {

    public int[] bubbleSort(int n, int[] arr) {
        for (int x = 0; x < n - 1 ; x++) {
            for (int y = 0; y < n - x - 1; y++) {
                if (arr[y] > arr[y + 1]) {
                    int tmp = arr[y];
                    arr[y] = arr[y + 1];
                    arr[y + 1] = tmp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) throws IOException {
        Q02 main = new Q02();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        arr = main.bubbleSort(n, arr);
        for (int i : arr) {
            stdOut.write(i + " ");
        }
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
