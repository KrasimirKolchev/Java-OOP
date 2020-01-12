package WorkingWithAbstraction.studentSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StudentSystem studentSystem = new StudentSystem();
        while (true) {
            String[] input = reader.readLine().split(" ");
            if (input[0].equals("Exit")){
                break;
            }
            studentSystem.ParseCommand(input);
        }
    }
}
