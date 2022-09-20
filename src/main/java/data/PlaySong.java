package data;


import util.DbConnection;

import javax.sound.sampled.*;   //clip interface available inside this package
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class PlaySong {
    int response;
    List<Songs> songslist;
    int songIndex;

    public void playSong(List<Songs> songslist) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.songslist = songslist;
        for (int i = 0; i < songslist.size(); i++) {
            songIndex = i;
            playSong(songslist.get(i).getTrackPath());
        }

    }

    public void playSong(String songPath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Scanner scanner = new Scanner(System.in);
        File file = new File(songPath);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        String userResponse = "";

        while (!userResponse.equals("Q")) {
            System.out.println("P = play, V= Pause, S=Stop, L=Loop, R = Reset, Q = Quit,N = NextSong,O = previousSong");
            System.out.print("Enter your choice: ");

            userResponse = scanner.next();
            userResponse = userResponse.toUpperCase();


            switch (userResponse) {
                case "P": {
                    clip.start();
                    long clip_position = clip.getMicrosecondPosition();

                    break;
                }
                case "V": {
                    clip.stop();
                    long clip_position = clip.getMicrosecondPosition();
                    break;
                }
                case "S": {
                    clip.setMicrosecondPosition(0);
                    clip.stop();
                    break;
                }
                case "L": {
                    clip.start();
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }

                case "R":
                    clip.setMicrosecondPosition(0);
                    break;

                case "Q":
                    clip.close();
                    break;
                case "N":
                    songIndex += 1;
                    clip.close();
                    playSong(songslist.get(songIndex).getTrackPath());

                    break;
                case "O":
                    songIndex -= 1;
                    clip.close();
                    playSong(songslist.get(songIndex).getTrackPath());
                    break;

                default:
                    System.err.println("PLEASE SELECT THE CORRECT OPTION");
                    userResponse = scanner.next();
                    userResponse = userResponse.toUpperCase();
            }
        }
    }

}
