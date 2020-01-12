package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public class Main {
    public static void main(String[] args) {

        StreamableObject file = new File(12, 6, "asd");

        Progress progress = new Progress();

        System.out.println(progress.getCurrentPercent(file));
    }
}

