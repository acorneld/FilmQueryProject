package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.NoSuchElementException;
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
		app.menuChoice(app.launch());
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
		Scanner kb = new Scanner(System.in);
		if (choice >= 1 && choice <= 3) {
			switch (choice) {
			case 1:
				System.out.println("Please enter the Film's ID: ");
				int filmId = kb.nextInt();
				Film filmResult = db.findFilmById(filmId);
				if (filmResult != null) {
					System.out.println(filmResult);
				} else {
					System.out.println("I'm sorry, there is no Film by this ID.");
				}
				break;

			case 2:
				System.out.println("Please enter the search Keyword");
				String keyword = kb.nextLine();
				Film keywordResult = db.findFilmByKeyword(keyword);
				if (keywordResult != null) {
					System.out.println(keywordResult);
					break;
				} else {
					System.out.println("I'm sorry, no Films match these Keywords.  Do Better.");
				}
				break;
			case 3:
				System.out.println("Application Exiting");
				System.out.println(".");
				System.out.println("..");
				System.out.println("...");
				System.out.println("....");
				System.out.println("Goodbye.");
				break;
			}
		}else{
			System.out.println("Invalid Selection");
		}
		kb.close();
	}
//END METHODS*************
}
