package inflearn.string;

import java.io.*;
import java.util.Locale;

/**
 * 8. 유효한 팰린드롬
 */
public class Q08 {

    public String isCertainPalindrome(String word) {
        char[] arr = word.toUpperCase(Locale.ROOT).toCharArray();
        int lt = 0, rt = arr.length - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(arr[lt])) lt++;
            else if(!Character.isAlphabetic(arr[rt])) rt--;
            else {
                if (arr[lt] != arr[rt]) {
                    return "NO";
                }
                lt++;
                rt--;
            }
        }
        return "YES";
    }

    public String isCertainPalindromeRegex(String word) {
        char[] arr = word.toUpperCase(Locale.ROOT).replaceAll("[^a-zA-Z]", "").toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) throws IOException {
        Q08 main = new Q08();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = stdIn.readLine();

        stdOut.write(main.isCertainPalindromeRegex(word));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
