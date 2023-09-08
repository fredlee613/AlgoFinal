package inflearn.greedy;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 씨름 선수
 */
public class Q01 {
    static class Body {
        int h;
        int w;

        public Body(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        Body[] arr = new Body[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            arr[i] = new Body(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int x = 0; x < n; x++) {
            Body cb = arr[x];
            boolean flag = true;
            for (int y = 0; y < n; y++) {
                if (x != y) {
                    if (cb.h < arr[y].h && cb.w < arr[y].w) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) cnt++;
        }

        stdOut.write(String.valueOf(cnt));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }

}
