package by.snow.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Класс, представляющий аниме формата ONA (Original Net Animation).
 */
public class ONA extends Anime {
    private String platform;

    public ONA(String title, List<String> genres, double rating, int episodesCount, LocalDate releaseDate, String platform) {
        super(title, genres, rating, episodesCount, releaseDate);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    @Override
    public String toString() {
        return "ONA -> " + super.toString() + ", Платформа: " + platform;
    }
}