package boj.string;

import java.io.*;
import java.util.ArrayList;

public class Q11718 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> words = new ArrayList<>();
        String str = "";
        while ((str = stdIn.readLine()) != null) {
            System.out.println(str);
        }

        stdIn.close();
    }
}
