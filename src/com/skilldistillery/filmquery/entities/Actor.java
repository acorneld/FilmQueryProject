package com.skilldistillery.filmquery.entities;

import java.util.Objects;

public class Actor {

//Begin Declarations
	private int id;
	private String fName;
	private String lName;
//End Declarations

//Begin Constructors	
	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Actor(int id, String fName, String lName) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
	}
//End Constructors

//BEGIN G&S **********
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}
//END G&S *********

	@Override
	public String toString() {
		return "Actor" + " First Name= " + fName + ", Last Name= " + lName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fName, id, lName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return Objects.equals(fName, other.fName) && id == other.id && Objects.equals(lName, other.lName);
	}


	

	
}
