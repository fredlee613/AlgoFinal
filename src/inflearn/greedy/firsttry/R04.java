package inflearn.greedy.firsttry;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 4. 최대 수입 스케쥴(PriorityQueue 응용문제)
 */
public class R04 {
    static class Lecture implements Comparable<Lecture>{
        int wage;
        int date;
        public Lecture(int wage, int date) {
            this.wage = wage;
            this.date = date;
        }

        @Override
        public int compareTo(Lecture o) {
            return this.date - o.date;
        }
    }

    static ArrayList<Lecture> lectures = new ArrayList<>();
    static int n, max = Integer.MIN_VALUE;

    public String scheduleLectures() {
        int totalWage = 0;
        Collections.sort(lectures, Collections.reverseOrder());
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0; // j를 따로 선언하는 이유는 j가 매번 처음부터 도는 것이 아니기 때문.
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (lectures.get(j).date < i) break;
                pQ.offer(lectures.get(j).wage);
            }
            if (!pQ.isEmpty()) totalWage += pQ.poll();
        }
        return String.valueOf(totalWage);
    }

    public static void main(String[] args) throws IOException {
        R04 main = new R04();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(stdIn.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            int wage = Integer.parseInt(st.nextToken());
            int date = Integer.parseInt(st.nextToken());
            if (date > max) max = date;
            lectures.add(new Lecture(wage, date));
        }

        stdOut.write(main.scheduleLectures());
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
