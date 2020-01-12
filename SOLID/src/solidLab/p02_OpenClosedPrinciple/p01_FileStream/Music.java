package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public class Music extends StreamableObject {
    private String artist;
    private String album;

    public Music(int length, int sent, String artist, String album) {
        super(length, sent);
        this.artist = artist;
        this.album = album;
    }

    public String getArtist() {
        return this.artist;
    }

    private void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return this.album;
    }

    private void setAlbum(String album) {
        this.album = album;
    }
}
