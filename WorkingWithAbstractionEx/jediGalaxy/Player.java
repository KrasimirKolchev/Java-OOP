package WorkingWithAbstractionEx.jediGalaxy;

public class Player {
    private long stars;

    public Player() {
        this.stars = 0;
    }

    public long getStars() {
        return this.stars;
    }

    public void setStars(int starsToAdd) {
        this.stars += starsToAdd;
    }
}
