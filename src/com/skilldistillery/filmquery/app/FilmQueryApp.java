package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.*;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();

//    app.menu();
//    app.test();
//    app.launch();
	}
//BEGIN METHODS ********
	private void test() {
		Film film = db.findFilmById(1);
		Actor actor = db.findActorById(1);
		List<Actor> actorsInFilm = db.findActorsByFilmId(2);
		System.out.println(film);
		System.out.println("");
		System.out.println(actor);
		System.out.println(actorsInFilm);
		System.out.println(film.getActorsInFilm());
	}

	private int launch() {
		Scanner input = new Scanner(System.in);
		menu();
		int choice = 0;
		choice = input.nextInt();
		input.close();
		return choice;
	}

	private void menu() {
		System.out.println("Welcome to the SD Movie Database.");
		System.out.println("Please choose from the following options: ");
		System.out.println("1. Look up Film by ID");
		System.out.println("2. Look up Film by Keyword");
		System.out.println("3. Exit the Application");
	}
	
	private void menuChoice(int choice) {
		switch(choice) {
		case 1:
			Scanner kb = new Scanner(System.in);
			System.out.println("Please enter the Film's ID: ");
			
		}
	}
//END METHODS*************
}
