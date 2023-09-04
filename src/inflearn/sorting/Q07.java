package inflearn.sorting;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 7. 좌표 정렬
 */
public class Q07 {
    static class Coordinates implements Comparable<Coordinates>{
        int x;
        int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /*
        ComparableTimSort -> sort() -> binarySort() -> Caomparable pivot = (Comparable) a[start] -> pivot.compareTo
        => 우리는 pivot의 compareTo를 override 한게 아닐까 싶다.
         */
        @Override
        public int compareTo(Coordinates o) {
            if (this.x != o.x) return this.x - o.x;
            else return this.y - o.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(stdIn.readLine());
        Coordinates[] arr = new Coordinates[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            arr[i] = new Coordinates(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);
        String answer = "";
        for (Coordinates coordinates : arr) {
            answer += coordinates.x + " " + coordinates.y + "\n";
        }
        stdOut.write(answer);
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
