package inflearn.stackqueue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 6. 공주 구하기
 */
public class Q06 {
    public String saveSukyoung(int n, int k) {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) queue.offer(i + 1);
        while (queue.size() != 1) {
            Integer cp = queue.poll();
            cnt++;
            if (cnt != k)queue.offer(cp); // k가 아닐경우 왕자 복귀
            else cnt = 0; // k일 경우 왕자 퇴출 후 카운트 초기화
        }
        return String.valueOf(queue.poll());
    }

    public static void main(String[] args) throws IOException{
        Q06 main = new Q06();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        stdOut.write(main.saveSukyoung(n, k));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
