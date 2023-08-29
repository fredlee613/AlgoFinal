package inflearn.string;

import java.io.*;
import java.util.Arrays;
import java.util.Locale;

/**
 * 9. 숫자만 추출
 */
public class Q09 {

    public String extractNumber(String word) {
        char[] arr = word.toUpperCase(Locale.ROOT).replaceAll("[^0-9]", "").toCharArray();
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
           answer = answer * 10 + Character.getNumericValue(arr[i]);
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Q09 main = new Q09();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = stdIn.readLine();

        stdOut.write(main.extractNumber(word));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
