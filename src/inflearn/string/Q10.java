package inflearn.string;

import java.io.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * 10. 가장 짧은 문자거리
 */
public class Q10 {

    public String shortestDistanceBetweenLetters(String s, char t) {
        String answer = "";
        int[] ch = new int[s.length()];
        for (int i = 0; i < s.length(); i++) ch[i] = 101;
        s = s.toUpperCase(Locale.ROOT);
        t = Character.toUpperCase(t);
        char[] arr = s.toCharArray();
        int idx = -1;
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == t) {
                ch[i] = 0;
                idx = i;
            } else if (idx != -1){
                ch[i] = i - idx;
            }
        }
        idx = arr.length;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (arr[i] == t) {
                ch[i] = 0;
                idx = i;
            } else if (idx != arr.length){
                ch[i] = Math.min(ch[i], idx - i);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) answer += ch[i] + " ";
            else answer += String.valueOf(ch[i]);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q10 main = new Q10();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        String s = st.nextToken();
        char t = st.nextToken().charAt(0);

        stdOut.write(main.shortestDistanceBetweenLetters(s, t));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
