package by.snow.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Класс, представляющий аниме формата OVA (Original Video Animation).
 */
public class OVA extends Anime {
    private int durationMinutes;

    public OVA(String title, List<String> genres, double rating, int episodesCount, LocalDate releaseDate, int durationMinutes) {
        super(title, genres, rating, episodesCount, releaseDate);
        this.durationMinutes = durationMinutes;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public String toString() {
        return "OVA -> " + super.toString() + ", Длительность серии: " + durationMinutes + " мин.";
    }
}