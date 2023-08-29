package inflearn.string;

import java.io.*;
import java.util.Locale;

/**
 * 7. 회문 문자열
 */
public class Q07 {

    public String isPalindrome(String word) {
        char[] arr = word.toUpperCase(Locale.ROOT).toCharArray();
        for (int i = 0; i < word.length() / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) throws IOException {
        Q07 main = new Q07();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = stdIn.readLine();

        stdOut.write(main.isPalindrome(word));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
