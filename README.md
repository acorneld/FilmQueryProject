# FilmQueryProject

Description

This program allows the user to search the SD Movie Database with one of two search criteria.
1. Search by film ID
  i. Returns all relevant information based on FILM ID and displays the Film's Title, Year, Rating, Description, Language, and list of actors in the film.

2. Search by film keyword
  i. Returns all relevant information based on user inputted Keyword Search.  Table search does not include Actors in Film or Language of Film.

3. The user will exit the application.


Technologies Used

MYSQL
Apache TomCat Server v8.5
Eclipse IDE
Java 1.8
Atom Text Editor
Terminal: zsh and MYSQL

Lessons Learned

Making sure to implement the unique syntax of "%" + "variable" + "%" was something that left me hung on the keyword search implementation.  New tables created by joins must have a variable declared in the object class that will allow for assignment of newly accessible table variables.
