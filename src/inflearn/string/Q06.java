package inflearn.string;

import java.io.*;

/**
 * 6. 중복문자제거
 */
public class Q06 {

    public String removeDuplicateLetters(String word) {
        String answer = "";
        char[] arr = word.toCharArray();
        for (char c : arr) {
            if (!answer.contains(Character.toString(c))) answer += c;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q06 main = new Q06();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = stdIn.readLine();

        stdOut.write(main.removeDuplicateLetters(word));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
