package data;


import main.Implement;
import util.DbConnection;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class JukeBoxOperation {
    List<Songs> songList = new ArrayList<>();
    public List<Songs> getAllsong() {
        List<Songs> list = new ArrayList<>();
        try {
            Connection connection = DbConnection.getConnection();

            String query = "select * from songs";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Songs songData = new Songs();

                songData.setSongId(rs.getInt(1));
                songData.setTrackName(rs.getString(2));
                songData.setTrackPath(rs.getString(3));
                songData.setDuration(rs.getDouble(4));
                songData.setRating(rs.getInt(5));
                songData.setArtist(rs.getString(6));
                songData.setGenre(rs.getString(7));
                list.add(songData);
            }
            for (Songs songs : list) {
                System.out.format("%-10s %-18s %-15s %-18s %-18s %-15s  \n", songs.getSongId(), songs.getTrackName(), songs.getDuration(), songs.getRating(), songs.getArtist(), songs.getGenre());

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Songs> searchBySongName(String songName) throws SQLException, ClassNotFoundException {

        List<Songs> newLL = new ArrayList<>();
        Connection connection = DbConnection.getConnection();
        String sql = "select * from songs where trackName like ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, songName + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            newLL.add(new Songs(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), resultSet.getInt(5), resultSet.getString(6), resultSet.getString(7)));
        }
        return newLL;
    }

    public List<Songs> searchByArtist(String artistName) throws SQLException, ClassNotFoundException {

        List<Songs> newLL = new ArrayList<>();
        Connection connection = DbConnection.getConnection();
        String sql = "select * from songs where artist like ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, artistName + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            newLL.add(new Songs(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), resultSet.getInt(5), resultSet.getString(6), resultSet.getString(7)));
        }
        return newLL;
    }

    public List<Songs> searchByGenre(String genre) throws SQLException, ClassNotFoundException {

        List<Songs> newLL = new ArrayList<>();
        Connection connection = DbConnection.getConnection();
        String sql = "select * from songs where genre like ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, genre + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            newLL.add(new Songs(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), resultSet.getInt(5), resultSet.getString(6), resultSet.getString(7)));
        }
        return newLL;
    }
    public void playSongs() throws Exception {
        Scanner scanner = new Scanner(System.in);
        PlaySong playSong = new PlaySong();
        Songs songs = new Songs();
        PlayList playList = new PlayList();

        System.out.println("PLEASE SELECT THE OPTION \n1: PLAY A SONG \n2: GO TO PLAYLIST\n3: GO BACK TO MAIN MENU");
        int choice = scanner.nextInt();

        switch (choice) {
            case (1):
                System.out.println("PLEASE ENTER THE SONG ID YOU WANT TO PLAY");
                int songID = scanner.nextInt();
                playSong.playSong(songs.returnPath(songID));
                break;
            case (2):
                System.out.println("1 FOR CREATING A NEW PLAYLIST\n2 FOR EXISTING PLAYLIST");
                int userChoice = scanner.nextInt();
                switch (userChoice) {
                    case (1):
                        playList.createAPlayList();
                    case (2):
                        List<Songs> playList1 = playList.existingPlaylist();
                        System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration","Rating", "Artist","GenreType");
                        System.out.println("============================================================================================");
                        for (Songs songs2 : playList1) {
                            System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", songs.getSongId(), songs.getTrackName(), songs.getDuration(),songs.getRating(), songs.getArtist(), songs.getGenre());
                        }
                        System.out.println("-----------------------------------------------------------------------------------------");
                        System.out.println("\t\t1: DO YOU WANT TO PLAY THE ENTIRE PLAYLIST");
                        System.out.println("\t\t2: DO YOU WANT TO PLAY A SONG FROM PLAYLIST");
                        System.out.println("\t\t3: GO BACK TO MAIN MENU");
                        int select = scanner.nextInt();
                        switch (select) {
                            case (1):
                                playSong.playSong(playList1);
                                break;
                            case (2):
                                System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration","Rating", "Artist","GenreType");
                                System.out.println("============================================================================================");
                                for (Songs songs2 : playList1) {
                                    System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", songs.getSongId(), songs.getTrackName(), songs.getDuration(),songs.getRating(), songs.getArtist(), songs.getGenre());
                                }
                                System.out.println("PLEASE ENTER THE SONGID YOU WANT TO PLAY");
                                int song_id = scanner.nextInt();
                               playSong.playSong(songs.returnPath(song_id));

                            case (3):
                                String[] arg = new String[0];
                                Implement.main(arg);
                                break;
                            default:
                                System.err.println("PLEASE SELECT THE CORRECT OPTION");
                        }

                }
                break;
            case (3):
                break;
            default:
                System.err.println("PLEASE SELECT THE RIGHT OPTION");


        }
    }

}
