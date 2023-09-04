package inflearn.recursivebasic;

/**
 * 3. 팩토리얼
 */
public class Q03 {
    public int Recursive(int n) {
        if (n == 1) return 1;
        else return n * Recursive(n - 1);
    }

    public static void main(String[] args) {
        Q03 main = new Q03();
        int result = main.Recursive(5);
        System.out.print(result);
    }
}
