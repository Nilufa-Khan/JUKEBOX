package data;

import util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Songs {
    private int songId;
    private String trackName;
    private String trackPath;
    private double duration;
    private int rating;
    private String artist;
    private String genre;

    public Songs() {
    }

    public Songs(int songId, String trackName, String trackPath, double duration, int rating, String artist, String genre) {
        this.songId = songId;
        this.trackName = trackName;
        this.trackPath = trackPath;
        this.duration = duration;
        this.rating = rating;
        this.artist = artist;
        this.genre = genre;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackPath() {
        return trackPath;
    }

    public void setTrackPath(String trackPath) {
        this.trackPath = trackPath;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String returnPath(int songId) throws SQLException, ClassNotFoundException {
        String path = "";
        Connection connection = DbConnection.getConnection();
        String quer = "Select trackPath from songs where songId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(quer);
        preparedStatement.setInt(1,songId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            path = resultSet.getString(1);
        }
        return path;
    }
}
