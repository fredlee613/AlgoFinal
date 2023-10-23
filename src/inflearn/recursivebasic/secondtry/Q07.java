package inflearn.recursivebasic.secondtry;

import java.util.LinkedList;
import java.util.Queue;

public class Q07 {
    static Queue<Node> queue = new LinkedList<>();
    static void BFS(Node tree) {
        queue.offer(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                System.out.print(currentNode.data + " ");
                if (currentNode.lt != null) queue.offer(currentNode.lt);
                if (currentNode.rt != null) queue.offer(currentNode.rt);
            }
        }
    }
    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.lt = new Node(2);
        tree.rt = new Node(3);
        tree.lt.lt = new Node(4);
        tree.lt.rt = new Node(5);
        tree.rt.lt = new Node(6);
        tree.rt.rt = new Node(7);
        BFS(tree);
    }
}
