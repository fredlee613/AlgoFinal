package boj.io;

import java.io.*;
import java.util.StringTokenizer;

public class Q10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken());
        stdOut.write(String.valueOf((arr[0] + arr[1]) % arr[2]) + "\n");
        stdOut.write(String.valueOf( ((arr[0] % arr[2]) + (arr[1] % arr[2])) % arr[2]) + "\n");
        stdOut.write(String.valueOf( (arr[0] * arr[1]) % arr[2]) + "\n");
        stdOut.write(String.valueOf(((arr[0]%arr[2]) * (arr[1] % arr[2])) % arr[2]));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
