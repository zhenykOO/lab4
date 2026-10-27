package by.snow.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Класс, представляющий телевизионный аниме-сериал.
 */
public class AnimeSeries extends Anime {
    private String studio;

    public AnimeSeries(String title, List<String> genres, double rating, int episodesCount, LocalDate releaseDate, String studio) {
        super(title, genres, rating, episodesCount, releaseDate);
        this.studio = studio;
    }

    public String getStudio() {
        return studio;
    }

    @Override
    public String toString() {
        return "TV-Сериал -> " + super.toString() + ", Студия: " + studio;
    }
}