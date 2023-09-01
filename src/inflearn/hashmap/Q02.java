package inflearn.hashmap;

import java.io.*;
import java.util.HashMap;

/**
 * 2. 아나그램(해쉬)
 */
public class Q02 {
    public String isAnagram(String actual, String expected) {
        char[] actArr = actual.toCharArray();
        char[] expArr = expected.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : actArr) map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : expArr) {
            if (!map.containsKey(c)||map.get(c) == 0) return "NO";
            else map.put(c, map.get(c) - 1);
        }

        return "YES";
    }

    public static void main(String[] args) throws IOException {
        Q02 main = new Q02();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        String actual = stdIn.readLine();
        String expected = stdIn.readLine();

        stdOut.write(main.isAnagram(actual, expected));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
