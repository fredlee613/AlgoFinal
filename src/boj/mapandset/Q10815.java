package boj.mapandset;

import java.io.*;
import java.util.*;

/**
 * 숫자 카드
 */
public class Q10815 {
    static Integer[] hand;

    static int binarySearch(int key, int low, int high) {
        int mid;
        if (low <= high) {
            mid = (low + high) / 2;
            if (hand[mid] == key) return 1;
            else if (hand[mid] > key) return binarySearch(key, low, mid - 1);
            else return binarySearch(key, mid + 1, high);
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(stdIn.readLine());
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) set.add(Integer.parseInt(st.nextToken()));

        hand = set.toArray(new Integer[n]);
        Arrays.sort(hand);

        int m = Integer.parseInt(stdIn.readLine());
        st = new StringTokenizer(stdIn.readLine());
        Integer[] answer = new Integer[m];
        for (int i = 0; i < m; i++) {
            answer[i] = binarySearch(Integer.parseInt(st.nextToken()), 0, hand.length - 1);
        }
        for (int i = 0; i < m; i++) {
            String tmp = String.valueOf(answer[i]);
            if (i != m - 1) tmp += " ";
            stdOut.write(tmp);
        }
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
