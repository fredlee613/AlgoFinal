package boj.io;

import java.io.*;

public class Q18108 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        stdOut.write(String.valueOf(Integer.parseInt(stdIn.readLine()) - 543));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
