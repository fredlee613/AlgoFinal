package boj.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Q10171 {
    public static void main(String[] args) throws IOException {
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        String cat = "\\    /\\\n )  ( ')\n(  /  )\n \\(__)|";
        stdOut.write(cat);
        stdOut.flush();
        stdOut.close();
    }
}
