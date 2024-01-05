package Lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MusicDataReader {
    public static List<Music> readMusicFromTxt(String fileName) {
        List<Music> musicList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) { // Пока не достигли конца файла
                String[] values = line.split(",");
                musicList.add(parseMusic(values));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return musicList;
    }

    private static Music parseMusic(String[] data) {
        String groupName = data[0];
        String albumName = data[1];
        String trackName = data[2];
        int year = Integer.parseInt(data[3]);
        String country = data[4];
        String genre = data[5];

        return new Music(groupName, albumName, trackName, year, country, genre);
    }
}
