package inflearn.greedy.secondtry;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q04 {
    static class Lecture implements Comparable<Lecture>{
        int wage;
        int day;

        public Lecture(int wage, int day) {
            this.wage = wage;
            this.day = day;
        }

        @Override
        public int compareTo(Lecture lecture) {
            return this.day - lecture.day;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(stdIn.readLine());
        ArrayList<Lecture> lectures = new ArrayList<>();
        int MAX = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            int wage = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(wage, day));
            MAX = Math.max(MAX, day);
        }

        lectures.sort(Collections.reverseOrder());
        int answer = 0, j = 0;
        PriorityQueue<Integer> wages = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = MAX; i >= 1; i--) {
            for (; j < n; j++) {
                if (lectures.get(j).day < i) break;
                wages.offer(lectures.get(j).wage);
            }
            if (!wages.isEmpty()) answer += wages.poll();
        }

        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
