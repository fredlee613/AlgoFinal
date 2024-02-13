package boj.string;

import java.io.*;

public class Q9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());
        for (int i = 0; i < n; i++) {
            String tmp = stdIn.readLine();
            stdOut.write(String.valueOf(tmp.charAt(0)) + String.valueOf(tmp.charAt(tmp.length() - 1)));
            if (i != n - 1) stdOut.write("\n");
        }
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
