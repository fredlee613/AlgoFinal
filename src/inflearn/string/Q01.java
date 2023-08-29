package inflearn.string;

import java.io.*;

/**
 * 1. 문자 찾기
 */
public class Q01 {
    public String findLetter(String word, char letter) {
        char[] wordArr = word.toCharArray();
        int n = 0, answer = 0;
        while (n <= wordArr.length - 1) {
            if (Character.toUpperCase(wordArr[n]) == Character.toUpperCase(letter)) {
                answer++;
            }
            n++;
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Q01 main = new Q01();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = stdIn.readLine();
        char letter = stdIn.readLine().charAt(0);

        stdOut.write(main.findLetter(word, letter));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
