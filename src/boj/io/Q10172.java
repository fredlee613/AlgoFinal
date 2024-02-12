package boj.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Q10172 {
    public static void main(String[] args) throws IOException {
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        String dog = "|\\_/|\n|q p|   /}\n( 0 )\"\"\"\\\n|\"^\"`    |\n||_/=\\\\__|";
        stdOut.write(dog);
        stdOut.flush();
        stdOut.close();
    }
}
