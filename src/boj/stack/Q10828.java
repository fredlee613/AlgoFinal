package boj.stack;

import java.io.*;
import java.util.Stack;

public class Q10828 {
    static Stack<Integer> stack = new Stack<>();
    static void push(Integer x) {
        stack.push(x);
    }

    static Integer pop() {
        if (stack.isEmpty()) return -1;
        else return stack.pop();
    }

    static Integer size() {
        return stack.size();
    }

    static Integer empty() {
        return stack.isEmpty() ? 1 : 0;
    }

    static Integer top() {
        if (stack.isEmpty()) return -1;
        else return stack.peek();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = stdIn.readLine().split(" ");
            if ("push".equals(input[0])) {
                push(Integer.parseInt(input[1]));
            } else if ("pop".equals(input[0])) {
                stdOut.write(String.valueOf(pop()));
                if (i != n -1 )stdOut.write("\n");
            } else if ("size".equals(input[0])) {
                stdOut.write(String.valueOf(size()));
                if (i != n -1 )stdOut.write("\n");
            } else if ("empty".equals(input[0])) {
                stdOut.write(String.valueOf(empty()));
                if (i != n -1 )stdOut.write("\n");
            } else {
                stdOut.write(String.valueOf(top()));
                if (i != n -1 )stdOut.write("\n");
            }
        }

        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
