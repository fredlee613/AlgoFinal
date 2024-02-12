package boj.io;

import java.io.*;
import java.util.StringTokenizer;

public class Q1008 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

        stdOut.write(String.valueOf(a + b) + "\n");
        stdOut.write(String.valueOf(a - b) + "\n");
        stdOut.write(String.valueOf(a * b) + "\n");
        stdOut.write(String.valueOf(a / b) + "\n");
        stdOut.write(String.valueOf(a % b));

        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
