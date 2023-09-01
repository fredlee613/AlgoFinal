package inflearn.hashmap;

import java.io.*;
import java.util.*;

/**
 * 5. K번째 큰 수
 */
public class Q05 {
    public String findKthBiggestNumber(int n, int k, int[] arr) {
        int answer = -1;
        HashSet<Integer> set = new HashSet<>();
        for (int x = 0; x < n; x++) {
            for (int y = x+1; y < n; y++) {
                for (int z = y+1; z < n; z++) {
                    if (x != y && y != z && z != x) {
                        int sum = arr[x] + arr[y] + arr[z];
                        set.add(sum);
                    }
                }
            }
        }
        Integer[] intArr = set.toArray(new Integer[0]);
        Arrays.sort(intArr, Collections.reverseOrder());
        if (intArr.length >= k) answer = intArr[k - 1];
        return String.valueOf(answer);
    }

    public String findNumberByUsingTreeSet(int n, int k, int[] arr) {
        int answer = -1;
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
        for (int x = 0; x < n; x++) {
            for (int y = x+1; y < n; y++) {
                for (int z = y+1; z < n; z++) {
                    if (x != y && y != z && z != x) {
                        int sum = arr[x] + arr[y] + arr[z];
                        treeSet.add(sum);
                    }
                }
            }
        }
        int cnt = 0;
        for (Integer integer : treeSet) {
            cnt++;
            if (cnt == k) {
                answer = integer;
                break;
            }
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Q05 main = new Q05();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        stdOut.write(main.findKthBiggestNumber(n, k, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
