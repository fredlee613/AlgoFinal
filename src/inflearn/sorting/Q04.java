package inflearn.sorting;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 4. Least Recently Used
 */
public class Q04 {

    public int[] lru(int n, int s, int[] arr) {
        int[] works = new int[s];
        for (int i = 0; i < s; i++) works[i] = arr[i];
        for (int x = s; x < n; x++) {
            int currentWork = arr[x];
            for (int y = indexOfCurrentWork(currentWork, works); y >= 1; y--) {
                works[y] = works[y - 1];
            }
            works[0] = currentWork;
        }
        return works;
    }

    private static int indexOfCurrentWork(int currentWork, int[] works) {
        for (int i = 0; i < works.length; i++) if (currentWork == works[i]) return i;
        return works.length - 1;
    }

    public static void main(String[] args) throws IOException {
        Q04 main = new Q04();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int i : main.lru(n, s, arr)) {
            stdOut.write(i + " ");
        }
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
