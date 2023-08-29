package inflearn.string;

import java.io.*;

/**
 * 3. 문장 속 단어
 */
public class Q03 {
    public String findLongestWord(String word) {
        int rt = 0;
        int length = Integer.MIN_VALUE;
        String answer = "";
        while (word.contains(" ")) {
            rt = word.indexOf(" ");
            if (rt > length) {
                length = rt;
                answer = word.substring(0, rt);
            }
            word = word.substring(rt + 1);
        }

        if (word.length() != 0) {
            int tmp = word.length();
            if (tmp > length) answer = word;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q03 main = new Q03();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = stdIn.readLine();

        stdOut.write(main.findLongestWord(word));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
