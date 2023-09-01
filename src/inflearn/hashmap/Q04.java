package inflearn.hashmap;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 4. 모든 아나그램 찾기
 */
public class Q04 {
    public String findAllAnagrams(String actual, String expected) {
        int answer = 0;
        int n = actual.length(), k = expected.length();
        for (int i = 0; i < n - k + 1; i++) {
//            System.out.println("actual.substring(" + i + ", " + (i + k) + ") = " + actual.substring(i, i + k));
            if (isAnagram(actual.substring(i, i + k), expected)) answer++;
        }


        return String.valueOf(answer);
    }

    private static boolean isAnagram(String actual, String expected) {
        char[] actArr = actual.toCharArray();
        char[] expArr = expected.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : actArr) map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : expArr) {
            if (!map.containsKey(c) || map.get(c) == 0) return false;
            else map.put(c, map.get(c) - 1);
        }
//        System.out.println("actual = " + actual);
        return true;
    }

    public static void main(String[] args) throws IOException {
        Q04 main = new Q04();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        String actual = stdIn.readLine();
        String expected = stdIn.readLine();
        stdOut.write(main.findAllAnagrams(actual, expected));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
