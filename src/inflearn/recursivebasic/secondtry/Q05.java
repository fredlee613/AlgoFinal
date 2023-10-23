package inflearn.recursivebasic.secondtry;

public class Q05 {

    static void DFS(Node tree) {
        if (tree.lt != null) DFS(tree.lt);
        System.out.print(tree.data + " ");
        if (tree.rt != null) DFS(tree.rt);
    }

    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.lt = new Node(2);
        tree.rt = new Node(3);
        tree.lt.lt = new Node(4);
        tree.lt.rt = new Node(5);
        tree.rt.lt = new Node(6);
        tree.rt.rt = new Node(7);

        DFS(tree);
    }
}
