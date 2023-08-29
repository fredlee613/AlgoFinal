package boj.string;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 단어 정렬
 */
public class Q1181 {

    public String[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        List<String> collect = set.stream().collect(Collectors.toList());
        words = collect.toArray(new String[0]);
        sortWords(words);
        return words;
    }

    private static void sortWords(String[] words) {
        for (int x = 0; x < words.length; x++) {
            int idx = x;
            for (int y = x + 1; y < words.length; y++) {
                if (words[y].length() < words[idx].length()) idx = y;
                if (words[y].length() == words[idx].length()) {
                    for (int z = 0; z < words[idx].length(); z++) {
                        if (words[y].charAt(z) < words[idx].charAt(z)) {
                            idx = y;
                            break;
                        }
                        if (words[y].charAt(z) > words[idx].charAt(z)) break;
                    }
                }
            }
            if (idx != x) {
                String tmp = words[x];
                words[x] = words[idx];
                words[idx] = tmp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Q1181 main = new Q1181();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());
        String[] words = new String[n];

        for (int i = 0; i < n; i++) words[i] = stdIn.readLine();
        String[] answer = main.solution(n, words);
        for (int i = 0; i < answer.length; i++) {
            String tmp = answer[i];
            if (i != answer.length - 1) tmp += "\n";
            stdOut.write(tmp);
        }
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
