package be.vdab.jdbc;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FilmDao dao = new JDBCFilmDao();


//         Example usage:
//        List<Film> flist = dao.findAllFilms();
//        for (Film film : flist) {
//            System.out.println(flist);
//            System.out.println(film.getTitle());
//        }
//        System.out.println(dao.findAllFilms().toString());

        // Example usage:
//        Film film = dao.findFilmById(6);
//        film.setReleaseYear("2014");
        Film f = new Film("CAFEBABE", "2015", 6);
        System.out.println(dao.updateFilm(f));
        System.out.println(dao.findFilmById(6));


        // Example usage:
        // dao.deleteFilm(1508);
        // ... play around with this.
    }
}
