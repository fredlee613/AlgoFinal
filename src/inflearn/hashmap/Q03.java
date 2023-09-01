package inflearn.hashmap;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 3. 매출액의 종류
 */
public class Q03 {
    public ArrayList<Integer> findKindsOfSales(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        answer.add(map.size());
        for (int i = 0; i < n - k; i++) {
            // 첫항 제거
            if (map.get(arr[i]) == 1) map.remove(arr[i]); // 1개 밖에 없을 경우 제거
            else map.put(arr[i], map.get(arr[i]) - 1); // 2개 이상일 경우 개수 감소
            // 끝항 추가
            map.put(arr[i + k], map.getOrDefault(arr[i + k], 0) + 1);

            answer.add(map.size());
            // 기존의 코드는 자료구조를 사용하지 않았음 => time exceed! 뜸
            // 문자열 연산보다는 자료구조를 활용한 후 출력하는 방식을 이용하자
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q03 main = new Q03();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        ArrayList<Integer> kindsOfSales = main.findKindsOfSales(n, k, arr);
        for (Integer kindsOfSale : kindsOfSales) {
            stdOut.write(kindsOfSale + " ");
        }

        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
