package inflearn.greedy.firsttry;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 3. 결혼식
 */
public class Q03 {
    static class Visitor implements Comparable<Visitor>{
        int in;
        int out;

        public Visitor(int in, int out) {
            this.in = in;
            this.out = out;
        }


        @Override
        public int compareTo(Visitor o) {
            if (this.out == o.out) return this.in - o.in;
            else return this.out - o.out;
        }

        @Override
        public String toString() {
            return "in = " + this.in + ", out = " + this.out;
        }
    }

    public String countVisitors(int n, Visitor[] visitors) {
        Queue<Visitor> q = new LinkedList<>();
        int cnt = 0;
        Arrays.sort(visitors);
//        System.out.println("visitors = " + Arrays.toString(visitors));
        for (int i = 0; i < n; i++) {
            int tmp = cnt;
            Visitor visitor = visitors[i];
            tmp++;
            if (!q.isEmpty()) {
//                System.out.println("time to leave, size = " + q.size());
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    if (q.peek().out <= visitor.in) {
                        q.poll();
                        tmp--;
                    }
                }
            }
            q.offer(visitor);
//            System.out.println("tmp = " + tmp);
            cnt = Math.max(cnt, tmp);
        }
        return String.valueOf(cnt);
    }

    public static void main(String[] args) throws IOException {
        Q03 main = new Q03();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(stdIn.readLine());
        Visitor[] visitors = new Visitor[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            visitors[i] = new Visitor(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        stdOut.write(main.countVisitors(n, visitors));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
