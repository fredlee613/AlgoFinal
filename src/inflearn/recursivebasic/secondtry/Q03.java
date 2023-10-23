package inflearn.recursivebasic.secondtry;

import java.io.*;

public class Q03 {

    static int Recursive(int N) {
        if (N == 1) return 1;
        else return N * Recursive(N - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(String.valueOf(Recursive(Integer.parseInt(stdIn.readLine()))));
        stdOut.close();
        stdIn.close();
    }
}
