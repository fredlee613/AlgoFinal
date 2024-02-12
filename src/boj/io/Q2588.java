package boj.io;

import java.io.*;

public class Q2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        int top = Integer.parseInt(stdIn.readLine());
        String bottomStr = stdIn.readLine();
        int[] bottom = new int[3];

        for (int i = 0; i < 3; i++) bottom[i] = Integer.parseInt(String.valueOf(bottomStr.charAt(i)));

        int sum = 0;
        for (int i = bottom.length - 1; i >= 0; i--) {
            stdOut.write((top * bottom[i]) + "\n");
            sum += (int) (top * bottom[i] * Math.pow(10, bottom.length - 1 - i));
        }
        stdOut.write(String.valueOf(sum));

        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
