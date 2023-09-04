package inflearn.recursivebasic;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 9. Tree 말단 노드까지의 가장 짧은 경로
 */
public class Q09 {
    public int BFS(Root node) {
        int cnt = 0;
        Queue<Root> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Root cr = queue.poll();
                if (cr.lt == null && cr.rt == null) return cnt;
                if (cr.lt != null) queue.offer(cr.lt);
                if (cr.rt != null) queue.offer(cr.rt);
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Q09 main = new Q09();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        Root node = new Root(1);
        node.lt = new Root(2);
        node.rt = new Root(3);
        node.lt.lt = new Root(4);
        node.lt.rt = new Root(5);


        stdOut.write(String.valueOf(main.BFS(node)));
        stdOut.flush();
        stdOut.close();
        stdIn.close();

    }
}
