package inflearn.dynamic;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q04 {
    static class Brick implements Comparable<Brick> {
        int size;
        int height;
        int weight;

        public Brick(int size, int height, int weight) {
            this.size = size;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick b) {
            return this.size - b.size;
        }
    }

    static int[] dy;
    static Brick[] bricks;

    static int dp(int n) {
        dy[0] = bricks[0].height;
        for (int i = 1; i < n; i++) {
            int tmp = 0;
            for (int j = i - 1; j >= 0; j--) if (bricks[i].weight > bricks[j].weight) tmp = Math.max(tmp, dy[j]);
            dy[i] = tmp + bricks[i].height;
        }
        return Arrays.stream(dy).max().getAsInt();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        dy = new int[n];
        bricks = new Brick[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            int s = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            bricks[i] = new Brick(s, h, w);
        }
        Arrays.sort(bricks);
        stdOut.write(String.valueOf(dp(n)));
        stdOut.flush();
        stdOut.close();
        stdIn.close();

    }
}
