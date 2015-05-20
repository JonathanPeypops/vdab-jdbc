package be.vdab.jdbc;

import java.util.List;

public class Film {
    public Film(String title, String releaseYear, int film_id) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.film_id = film_id;
    }

    private String title;
    private String releaseYear;
    private int film_id;

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }
    public String toString(){
        return "title " + title + ", year " + releaseYear + " ID " + film_id + "\n";

    }
}
