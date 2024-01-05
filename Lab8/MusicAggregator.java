package Lab8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MusicAggregator {

    @DataProcessor
    public Map<String, Long> countByAttribute(List<Music> musicList, String attribute) {
        switch (attribute.toLowerCase()) {
            case "groupname":
                return countByGroup(musicList);
            case "albumname":
                return countByAlbum(musicList);
            case "country":
                return countByCountry(musicList);
            case "genre":
                return countByGenre(musicList);
            default:
                throw new IllegalArgumentException("Invalid attribute for grouping: " + attribute);
        }
    }

    private Map<String, Long> countByGroup(List<Music> musicList) {
        return musicList.stream()
                .collect(Collectors.groupingBy(Music::getGroupName, Collectors.counting()));
    }

    private Map<String, Long> countByAlbum(List<Music> musicList) {
        return musicList.stream()
                .collect(Collectors.groupingBy(Music::getAlbumName, Collectors.counting()));
    }

    private Map<String, Long> countByCountry(List<Music> musicList) {
        return musicList.stream()
                .collect(Collectors.groupingBy(Music::getCountry, Collectors.counting()));
    }

    private Map<String, Long> countByGenre(List<Music> musicList) {
        return musicList.stream()
                .collect(Collectors.groupingBy(Music::getGenre, Collectors.counting()));
    }
}
