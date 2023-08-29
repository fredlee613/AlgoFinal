package inflearn.string;

import java.io.*;

/**
 * 2. 대소문자 변환
 */
public class Q02 {
    public String convertCase(String word) {
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(wordArr[i])) wordArr[i] = Character.toLowerCase(wordArr[i]);
            else wordArr[i] = Character.toUpperCase(wordArr[i]);
        }
        return new String(wordArr);
    }

    public static void main(String[] args) throws IOException {
        Q02 main = new Q02();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = stdIn.readLine();

        stdOut.write(main.convertCase(word));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
