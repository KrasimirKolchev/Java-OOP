package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public class File extends StreamableObject {
    private String name;

    public File(int length, int sent, String name) {
        super(length, sent);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

}
