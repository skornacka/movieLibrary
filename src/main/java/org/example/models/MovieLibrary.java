package org.example.models;

import com.sun.source.tree.IfTree;
import org.example.handlers.RandomDataHandler;
import org.example.handlers.UserInputHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MovieLibrary {
    private static List<Movie> moviesLibrary;

    public void fillMoviesList() {
        moviesLibrary = new ArrayList<>();
        Director RidleyScott = new Director("Ridley", "Scott");
        Director g_Verbinski = new Director("Gore", "Verbinski");
        Director q_Tarantino = new Director("Quentin", "Tarantino");
        Director p_Jackson = new Director("Peter", "Jackson");

        Actor RusellCrowe = new Actor("Rusell", "Crowe");
        Actor OliverReed = new Actor("Oliver", "Reed");
        Actor DerecJacob = new Actor("Derek", "Jacob");
        Actor j_Deep = new Actor("Johnny", "Deep");
        Actor o_Bloom = new Actor("Orlando", "Bloom");
        Actor k_Knightley = new Actor("Keira", "Knightley");
        Actor j_Travolta = new Actor("John", "Travolta");
        Actor u_Thurman = new Actor("Uma", "Thurman");
        Actor h_Keitel = new Actor("Harvey", "Keitel");
        Actor t_Cruze = new Actor("Tom", "Cruise");

        moviesLibrary.add(new Movie("Pirates of the Caribbean", g_Verbinski, List.of(OliverReed, j_Deep)));
        moviesLibrary.add(new Movie("Pulp Fiction", q_Tarantino, List.of(j_Travolta, u_Thurman)));
        moviesLibrary.add(new Movie("Hobbit - An Unexpected Jorney", RidleyScott, List.of(k_Knightley, DerecJacob)));
        moviesLibrary.add(new Movie("Poranek Kojota", p_Jackson, List.of(RusellCrowe, o_Bloom)));
        moviesLibrary.add(new Movie("Transformers", q_Tarantino, List.of(RusellCrowe, DerecJacob)));
        moviesLibrary.add(new Movie("Top Gun", RidleyScott, List.of(RusellCrowe, t_Cruze)));
        moviesLibrary.add(new Movie("Desperado", RidleyScott, List.of(RusellCrowe, o_Bloom)));
        moviesLibrary.add(new Movie("Mission Impossible", p_Jackson, List.of(RusellCrowe, t_Cruze)));
        moviesLibrary.add(new Movie("Forest Gump", g_Verbinski, List.of(OliverReed, h_Keitel)));


        moviesLibrary.add(new Movie("Gladiator", RidleyScott, List.of(RusellCrowe, OliverReed, DerecJacob)));

    }

    public static List<Movie> getMoviesLibrary() {
        return moviesLibrary;
    }

    public void getRandomMovieInformation() {
        System.out.println(moviesLibrary.get(RandomDataHandler.getRandomMovieIndex()));
    }

    public void printActorRelateMovies() {
        Actor actor = UserInputHandler.getActorFromUser();
        var actorMovieList = getActorMovieList(actor);
        if (actorMovieList.isEmpty()) {
            System.out.println("Actor didn't play in any moviem from library");
        } else {
            System.out.println("Actor" + actor + "have played in following movies: ");
            for (String movie : actorMovieList) {
                System.out.println("\n" + movie);


            }
        }

    }

    private List<String> getActorMovieList(Actor actorToFind) {
        Predicate<Movie> moviePredicate = movie ->  movie.getListOFActors().stream()
                .anyMatch(actor1 -> actor.getFirstName().equals(actorToFind.getFirstName()) &&
                        actor1.getLastName().equals(actorToFind.getLastName()));
        return moviesLibrary.stream()
                .filter(moviePredicate)
                .map(Movie: :getTitle)


    }
}
