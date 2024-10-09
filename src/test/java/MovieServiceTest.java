import org.example.model.Movie;
import org.example.model.User;
import org.example.service.MovieService;
import org.example.service.UserService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MovieServiceTest {

    private MovieService movieService = new MovieService();
    private UserService userService = new UserService();

    Movie spiderMan = new Movie(1,"Spiderman","Tobey", "Action");
    Movie superman = new Movie(2,"Superman","Henry Cavill", "Action");
    Movie batman = new Movie(3,"Batman","Christian Bale", "Action");
    Movie ironMan = new Movie(4,"Iron Man","Robert", "Action");

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
    public void returnNoResultWhenTitleNotMatched() throws Exception{
        List<Movie> movieList = movieService.findByTitle("abc");
        assertEquals(0, movieList.size());
    }

    @Test
    public void returnResultWhenTitleMatched() throws Exception{
        List<Movie> movieList = movieService.findByTitle("man");
        assertEquals(4, movieList.size());
    }

    @Test
    public void returnNoResultWhenCastNotMatched() throws Exception{
        List<Movie> movieList = movieService.findByCast("abc");
        assertEquals(0, movieList.size());
    }

    @Test
    public void returnResultWhenCastMatched() throws Exception{
        List<Movie> movieList = movieService.findByCast("henry");
        assertEquals(1, movieList.size());
    }

    @Test
    public void returnNoResultWhenCategoryNotMatched() throws Exception{
        List<Movie> movieList = movieService.findByCategory("drama");
        assertEquals(0, movieList.size());
    }

    @Test
    public void returnResultWhenCategoryMatched() throws Exception{
        List<Movie> movieList = movieService.findByCategory("action");
        assertEquals(4, movieList.size());
    }

    @Test
    public void returnResultWhenCategoryMatchedInAscendingOrderByTitle() throws Exception{
        List<Movie> expectedList = Arrays.asList(batman, ironMan, spiderMan, superman);
        List<Movie> movieList = movieService.findByCategory("action");
        assertEquals(expectedList, movieList);
    }

    @Test
    public void returnNoUserIfRegistrationIsFailed() throws Exception{
        User jack = new User("jack@gmail.com");
        User user = userService.register(jack);
        assertNull(user);
    }

    @Test
    public void returnUserIfRegistrationIsSuccessful() throws Exception{
        User mark = new User("mark@gmail.com");
        User user = userService.register(mark);
        assertEquals(mark, user);
    }

    @Test
    public void returnMovieDetailsIfIdFound() throws Exception{
        Movie movie = movieService.findMovieDetailsById(1);
        assertNotNull(movie);
    }

    @Test
    public void returnNoMovieIfIdNotFound() throws Exception{
        assertNull(movieService.findMovieDetailsById(100));
    }

}
