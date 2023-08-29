package inflearn.string;

import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * 11. 문자열 압축
 */
public class Q11 {

    public String stringCompression(String string) {
        String answer = "";
        char[] arr = string.toCharArray();
        char tmpChar = arr[0];
        int tmpInt = 1;

        for (int i = 1; i < arr.length; i++) {
            if (tmpChar == arr[i]) tmpInt += 1;
            else {
                answer += Character.toString(tmpChar);
                if (tmpInt != 1) answer += tmpInt;
                tmpChar = arr[i];
                tmpInt = 1;
            }
        }
        answer += Character.toString(tmpChar);
        if (tmpInt != 1) answer += tmpInt;
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q11 main = new Q11();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        stdOut.write(main.stringCompression(stdIn.readLine()));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
