package inflearn.recursivebasic.secondtry;

public class Q01 {
    static void Recursive(int N) {
        if (N == 0) return;
        else {
            Recursive(N - 1);
            System.out.print(N + " ");
        }
    }

    public static void main(String[] args) {
        Recursive(3);
    }
}
