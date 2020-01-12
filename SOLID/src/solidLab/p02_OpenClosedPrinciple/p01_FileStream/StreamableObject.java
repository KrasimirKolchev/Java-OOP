package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public abstract class StreamableObject {
    private int length;
    private int sent;

    public StreamableObject(int length, int sent) {
        this.length = length;
        this.sent = sent;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSent() {
        return sent;
    }

    public void setSent(int sent) {
        this.sent = sent;
    }
}
