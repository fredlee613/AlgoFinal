package inflearn.stackqueue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 2. 괄호문자제거
 */
public class Q02 {

    public String removeWordsWithBrackets(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        char[] arr = str.toCharArray();
        for (char c : arr) {
            if (c == ')') { // 열린 괄호가 나올때 까지 poll
                while (true){
                    if (stack.pop() == '(') {
                        break;
                    }
                }
            } else stack.push(c); // 아닐 경우 offer
        }
        for (Character character : stack) {
            answer += Character.toString(character);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException{
        Q02 main = new Q02();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String str = stdIn.readLine();

        stdOut.write(main.removeWordsWithBrackets(str));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
