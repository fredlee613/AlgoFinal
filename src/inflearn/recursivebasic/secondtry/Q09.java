package inflearn.recursivebasic.secondtry;

import java.util.LinkedList;
import java.util.Queue;

public class Q09 {
    static int L;
    static Queue<Node> q = new LinkedList<>();
    static int BFS(Node tree) {
        int cnt = 0;
        q.offer(tree);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cq = q.poll();
                if (cq.lt == null && cq.rt == null) return cnt;
                if (cq.lt != null) q.offer(cq.lt);
                if (cq.rt != null) q.offer(cq.rt);
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.lt = new Node(2);
        tree.rt = new Node(3);
        tree.lt.lt = new Node(4);
        tree.lt.rt = new Node(5);
        System.out.print(BFS(tree));
    }
}
