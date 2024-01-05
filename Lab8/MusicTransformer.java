package Lab8;

import java.util.List;
import java.util.stream.Collectors;

public class MusicTransformer {

    @DataProcessor
    public List<Music> transformToUpperCase(List<Music> musicList, String targetType) {
        switch (targetType.toLowerCase()) {
            case "groupname":
                return transformGroupNameToUpperCase(musicList);
            case "albumname":
                return transformAlbumNameToUpperCase(musicList);
            case "trackname":
                return transformTrackNameToUpperCase(musicList);
            case "country":
                return transformCountryToUpperCase(musicList);
            case "genre":
                return transformGenreToUpperCase(musicList);
            default:
                throw new IllegalArgumentException("Invalid target type for transformation: " + targetType);
        }
    }

    private List<Music> transformGroupNameToUpperCase(List<Music> musicList) {
        return musicList.stream()
                .map(music -> new Music( // map() применяет указанную функцию к каждому элементу потока
                        music.getGroupName().toUpperCase(),
                        music.getAlbumName(),
                        music.getTrackName(),
                        music.getYear(),
                        music.getCountry(),
                        music.getGenre()))
                .collect(Collectors.toList());
    }

    private List<Music> transformAlbumNameToUpperCase(List<Music> musicList) {
        return musicList.stream()
                .map(music -> new Music(
                        music.getGroupName(),
                        music.getAlbumName().toUpperCase(),
                        music.getTrackName(),
                        music.getYear(),
                        music.getCountry(),
                        music.getGenre()))
                .collect(Collectors.toList());
    }

    private List<Music> transformTrackNameToUpperCase(List<Music> musicList) {
        return musicList.stream()
                .map(music -> new Music(
                        music.getGroupName(),
                        music.getAlbumName(),
                        music.getTrackName().toUpperCase(),
                        music.getYear(),
                        music.getCountry(),
                        music.getGenre()))
                .collect(Collectors.toList());
    }

    private List<Music> transformCountryToUpperCase(List<Music> musicList) {
        return musicList.stream()
                .map(music -> new Music(
                        music.getGroupName(),
                        music.getAlbumName(),
                        music.getTrackName(),
                        music.getYear(),
                        music.getCountry().toUpperCase(),
                        music.getGenre()))
                .collect(Collectors.toList());
    }

    private List<Music> transformGenreToUpperCase(List<Music> musicList) {
        return musicList.stream()
                .map(music -> new Music(
                        music.getGroupName(),
                        music.getAlbumName(),
                        music.getTrackName(),
                        music.getYear(),
                        music.getCountry(),
                        music.getGenre().toUpperCase()))
                .collect(Collectors.toList());
    }
}
