package inflearn.stackqueue;

import java.io.*;
import java.util.Stack;

/**
 * 5. 쇠막대기
 */
public class Q05 {
    public String cuttingRebars(String str) {
        int answer = 0;
        int cnt = 0;
        char[] arr = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') stack.push(arr[i]);
            else {
                if (arr[i - 1] == '(') { // 레이저 발사 => 레이저 이전 ( 개수만큼 잘린다.
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop(); // 막대기의 끝이기에 pop 해줘야한다.
                    answer += 1;
                }
            }
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException{
        Q05 main = new Q05();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = stdIn.readLine();

        stdOut.write(main.cuttingRebars(str));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
