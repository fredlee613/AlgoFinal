package inflearn.stackqueue;

import java.io.*;
import java.util.Stack;

/**
 * 4. 후위식 연산(postfix)
 */
public class Q04 {
    public String postfix(String str) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) stack.push(Character.getNumericValue(c));
            else {
                int rt = stack.pop();
                int lt = stack.pop();
                if (c == '+') {
                    stack.push(lt + rt);
                } else if (c == '-') {
                    stack.push(lt - rt);
                } else if (c == '*') {
                    stack.push(lt * rt);
                } else {
                    stack.push(lt / rt);
                }
            }

        }
        return String.valueOf(stack.pop());
    }

    public static void main(String[] args) throws IOException{
        Q04 main = new Q04();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = stdIn.readLine();

        stdOut.write(main.postfix(str));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
