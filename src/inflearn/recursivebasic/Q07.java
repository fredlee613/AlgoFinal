package inflearn.recursivebasic;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 7. 이진트리 순회(넓이우선탐색 : 레벨탐색)
 */
public class Q07 {
    public void BFS(Root node) {
        Queue<Root> queue = new LinkedList();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Root cq = queue.poll();
                System.out.print(cq.data + " ");
                if (cq.lt != null) queue.offer(cq.lt);
                if (cq.rt != null) queue.offer(cq.rt);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Q07 main = new Q07();

        Root node = new Root(1);
        node.lt = new Root(2);
        node.rt = new Root(3);
        node.lt.lt = new Root(4);
        node.lt.rt = new Root(5);
        node.rt.lt = new Root(6);
        node.rt.rt = new Root(7);

        main.BFS(node);
    }
}
