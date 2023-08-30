package inflearn.array;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 3. 가위 바위 보
 */
public class Q03 {
    public String rockScissorsPaper(int n, int[] a, int[] b) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            int tmpA = a[i];
            int tmpB = b[i];
            if (tmpA == 1 && tmpB == 3) answer += "A";
            else if (tmpA == 2 && tmpB == 1) answer += "A";
            else if (tmpA == 3 && tmpB == 2) answer += "A";
            else if (tmpA == tmpB) answer += "D";
            else answer += "B";
            if (i != n - 1) answer += "\n";
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q03 main = new Q03();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(stdIn.readLine());
        int[] a = new int[n];
        int[] b = new int[n];

        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) b[i] = Integer.parseInt(st.nextToken());

        stdOut.write(main.rockScissorsPaper(n, a, b));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
