import org.example.model.Movie;
import org.example.service.MovieService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MovieServiceTest {

    MovieService movieService = new MovieService();
    Movie spiderMan = new Movie("Spiderman","Tobey", "Action");
    Movie superman = new Movie("Superman","Henry Cavill", "Action");
    Movie batman = new Movie("Batman","Christian Bale", "Action");
    Movie ironMan = new Movie("Iron Man","Robert", "Action");

    @Before
    public void setMovieList(){
        movieService.addMovie(spiderMan);
        movieService.addMovie(superman);
        movieService.addMovie(batman);
        movieService.addMovie(ironMan);
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
    public void returnNoResultWhenCategoryMatchedInRandomOrderByTitle() throws Exception{
        List<Movie> expectedList = Arrays.asList(spiderMan, batman, ironMan, superman);
        List<Movie> movieList = movieService.findByCategory("action");
        assertEquals(expectedList, movieList);
    }

    @Test
    public void returnResultWhenCategoryMatchedInAscendingOrderByTitle() throws Exception{
        List<Movie> expectedList = Arrays.asList(batman, ironMan, spiderMan, superman);
        List<Movie> movieList = movieService.findByCategory("action");
        assertEquals(expectedList, movieList);
    }
}
