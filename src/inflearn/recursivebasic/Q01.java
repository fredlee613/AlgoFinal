package inflearn.recursivebasic;

/**
 * 1. 재귀함수
 */
public class Q01 {
    public void Recursive(int n) {
        if (n == 0) return;
        Recursive(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        Q01 main = new Q01();
        main.Recursive(3);

    }
}
