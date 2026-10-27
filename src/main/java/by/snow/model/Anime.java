package by.snow.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Абстрактный базовый класс, описывающий аниме.
 * 
 * @author Snow
 * @version 1.0
 */
public abstract class Anime {
    private String title;
    private List<String> genres;
    private double rating;
    private int episodesCount;
    private LocalDate releaseDate;

    public Anime(String title, List<String> genres, double rating, int episodesCount, LocalDate releaseDate) {
        this.title = title;
        this.genres = genres;
        this.rating = rating;
        this.episodesCount = episodesCount;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getGenres() {
        return genres;
    }

    public double getRating() {
        return rating;
    }

    public int getEpisodesCount() {
        return episodesCount;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return String.format("Название: '%s', Жанры: %s, Рейтинг: %.1f, Серий: %d, Дата выхода: %s",
                title, genres, rating, episodesCount, releaseDate);
    }
}