package inflearn.greedy.secondtry;

import java.io.*;
import java.util.StringTokenizer;

public class Q01 {
    static class Person {
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            people[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            Person tmp = people[i];
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (j != i && tmp.weight < people[j].weight && tmp.height < people[j].height){
                    flag = false;
                    break;
                }

            }
            if (flag) cnt++;
        }
        stdOut.write(String.valueOf(cnt));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
