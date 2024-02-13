package boj.array;

import java.io.*;

public class Q5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] list = new int[31];
        int[] noList = new int[2];
        for (int i = 0; i < 28; i++) {
            list[Integer.parseInt(stdIn.readLine())] = 1;
        }
        int idx = 0;
        for (int i = 1; i <= 30; i++) {
            if (list[i] == 0) {
                if (idx > 0) {
                    if (i < noList[0]) {
                        int tmp = noList[0];
                        noList[idx] = tmp;
                        noList[0] = i;
                    } else {
                        noList[idx] = i;
                    }
                } else {
                    noList[idx] = i;
                }
                idx++;
            }
        }
        stdOut.write(noList[0] + "\n" + noList[1]);
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
