package boj.mapandset;

import java.io.*;
import java.util.*;

/**
 * 회사에 있는 사람
 */
public class Q7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> remains = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            String person = st.nextToken();
            String event = st.nextToken();
            if (event.equals("enter")) map.put(person, map.getOrDefault(person, 0) + 1);
            else map.put(person, map.getOrDefault(person, 0) - 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) remains.add(entry.getKey());
        }
        Collections.sort(remains, Collections.reverseOrder());
        for (int i = 0; i < remains.size(); i++) {
            stdOut.write(remains.get(i));
            if (i != remains.size() - 1) stdOut.write("\n");
        }
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
