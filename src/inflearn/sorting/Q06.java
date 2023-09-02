package inflearn.sorting;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 6. 장난꾸러기
 */
public class Q06 {

    public String weLoveCheolsu(int n, int[] arr) {
        String answer = "";
        // 뒤에 애보다 큰 애가 우리 철수지라
        // 앞에 애보다 작은 친구가 우리 철수 짝궁이지라
        // 짝궁부터 구한다. 그리고 배열을 탐색하며 짝궁보다 큰 첫번째 친구가 바로 우리의 철수!
        // 이제 선생님 속 썩이지 말고 행복해야한다~!
        int partner = 0;
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                partner = i;
                break;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[partner]) {
                answer += String.valueOf(i+1);
                break;
            }
        }

        answer += " " + (partner + 1);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q06 main = new Q06();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        stdOut.write(main.weLoveCheolsu(n, arr));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
