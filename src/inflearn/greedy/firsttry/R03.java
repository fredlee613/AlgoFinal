package inflearn.greedy.firsttry;

import java.io.*;
import java.util.*;

/**
 * 3. 결혼식
 */
public class R03 {
    static class Visitor implements Comparable<Visitor>{
        int time;
        String type;

        public Visitor(int time, String type) {
            this.time = time;
            this.type = type;
        }


        @Override
        public int compareTo(Visitor o) {
            if (this.time != o.time)return this.time - o.time;
            else {
                if (this.type == o.type) return 0;
                else if (this.type == "out") return -1;
                else return 1;
            }
        }

        @Override
        public String toString() {
            return "(" + time + ", " + type + ")";
        }
    }

    public String countVisitors(ArrayList<Visitor> visitors) {
        int answer = 0, cnt = 0;
        Collections.sort(visitors);
//        System.out.println("visitors = " + visitors);
        for (Visitor visitor : visitors) {
            if (visitor.type == "in") {
                cnt++;
            } else {
                cnt--;
            }
            answer = Math.max(answer, cnt);
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        R03 main = new R03();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(stdIn.readLine());
        ArrayList<Visitor> visitors = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            visitors.add(new Visitor(Integer.parseInt(st.nextToken()), "in"));
            visitors.add(new Visitor(Integer.parseInt(st.nextToken()), "out"));
        }

        stdOut.write(main.countVisitors(visitors));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
