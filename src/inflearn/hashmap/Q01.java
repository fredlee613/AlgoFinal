package inflearn.hashmap;

import java.io.*;
import java.util.HashMap;

/**
 * 1. 학급 회장(해쉬)
 */
public class Q01{
    public String selectCaptain(int n, String str) {
        String answer = "";
        char[] arr = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (Character key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = Character.toString(key);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q01 main = new Q01();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(stdIn.readLine());
        String str = stdIn.readLine();

        stdOut.write(main.selectCaptain(n, str));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
