package inflearn.recursivebasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이진트리 순회(깊이우선탐색)
 */
public class Q05 {

    public void Recursive(Root node) {
        if (node == null) return;
        else {
//            System.out.print(node.data + " "); // 전위 순회:  1 2 4 5 3 6 7
            Recursive(node.lt);
//            System.out.print(node.data + " "); // 중위 순회:  4 2 5 1 6 3 7
            Recursive(node.rt);
            System.out.print(node.data + " "); // 후위 순회:  4 5 2 6 7 3 1
        }
    }

    public static void main(String[] args) throws IOException {
        Q05 main = new Q05();

        Root node = new Root(1);
        node.lt = new Root(2);
        node.rt = new Root(3);
        node.lt.lt = new Root(4);
        node.lt.rt = new Root(5);
        node.rt.lt = new Root(6);
        node.rt.rt = new Root(7);

        main.Recursive(node);
    }
}
