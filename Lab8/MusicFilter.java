package Lab8;

import java.util.List;
import java.util.stream.Collectors;

public class MusicFilter {

    @DataProcessor
    public List<Music> filterByGroup(List<Music> musicList, String group) {
        return musicList.stream() // Преобразует список musicList в поток
                .filter(music -> music.getGroupName().equalsIgnoreCase(group))
                .collect(Collectors.toList());
    }

    @DataProcessor
    public List<Music> filterByCountry(List<Music> musicList, String country) {
        return musicList.stream()
                .filter(music -> music.getCountry().equalsIgnoreCase(country))
                .collect(Collectors.toList());
    }

    @DataProcessor
    public List<Music> filterByGenre(List<Music> musicList, String genre) {
        return musicList.stream()
                .filter(music -> music.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }
}
