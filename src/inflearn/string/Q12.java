package inflearn.string;

import java.io.*;

/**
 * 12. 암호
 */
public class Q12 {

    public String solution(int n, String code) {
        code = code.replace("#", "1").replace("*", "0");
        String answer = "";
        for (int x = 0; x < n; x++) answer += decode(code.substring(7 * x, 7 * (x + 1)));
        return answer;
    }

    private String decode(String code) {
        int sum = 0;
        for (int i = 0; i < code.length(); i++) {
            sum = sum * 2 + Character.getNumericValue(code.charAt(i));
        }
        return Character.toString((char) sum);
    }

    public static void main(String[] args) throws IOException {
        Q12 main = new Q12();
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());
        String code = stdIn.readLine();

        stdOut.write(main.solution(n, code));
        stdOut.flush();

        stdOut.close();
        stdIn.close();

    }
}
