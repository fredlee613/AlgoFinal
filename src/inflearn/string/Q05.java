package inflearn.string;

import java.io.*;

/**
 * 5. 특정 문자 뒤집기
 */
public class Q05 {

    public String convertCertainWords(String word) {
        char[] arr = word.toCharArray();
        int lt = 0, rt = arr.length - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(arr[lt])) lt++;
            else if (!Character.isAlphabetic(arr[rt])) rt--;
            else {
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt++;
                rt--;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) throws IOException {
        Q05 main = new Q05();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = stdIn.readLine();

        stdOut.write(main.convertCertainWords(word));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
