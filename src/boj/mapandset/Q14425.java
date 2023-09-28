package boj.mapandset;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 문자열 집합
 */
public class Q14425 {
    static String[] words;

    static int binarySearch(String key, int low, int high) {
        int mid;
        if (low <= high) {
            mid = (low + high) / 2;
            if (words[mid].equals(key)) return 1;
            else if (words[mid].compareTo(key) < 0) return binarySearch(key, mid + 1, high);
            else return binarySearch(key, low, mid - 1);
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        words = new String[n];
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(stdIn.readLine());
        words = set.toArray(new String[0]);
        Arrays.sort(words);
        int answer = 0;
        for (int i = 0; i < m; i++) answer += binarySearch(stdIn.readLine(), 0, words.length - 1);
        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
