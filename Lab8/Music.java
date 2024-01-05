package Lab8;

public class Music {
    private String groupName;
    private String albumName;
    private String trackName;
    private int year;
    private String country;
    private String genre;

    public Music(String groupName, String albumName, String trackName, int year, String country, String genre) {
        this.groupName = groupName;
        this.albumName = albumName;
        this.trackName = trackName;
        this.year = year;
        this.country = country;
        this.genre = genre;
    }

    // Геттеры и сеттеры
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%d,%s,%s", groupName, albumName, trackName, year, country, genre);
    }
}

