package Lab8;

public class Main {
    public static void main(String[] args) {
        DataManager musicDataManager = new DataManager();
        musicDataManager.registerDataProcessor(new MusicFilter());
        musicDataManager.registerDataProcessor(new MusicAggregator());
        musicDataManager.registerDataProcessor(new MusicTransformer());

        // Отфильтруем по музыке из Канады
        musicDataManager.loadMusicData("/Users/diana/ITP_Labs/src/Lab8/MusicData.txt");
        musicDataManager.processMusicData("filterByCountry", "Canada");
        musicDataManager.saveMusicData("/Users/diana/ITP_Labs/src/Lab8/Canada.txt");

        // Отфильтруем по жанру "Soundtrack"
        musicDataManager.loadMusicData("/Users/diana/ITP_Labs/src/Lab8/MusicData.txt");
        musicDataManager.processMusicData("filterByGenre", "Soundtrack");
        musicDataManager.saveMusicData("/Users/diana/ITP_Labs/src/Lab8/Soundtrack.txt");

        // Пример агрегации: подсчет количества записей по странам
        musicDataManager.loadMusicData("/Users/diana/ITP_Labs/src/Lab8/MusicData.txt");
        musicDataManager.processMusicData("countByAttribute", "country");
        musicDataManager.saveMapToFile("/Users/diana/ITP_Labs/src/Lab8/CountByCountry.txt");

        // Пример трансформации: преобразование всех названий треков в верхний регистр
        musicDataManager.loadMusicData("/Users/diana/ITP_Labs/src/Lab8/MusicData.txt");
        musicDataManager.processMusicData("transformToUpperCase", "trackname");
        musicDataManager.saveMusicData("/Users/diana/ITP_Labs/src/Lab8/UpperCaseTransform.txt");

        musicDataManager.shutdown();
    }
}
