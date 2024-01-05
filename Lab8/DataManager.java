package Lab8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Map;


public class DataManager {

    private final List<Object> processors; // Объявление списка объектов, которые будут использоваться в качестве обработчиков данных
    private List<Music> musicList;
    private Object result;
    private Map<String, Long> resultMap;
    private final ExecutorService executor; // Объявление объекта для управления потоками

    // Конструктор класса, инициализирующий список обработчиков и ExecutorService
    public DataManager() {
        processors = new ArrayList<>();
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()); // availableProcessors() возвращает количество доступных процессоров (ядер) в системе
    }

    // Метод для регистрации объектов-обработчиков данных
    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    // Метод для загрузки данных о музыке из указанного источника
    public void loadMusicData(String source) {
        musicList = MusicDataReader.readMusicFromTxt(source);
    }

    public void processMusicData(String filterType, String filterValue) {
        // Цикл по всем зарегистрированным обработчикам данных
        for (Object processor : processors) {
            // Цикл по всем методам в классе обработчика данных
            for (Method method : processor.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(DataProcessor.class) && method.getName().equals(filterType)) {
                    try {
                        result = method.invoke(processor, musicList, filterValue);
                        if (result instanceof List) {
                            musicList = (List<Music>) result;
                        } else if (result instanceof Map) {
                            resultMap = (Map<String, Long>) result;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // Метод для сохранения обработанных данных о музыке в новый файл
    public void saveMusicData(String destination) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            for (Music music : musicList) {
                writer.write(music.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Дополнительный метод для сохранения Map в файл
    public void saveMapToFile(String destination) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            for (Map.Entry<?, ?> entry : resultMap.entrySet()) {
                writer.write(formatEntryForTxt(entry));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Метод для форматирования Map.Entry<?, ?> в строку перед сохранением в файл
    private String formatEntryForTxt(Map.Entry<?, ?> entry) {
        return String.format("\"%s\": %s",
                entry.getKey(),
                entry.getValue());
    }

    // Метод для завершения работы ExecutorService
    public void shutdown() {
        executor.shutdown();
    }
}
