package org.example;

import org.example.model.User;
import org.example.service.MovieService;
import org.example.service.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieService movieService = new MovieService();
        UserService userService = new UserService();
        movieService.initMovies();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your email for registration");
        String email = scanner.nextLine();
        userService.register(new User(email));

        while(true){
            System.out.println("\nMenu: ");
            System.out.println("1. Search movies");
            System.out.println("2. Add movie to favorite");
            System.out.println("3. Remove movie from favorite");
            System.out.println("4. List favorite movies");
            System.out.println("5. Search favorite movies");
            System.out.println("6. Show personal details");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 1){
                System.out.println("Search by (all, title, cast, category): ");
                String searchBy = scanner.nextLine();
                String query = "";

                if(!searchBy.equalsIgnoreCase("all")) {
                    System.out.println("Enter your query: ");
                    query = scanner.nextLine();
                }
                movieService.searchMovie(query, searchBy);
            }
            else if(choice == 2){
                System.out.println("Enter movie title to add to favorite: ");
                String title = scanner.nextLine();
                movieService.addMovieToFavoriteByTitle(title);
            }
            else if(choice == 3){
                System.out.println("Enter movie title to remove from favorites : ");
                String title = scanner.nextLine();
                movieService.removeMovieFromFavoriteByTitle(title);
            }
            else if(choice == 4){
                userService.showFavoriteMovies();
            }
            else if(choice == 5){
                System.out.println("Search favorite movies by (title, cast, category) : ");
                String searchBy = scanner.nextLine();
                System.out.println("Enter your query : ");
                String query = scanner.nextLine();
                userService.searchFavoriteMovie(query, searchBy);
            }
            else if(choice == 6){
                userService.showPersonalDetails();
            }
            else if(choice == 7){
                System.out.println("Exiting ...");
                return;
            }
            else{
                System.out.println("Invalid choice");
            }
        }
    }
}