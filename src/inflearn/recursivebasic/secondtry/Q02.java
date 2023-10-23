package inflearn.recursivebasic.secondtry;

public class Q02 {
    static void Recursive(int N) {
        if (N == 0) return;
        else {
            Recursive(N / 2);
            System.out.print(N % 2);
        }
    }
    public static void main(String[] args) {
        Recursive(11);
    }
}
