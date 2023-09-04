package inflearn.sorting;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 8. 이분검색
 */
public class Q08 {

    public String binarySearch(int n, int s, int[] arr) {
        Arrays.sort(arr);
//        System.out.println("arr = " + Arrays.toString(arr));
        int answer = -1, lt = 0, rt = n - 1;
        while (lt <= rt) {
//            System.out.println("lt = " + lt + ", rt = " + rt);
            answer = (lt + rt) / 2;
            if (arr[answer] == s) return String.valueOf(answer + 1);
            else if (arr[answer] > s) rt = answer - 1;
            else lt = answer + 1;
        }
        return String.valueOf(answer + 1);
    }


    public static void main(String[] args) throws IOException {
        Q08 main = new Q08();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        stdOut.write(main.binarySearch(n, m, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
