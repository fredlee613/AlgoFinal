package boj.bit;

import java.io.*;

public class Q11966 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());
        boolean flag = false;
        for (int i = 0; i < 31; i++) {
            if (n == (1 << i)) flag = true;
        }
        if (flag) stdOut.write(String.valueOf(1));
        else stdOut.write(String.valueOf(0));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
