package motocrossWorldChampionship.io;

import motocrossWorldChampionship.io.interfaces.InputReader;

import java.util.Scanner;

public class InputReaderImpl implements InputReader {
    private Scanner reader;

    public InputReaderImpl() {
        this.reader = new Scanner(System.in);
    }

    @Override
    public String readLine() {
        return this.reader.nextLine();
    }
}
