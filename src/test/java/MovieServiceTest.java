import org.example.model.Movie;
import org.example.model.User;
import org.example.service.MovieService;
import org.example.service.UserService;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MovieServiceTest {

    private MovieService movieService = new MovieService();
    private UserService userService = new UserService();

    Movie spiderMan = new Movie(1,"Spiderman","Tobey", "Action","10/10/2003",1000000000D);
    Movie superman = new Movie(2,"Superman","Henry Cavill", "Action","11/09/2010",34345534D);
    Movie batman = new Movie(3,"Batman","Christian Bale", "Action","04/03/2004",25342423434D);
    Movie ironMan = new Movie(4,"Iron Man","Robert", "Action","20/12/2009",23423423332D);

    @Before
    public void setMovieList(){
        movieService.addMovie(spiderMan);
        movieService.addMovie(superman);
        movieService.addMovie(batman);
        movieService.addMovie(ironMan);
    }

    @Before
    public void setUserList(){
        User jack = new User("jack@gmail.com");
        User ross = new User("ross@gmail.com");
        User andrew = new User("andrew@gmail.com");
        userService.register(jack);
        userService.register(ross);
        userService.register(andrew);
    }

    @Test
    public void returnNoResultWhenTitleNotMatched() {
        List<Movie> movieList = movieService.findByTitle("abc");
        assertEquals(0, movieList.size());
    }

    @Test
    public void returnResultWhenTitleMatched() {
        List<Movie> movieList = movieService.findByTitle("man");
        assertEquals(4, movieList.size());
    }

    @Test
    public void returnNoResultWhenCastNotMatched() {
        List<Movie> movieList = movieService.findByCast("abc");
        assertEquals(0, movieList.size());
    }

    @Test
    public void returnResultWhenCastMatched() {
        List<Movie> movieList = movieService.findByCast("henry");
        assertEquals(1, movieList.size());
    }

    @Test
    public void returnNoResultWhenCategoryNotMatched(){
        List<Movie> movieList = movieService.findByCategory("drama");
        assertEquals(0, movieList.size());
    }

    @Test
    public void returnResultWhenCategoryMatched(){
        List<Movie> movieList = movieService.findByCategory("action");
        assertEquals(4, movieList.size());
    }

    @Test
    public void returnResultWhenCategoryMatchedInAscendingOrderByTitle() {
        List<Movie> expectedList = Arrays.asList(batman, ironMan, spiderMan, superman);
        List<Movie> movieList = movieService.findByCategory("action");
        assertEquals(expectedList, movieList);
    }

    @Test
    public void returnNoUserIfRegistrationIsFailed(){
        User jack = new User("jack@gmail.com");
        User user = userService.register(jack);
        assertNull(user);
    }

    @Test
    public void returnUserIfRegistrationIsSuccessful() {
        User mark = new User("mark@gmail.com");
        User user = userService.register(mark);
        assertEquals(mark, user);
    }

    @Test
    public void returnMovieDetailsIfIdFound() {
        Movie movie = movieService.findMovieDetailsById(1);
        assertNotNull(movie);
    }

    @Test
    public void returnNoMovieIfIdNotFound() {
        assertNull(movieService.findMovieDetailsById(100));
    }

    @Test
    public void showMovieDetailsById() {
        assertNotNull(movieService.showMovieDetailsById(1));
    }

    @Test
    public void testAddMovieToFavorite() {
        userService.addToFavorite(spiderMan);
        assertEquals(1, userService.currentUser.getFavoriteMovies().size());
        assertEquals("Spiderman", userService.currentUser.getFavoriteMovies().get(0).title());
    }

    @Test
    public void testRemoveMovieFromFavorite() {
        userService.addToFavorite(spiderMan);
        userService.removeFromFavorite(spiderMan);
        assertEquals(0, userService.currentUser.getFavoriteMovies().size());
    }

    @Test
    public void testShowingPersonalDetails() {
        userService.register(new User("rizwan@gmail.com"));
        userService.addToFavorite(batman);
        userService.addToFavorite(spiderMan);
        assertEquals("rizwan@gmail.com", userService.currentUser.getEmail());
        assertEquals(2, userService.currentUser.getFavoriteMovies().size());
        assertNotNull(userService.showPersonalDetails());
    }

    @Test
    public void returnNoResultWhenTitleNotExactMatched(){
        Movie movie = movieService.findByTitleExactMatched("man");
        assertNull(movie);
    }

    @Test
    public void returnResultWhenTitleExactMatched(){
        Movie movie = movieService.findByTitleExactMatched("Spiderman");
        assertNotNull(movie);
    }

    @Test
    public void returnNoResultWhenTitleNotMatchedForFavorites(){
        userService.addToFavorite(spiderMan);
        List<Movie> favoriteList = userService.findByTitleForFavorite("abc");
        assertEquals(0, favoriteList.size());
    }

    @Test
    public void returnResultWhenTitleMatchedForFavorites(){
        userService.addToFavorite(spiderMan);
        List<Movie> favoriteList = userService.findByTitleForFavorite("man");
        assertEquals(1, favoriteList.size());
    }
}
