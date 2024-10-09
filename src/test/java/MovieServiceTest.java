import org.example.model.Movie;
import org.example.service.MovieService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MovieServiceTest {

    MovieService movieService = new MovieService();

    @Before
    public void setMovieList(){
        movieService.addMovie(new Movie("Spiderman","Tobey", "Action"));
        movieService.addMovie(new Movie("Superman","Henry Cavill", "Action"));
        movieService.addMovie(new Movie("Batman","Christian Bale", "Action"));
        movieService.addMovie(new Movie("Iron Man","Robert", "Action"));
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
}
