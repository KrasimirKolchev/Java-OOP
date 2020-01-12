package SOLID_Ex.logger.appenders;

import SOLID_Ex.logger.appenders.interfaces.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LogFile implements File {
    private static final String FILE_PATH = "C:\\Users\\Public\\test.txt";
    private StringBuilder sb;
    private String filePath;
    private int size;

    LogFile() {
        this.sb = new StringBuilder();
        this.filePath = FILE_PATH;
        this.size = 0;
    }

    public static String getFilePath() {
        return FILE_PATH;
    }

    @Override
    public void appendSb(String text) {
        this.sb.append(text).append(System.lineSeparator());
        this.size = this.size + this.sb.toString()
                .chars()
                .filter(Character::isAlphabetic)
                .sum();
    }

    @Override
    public void write() {
        try {
            Files.write(Paths.get(this.filePath), this.sb.toString().getBytes(), StandardOpenOption.APPEND);
            this.sb = new StringBuilder();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
