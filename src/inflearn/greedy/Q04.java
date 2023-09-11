package inflearn.greedy;

import java.io.*;
import java.util.*;

/**
 * 4. 최대 수입 스케쥴(PriorityQueue 응용문제)
 */
public class Q04 {
    static int max = Integer.MIN_VALUE, n;

    static class Lecture implements Comparable<Lecture> {
        int pay;
        int date;

        public Lecture(int pay, int date) {
            this.pay = pay;
            this.date = date;
        }

        @Override
        public String toString() {
            return "pay = " + this.pay + ", date = " + this.date;
        }

        @Override
        public int compareTo(Lecture o) {
            return this.date - o.date;
        }
    }

    public String findMaxWage(ArrayList<Lecture> lectures) {
        int wage = 0;
        Collections.sort(lectures, Collections.reverseOrder());
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (lectures.get(j).date < i) break;
                pQ.offer(lectures.get(j).pay);
            }
            if (!pQ.isEmpty()) wage += pQ.poll();
        }
        return String.valueOf(wage);
    }


    public static void main(String[] args) throws IOException {
        Q04 main = new Q04();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(stdIn.readLine());
        ArrayList<Lecture> lectures = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int date = Integer.parseInt(st.nextToken());
            if (date > max) max = date;
            lectures.add(new Lecture(pay, date));
        }
        stdOut.write(main.findMaxWage(lectures));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
