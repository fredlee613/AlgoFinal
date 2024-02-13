package boj.string;

import java.io.*;

public class Q2743 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        stdOut.write(String.valueOf(stdIn.readLine().length()));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
