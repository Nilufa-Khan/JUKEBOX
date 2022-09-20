import static org.junit.jupiter.api.Assertions.*;
import data.JukeBoxOperation;
import data.PlayList;
import data.PlaySong;
import data.Songs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

class JukeBoxTestTest {
    JukeBoxOperation jukeBoxOperation;
    PlaySong playSong;
    PlayList playList;
    Songs songs;

    @BeforeEach
    void setUp() {
        jukeBoxOperation = new JukeBoxOperation();
        playSong = new PlaySong();
        songs = new Songs();
        playList = new PlayList();
    }

    @AfterEach
    void tearDown() {
        jukeBoxOperation = null;
        playSong = null;
        songs = null;
    }


    @Test
    void displaySongTable() throws SQLException, ClassNotFoundException {
        List<Songs> songsList = jukeBoxOperation.getAllsong();
        assertEquals(19,songsList.size());
        assertNotEquals(29,songsList.size());
    }
    @Test
    void searchBySongName() throws SQLException, ClassNotFoundException {
        String songName = "d";
        List<Songs> songsList = jukeBoxOperation.searchBySongName(songName);
        assertEquals(2,songsList.size());
        List<Songs> songsList1 = jukeBoxOperation.searchBySongName(songName);
        assertNotEquals(5,songsList.size());

    }

    @Test
    void searchByArtistName() throws SQLException, ClassNotFoundException {
        String artistName = "a";
        List<Songs> songsList = jukeBoxOperation.searchByArtist(artistName);
        assertEquals(5,songsList.size());
        List<Songs> songsList1 = jukeBoxOperation.searchByArtist(artistName);
        assertNotEquals(3,songsList.size());
    }

    @Test
    void searchByGenreType() throws SQLException, ClassNotFoundException {

        String genreType = "Romantic";
        List<Songs> songsList = jukeBoxOperation.searchByGenre(genreType);
        assertEquals(4,songsList.size());
        List<Songs> songsList1 = jukeBoxOperation.searchByGenre(genreType);
        assertNotEquals(5,songsList.size());
    }


    @Test
    void getPathOfSong() throws SQLException, ClassNotFoundException {

        int songID = 18;
        String pathOfTheSong = songs.returnPath(songID);
        assertEquals("src/main/resources/Thodi Jagah - Marjaavaan 128 Kbps.wav",pathOfTheSong);
        int songId = 5;
        String pathOfTheSong1 = songs.returnPath(songID);
        assertNotEquals("src/main/resources/wav_21mb.wav",1);
    }
   /* @Test
    void existingPlaylist() throws SQLException, ClassNotFoundException {
        List<Songs> songsList = playList.existingPlaylist();
        assertEquals(8,songsList.size());
    }*/
}