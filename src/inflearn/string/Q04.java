package inflearn.string;

import java.io.*;

/**
 * 4. 단어 뒤집기
 */
public class Q04 {
    public void solution(int n, String[] words) {
        convertWords(n, words);
    }

    private void convertWords(int n, String[] words) {
        for (int i = 0; i < n; i++) {
            char[] charArray = words[i].toCharArray();
            for (int j = 0; j < charArray.length / 2; j++) {
                char tmp = charArray[j];
                charArray[j] = charArray[charArray.length - 1 - j];
                charArray[charArray.length - 1 - j] = tmp;
            }
            words[i] = new String(charArray);
        }
    }

    public static void main(String[] args) throws IOException {
        Q04 main = new Q04();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(stdIn.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) words[i] = stdIn.readLine();
        main.solution(n, words);

        for (int i = 0; i < n; i++) {
            String tmp = words[i];
            if (i != n - 1) {
                tmp += "\n";
            }
            stdOut.write(tmp);
        }
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
