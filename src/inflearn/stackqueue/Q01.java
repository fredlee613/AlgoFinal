package inflearn.stackqueue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 올바른 괄호
 */
public class Q01 {

    public String isProperBracket(String str) {
        Queue<Character> queue = new LinkedList<>();
        char[] arr = str.toCharArray();
        for (char c : arr) {
            if (c == '(') queue.offer(c); // 괄호를 여는 경우 큐에 추가
            else { // 괄호를 닫는 경우
                if (queue.isEmpty()) return "NO"; // 열린 괄호가 없을 경우 "NO" 반환
                else queue.poll(); // 있을 경우 열린 괄호 제거
            }
        }
        if (!queue.isEmpty()) return "NO"; // 남은 열린 괄호가 있을 경우 "NO" 반환
        return "YES";
    }

    public static void main(String[] args) throws IOException{
        Q01 main = new Q01();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String str = stdIn.readLine();

        stdOut.write(main.isProperBracket(str));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
