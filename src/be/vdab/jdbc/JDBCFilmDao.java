package be.vdab.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCFilmDao implements FilmDao {

    @Override
    public Film findFilmById(int id) {
        Connection c = createConnection();
        Statement st = null;
        Film film = null;

        try {
            st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from film where film_id = 6");
            rs.next();
            film = new Film(rs.getString("title"), rs.getString("release_year"), rs.getInt("film_id"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }

    @Override
    public List<Film> findAllFilms() {
        Connection c = createConnection();
        Statement st = null;
        List<Film> flist = new ArrayList<>();

        try {
            st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from film");
            while (rs.next()) {
                flist.add(new Film(rs.getString("title"), rs.getString("release_year"), rs.getInt("film_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flist;

    }

    @Override
    public boolean updateFilm(Film film) throws IllegalArgumentException {
        Connection c = createConnection();

        try {
            PreparedStatement ps = c.prepareStatement("update film set title = ?, release_year = ? where film_id = ? ");
            ps.setString(1, film.getTitle());
            ps.setString(2, film.getReleaseYear());
            ps.setInt(3, film.getFilm_id());
            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteFilm(int id) {
        Connection c = createConnection();

        try {
            PreparedStatement ps = c.prepareStatement("delete from film where film_id = ? ");
            ps.setInt(1, id);
            ps.execute();
            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    private static Connection createConnection() {
        String url = "jdbc:mysql://127.0.0.1:3306/sakila";
        String username = "root";
        String pw = "";
        String driverClassName = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driverClassName);
            return DriverManager.getConnection(url, username, pw);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Unable to do this, please help", e);
        }
    }
}
