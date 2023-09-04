package inflearn.sorting;

import java.io.*;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * 9. 뮤직비디오(결정알고리즘)
 */
public class Q09 {

    /**
     * 최소값(lt): 배열 요소 중 최소 값
     * 최대값(rt): 배열 요소의 총 합
     * 이진 탐색처럼 dvd 제작 수 산출 후 m과 비교
     */
    public String goatJYP(int n, int s, int[] arr) {
        int lt = Arrays.stream(arr).min().getAsInt();
        int rt = Arrays.stream(arr).sum();
        int answer = Integer.MAX_VALUE;
        while (lt <= rt) {
            System.out.println("=======================");
            int tmp = (lt + rt) / 2;
            int cnt = countDvd(n, tmp, arr);
            System.out.println("lt = " + lt + ", rt = " + rt + ", tmp = " + tmp + ", cnt = " + cnt);
            if (cnt > s) lt = tmp + 1;
            else {
//                if (cnt == s) answer = Math.min(answer, tmp);
                answer = tmp;
                rt = tmp - 1;
            }
        }
        return String.valueOf(answer);
    }

    private static int countDvd(int n, int expected, int[] arr) {
        int cnt = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
//            if (sum >= expected) {
//                cnt++;
//                if (sum == expected) sum = 0;
//                else sum = arr[i];
//            }
            if (sum > expected) {
                sum = arr[i];
                cnt++;
            }
            System.out.println("arr[i] = " + arr[i] + ", cnt = " + cnt + ", sum = " + sum);
        }
//        if (sum > 0 && sum < expected) cnt++;
        return cnt;
    }


    public static void main(String[] args) throws IOException {
        Q09 main = new Q09();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        stdOut.write(main.goatJYP(n, m, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
