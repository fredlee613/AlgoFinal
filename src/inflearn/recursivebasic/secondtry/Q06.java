package inflearn.recursivebasic.secondtry;

import org.apache.groovy.parser.antlr4.util.StringUtils;

public class Q06 {
    static int N = 3;
    static int[] ch = new int[4];
    static void DFS(int L) {
        if (L == N + 1) {
            String tmp = "";
            for (int i = 1; i <= N; i++) {
                if (ch[i] == 1) tmp += i + " ";
            }
            if (StringUtils.isEmpty(tmp)) tmp = "empty set";
            System.out.println(tmp);
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }
    public static void main(String[] args) {

        DFS(1);
    }
}
