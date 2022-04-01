package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

//Begin Declarations	
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private String user = "student";
	private String pass = "student";
//End Declarations

//Begin Methods	
	@Override
	public Film findFilmById(int filmId) {
		Film film = null;

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, title, description, release_year,"
					+ "language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features FROM film WHERE id =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, filmId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				film = new Film();
				film.setId(rs.getInt(1));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setLanguageId(rs.getInt("language_id"));
				film.setRentalDuration(rs.getInt("rental_duration"));
				film.setRentalRate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setSpecialFeatures(rs.getString("special_features"));
				film.setActorsInFilm(findActorsByFilmId(filmId));
			}
			ps.close();
			rs.close();
			conn.close();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	public Actor findActorById(int actorId) {
		Actor actor = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, first_name, last_name FROM actor WHERE id =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, actorId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				actor = new Actor();
				actor.setId(rs.getInt("id"));
				actor.setfName(rs.getString("first_name"));
				actor.setlName(rs.getString("last_name"));
			}
			ps.close();
			rs.close();
			conn.close();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actorsInFilm = new ArrayList();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT a.id, a.first_name, a.last_name, film.id FROM film_actor f  JOIN actor a ON f.actor_id = a.id JOIN film ON f.film_id=film.id WHERE film.id =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, filmId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				Actor actor = new Actor();
				actor.setId(rs.getInt("id"));
				actor.setfName(rs.getString("first_name"));
				actor.setlName(rs.getString("last_name"));
				actorsInFilm.add(actor);
			}
			ps.close();
			rs.close();
			conn.close();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return actorsInFilm;
	}

//END METHODS *******

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Driver not found.");
			throw new RuntimeException("Unable to load MYSQL driver class");
		}
	}

}
