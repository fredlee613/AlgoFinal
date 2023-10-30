package inflearn.greedy.secondtry;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q02 {
    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) return this.start - o.start;
            else return this.end - o.end;
        }

        @Override
        public String toString() {
            return "[start: " + this.start + ", end: " + this.end + "]";
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        PriorityQueue<Meeting> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            int tmpStart = Integer.parseInt(st.nextToken());
            int tmpEnd = Integer.parseInt(st.nextToken());

            pq.offer(new Meeting(tmpStart, tmpEnd));
        }
        int tmp = Integer.MIN_VALUE, cnt = 0;
        while (!pq.isEmpty()) {
            Meeting cm = pq.poll();
            if (cm.start >= tmp) {
                tmp = cm.end;
                cnt++;
            }
        }
        stdOut.write(String.valueOf(cnt));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
