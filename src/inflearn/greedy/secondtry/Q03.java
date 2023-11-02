package inflearn.greedy.secondtry;

import java.io.*;
import java.util.*;

public class Q03 {
    static class Guest implements Comparable<Guest>{
        int event; // 0 for out, 1 for in
        int time;

        public Guest (int event, int time) {
            this.event = event;
            this.time = time;
        }

        @Override
        public int compareTo(Guest g) {
            if (this.time == g.time) return this.event - g.event;
            else return this.time - g.time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine()), answer = Integer.MIN_VALUE;
        ArrayList<Guest> guests = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            guests.add(new Guest(1, Integer.parseInt(st.nextToken())));
            guests.add(new Guest(0, Integer.parseInt(st.nextToken())));
        }
        Collections.sort(guests);
        int tmp = 0;
        for (Guest guest : guests) {
            if (guest.event == 1) tmp++;
            else tmp--;
            answer = Math.max(answer, tmp);
        }
        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
