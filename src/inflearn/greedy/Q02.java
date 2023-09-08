package inflearn.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 2. 회의실 배정
 */
public class Q02 {
    static int n;
    static int[] ch;
    static Meeting[] meetings;
    static int answer = Integer.MIN_VALUE;

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) return this.start - o.start;
            else return this.end - o.end;
        }
    }

//    void DFS(int L) {
//        if (L == n) {
////            System.out.println("ch = " + Arrays.toString(ch));
//            int cnt = Integer.MIN_VALUE;
//            ArrayList<Meeting> list = new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                if (ch[i] == 1) list.add(meetings[i]);
//            }
//            for (Meeting meeting : list) {
////                System.out.print(meeting + " ");
//            }
////            System.out.println();
//
//            if (list.size() > 0) {
//                if (list.size() == 1) cnt = 1;
//                else {
//                    boolean flag = true;
//                    for (int i = 0; i < list.size() - 1; i++) {
//                        if (list.get(i).end > list.get(i + 1).start) {
//                            flag = false;
//                            break;
//                        }
//                    }
////                    System.out.println("flag = " + flag);
//                    if (flag) cnt = list.size();
//                }
//            }
//            answer = Math.max(answer, cnt);
////            System.out.println("cnt = " + cnt + ", answer = " + answer);
//        } else {
//            ch[L] = 1;
//            DFS(L + 1);
//            ch[L] = 0;
//            DFS(L + 1);
//        }
//
//    }


    public static void main(String[] args) throws IOException {
        Q02 main = new Q02();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(stdIn.readLine());
        meetings = new Meeting[n];
        ch = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(meetings);
//        System.out.println("meetings = " + Arrays.toString(meetings));
        int et = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (meetings[i].start >= et) {
//                System.out.println("meetings[i].start = " + meetings[i].start + ", et = " + et);
                cnt++;
                et = meetings[i].end;
            }
        }

//        main.DFS(0);
        stdOut.write(String.valueOf(cnt));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }

}
