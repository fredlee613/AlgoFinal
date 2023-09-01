package inflearn.stackqueue;

import java.io.*;
import java.util.*;

/**
 * 3. 크레인 인형뽑기(카카오)
 */
public class Q03 {

    public String clawCraneGame(int n, ArrayList<Queue<Integer>> board, int m, int[] moves) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
        }
        Stack<Integer> stacker = new Stack<>();
        for (int x = 0; x < m; x++) {
            int move = moves[x] - 1;
            if (!board.get(move).isEmpty()) {
                Integer pick = board.get(move).poll();
                if (!stacker.isEmpty() && stacker.peek() == pick) {
                        stacker.pop();
                        answer += 2;
                } else stacker.push(pick);
            }
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException{
        Q03 main = new Q03();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        ArrayList<Queue<Integer>> board =new ArrayList<>();
        for (int i = 0; i < n; i++) board.add(new LinkedList<>());

        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int y = 0; y < n; y++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp != 0) board.get(y).offer(tmp);
            }
        }
        int m = Integer.parseInt(stdIn.readLine());
        int[] moves = new int[m];
        st = new StringTokenizer(stdIn.readLine());
        for (int x = 0; x < m; x++) moves[x] = Integer.parseInt(st.nextToken());

        stdOut.write(main.clawCraneGame(n, board, m, moves));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
