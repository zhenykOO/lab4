package by.snow;

import by.snow.model.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Главный класс консольного приложения для работы с иерархией аниме.
 * 
 * @author Snow
 */
public class Main {
    public static void main(String[] args) {
        // Создание коллекции из 10 экземпляров аниме разных типов и франшиз
        List<Anime> animeList = Arrays.asList(
            // Обязательные ДжоДжо и Steel Ball Run
            new AnimeSeries("Невероятные приключения ДжоДжо: Stardust Crusaders", 
                Arrays.asList("Экшен", "Приключения", "Сверхъестественное"), 8.5, 24, LocalDate.of(2014, 4, 5), "David Production"),
            new AnimeSeries("Невероятные приключения ДжоДжо: Golden Wind", 
                Arrays.asList("Экшен", "Приключения", "Драма"), 8.6, 39, LocalDate.of(2018, 10, 6), "David Production"),
            new OVA("Так говорил Кисибе Рохан", 
                Arrays.asList("Детектив", "Сверхъестественное", "Триллер"), 8.1, 4, LocalDate.of(2017, 9, 20), 22),
            new AnimeSeries("Невероятные приключения ДжоДжо: Steel Ball Run", 
                Arrays.asList("Экшен", "Приключения", "Вестерн"), 9.1, 24, LocalDate.of(2026, 1, 15), "David Production"),
            
            // Другие популярные аниме
            new AnimeSeries("Адский рай", 
                Arrays.asList("Экшен", "Приключения", "Фэнтези"), 8.2, 13, LocalDate.of(2023, 4, 1), "MAPPA"),
            new AnimeSeries("Атака титанов", 
                Arrays.asList("Экшен", "Драма", "Фэнтези"), 9.0, 87, LocalDate.of(2013, 4, 7), "WIT Studio"),
            new ONA("Человек-бензопила", 
                Arrays.asList("Экшен", "Сверхъестественное", "Ужасы"), 8.5, 12, LocalDate.of(2022, 10, 12), "Crunchyroll"),
            new AnimeSeries("Магическая битва", 
                Arrays.asList("Экшен", "Сверхъестественное", "Фэнтези"), 8.6, 24, LocalDate.of(2020, 10, 3), "MAPPA"),
            new AnimeSeries("Клинок, рассекающий демонов", 
                Arrays.asList("Экшен", "Фэнтези", "Исторический"), 8.7, 26, LocalDate.of(2019, 4, 6), "ufotable"),
            new OVA("Хеллсинг Ultimate", 
                Arrays.asList("Экшен", "Ужасы", "Сверхъестественное"), 8.4, 10, LocalDate.of(2006, 2, 10), 50)
        );

        System.out.println("=== 1. ВСЕ СОЗДАННЫЕ ЭКЗЕМПЛЯРЫ АНИМЕ (10 штук) ===");
        animeList.forEach(System.out::println);

        // Пункт 4: Вывести все Аниме, рейтинг которых больше 7
        System.out.println("\n=== 2. АНИМЕ С РЕЙТИНГОМ БОЛЬШЕ 7.0 ===");
        animeList.stream()
                .filter(a -> a.getRating() > 7.0)
                .forEach(a -> System.out.println("• " + a.getTitle() + " — Рейтинг: " + a.getRating()));

        // Пункт 5: Вывести Аниме, которые вышли недавно (за последние годы, например, с 2023 года)
        System.out.println("\n=== 3. НЕДАВНО ВЫШЕДШИЕ АНИМЕ (с 2023 года) ===");
        LocalDate thresholdDate = LocalDate.of(2023, 1, 1);
        animeList.stream()
                .filter(a -> !a.getReleaseDate().isBefore(thresholdDate))
                .forEach(a -> System.out.println("• " + a.getTitle() + " — Дата выхода: " + a.getReleaseDate()));

        // Пункт 6: Перечислить жанры Аниме, которые встречаются чаще всего
        System.out.println("\n=== 4. СТАТИСТИКА ПО ЖАНРАМ (ЧАСТОТА ВСТРЕЧАЕМОСТИ) ===");
        Map<String, Long> genreCounts = animeList.stream()
                .flatMap(a -> a.getGenres().stream())
                .collect(Collectors.groupingBy(g -> g, Collectors.counting()));

        genreCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " раз(а)"));
    }
}