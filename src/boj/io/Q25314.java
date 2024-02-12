package boj.io;

import java.io.*;

public class Q25314 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(stdIn.readLine()) / 4;
        for (int i = 0; i < num; i++) stdOut.write("long ");
        stdOut.write("int");
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
