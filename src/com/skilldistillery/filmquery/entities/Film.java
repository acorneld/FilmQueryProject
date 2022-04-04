package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {

//Begin Declarations
	
	private int id;
	private String languageName;
	private String title;
	private String description ;
	private Integer releaseYear;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private Integer length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> actorsInFilm;
//End Declarations

// Constructors

	public Film() {
	}

	
	public Film(int id, String languageName, String title, String description, Integer releaseYear, int languageId, int rentalDuration,
			double rentalRate, Integer length, double replacementCost, String rating, String specialFeatures) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
	}
// End Constructors
	
	
//BEGIN METHODS*******
	public String showAll() {
	return	"ID=" + id + " Title= " + title + " Description= " + description + " Release Year= " + releaseYear
		+ " Language ID= " + languageId + " Rental Duration= " + rentalDuration + " Rental Rate= " + rentalRate 
		+ " Length= " + length + " Replacement Cost= " + replacementCost + " Rating= " + rating + " Language= " + languageName 
		+ " Special Features" + specialFeatures + " Actors In Film: " + actorsInFilm;
	
	}
	
//END METHODS*******



	@Override
	public int hashCode() {
		return Objects.hash(description, languageId, length, rating, releaseYear, rentalDuration, rentalRate,
				replacementCost, specialFeatures, title);
	}

//BEGIN G&S *************
	
	public List<Actor> getActorsInFilm() {
		return actorsInFilm;
	}


	public void setActorsInFilm(List<Actor> actorsInFilm) {
		this.actorsInFilm = actorsInFilm;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}
	
	public String getLanguageName() {
		return languageName;
	}
	
	
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	
//END G&S **************





	//HASHCODE
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(description, other.description) && languageId == other.languageId
				&& length == other.length && Objects.equals(rating, other.rating) && releaseYear == other.releaseYear
				&& rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title);
	}


	@Override
	public String toString() {
		return "Title= " + title + " Description= " + description + " Release Year= " + releaseYear
				+ " Rating= " + rating + " Language= " + languageName + " Actors In Film: " + actorsInFilm;
	}

}
