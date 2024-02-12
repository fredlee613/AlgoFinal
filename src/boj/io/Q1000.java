package boj.io;

import java.io.*;
import java.util.StringTokenizer;

public class Q1000 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int answer = 0;
        for (int i = 0; i < 2; i++) answer += Integer.parseInt(st.nextToken());
        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
