package boj.string;

import java.io.*;

public class Q27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = stdIn.readLine();
        int idx = Integer.parseInt(stdIn.readLine());
        stdOut.write(word.charAt(idx - 1));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
