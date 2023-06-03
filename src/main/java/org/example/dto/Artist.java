package org.example.dto;

public class Artist {

    private String firstName;
    private String lastName;
    private Genre genre;

    public Artist(String firstName, String lastName, Genre genre) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.genre = genre;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
