package org.example.models;

import java.util.List;

public class Movie {
    private String title;
    private Director director;

    private List<Actor> listOFActors;

    public Movie(String title, Director director, List<Actor> listOFActors) {
        this.title = title;
        this.director = director;
        this.listOFActors = listOFActors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getListOFActors() {
        return listOFActors;
    }

    public void setListOFActors(List<Actor> listOFActors) {
        this.listOFActors = listOFActors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director=" + director +
                ", listOFActors=" + listOFActors +
                '}';
    }

}
