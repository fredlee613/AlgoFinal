package inflearn.stackqueue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 8. 응급실
 */
public class Q08 {

    static class Patient {
        int order;
        int priority;

        public Patient(int order, int priority) {
            this.order = order;
            this.priority = priority;
        }
    }

    public String emergencyRoom(int n, int k, Queue<Patient> queue) {
        int answer = 0, cnt = 0;
        while (!queue.isEmpty()) {
            Patient cp = queue.poll();
            boolean isMostUrgent = true;
            for (Patient patient : queue) {
                if (cp.priority < patient.priority) isMostUrgent = false;
            }
            if (isMostUrgent) {
                cnt++;
                if (cp.order == k) break;
            } else {
                queue.offer(cp);
            }
        }
        return String.valueOf(cnt);
    }

    public static void main(String[] args) throws IOException{
        Q08 main = new Q08();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Patient> queue = new LinkedList<>();
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) {
            queue.offer(new Patient(i, Integer.parseInt(st.nextToken())));
        }

        stdOut.write(main.emergencyRoom(n, k, queue));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
