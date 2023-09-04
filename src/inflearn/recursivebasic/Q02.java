package inflearn.recursivebasic;

/**
 * 2. 재귀함수를 이용한 이진수 출력
 */
public class Q02 {
    public void Recursive(int n) {
        if (n == 0) return;
        else {
            Recursive(n / 2);
            System.out.print(n % 2);
        }
    }

    public static void main(String[] args) {
        Q02 main = new Q02();
        main.Recursive(11);
    }
}
