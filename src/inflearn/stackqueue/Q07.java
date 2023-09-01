package inflearn.stackqueue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 7. 교육과정 설계
 */
public class Q07 {
    public String instructionDesign(String rule, String plan) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : rule.toCharArray()) queue.offer(c);
        for (char c : plan.toCharArray()) {
            if (queue.contains(c) && queue.peek() == c) queue.poll();
        }
        if (queue.size() != 0) return "NO";

        return "YES";
    }

    public static void main(String[] args) throws IOException{
        Q07 main = new Q07();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        String rule = stdIn.readLine();
        String plan = stdIn.readLine();
        stdOut.write(main.instructionDesign(rule, plan));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
