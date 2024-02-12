package boj.io;

import java.io.*;
import java.util.StringTokenizer;

public class Q11382 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        Long sum = 0L;
        for (int i = 0; i < 3; i++) sum += Long.parseLong(st.nextToken());
        stdOut.write(String.valueOf(sum));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
