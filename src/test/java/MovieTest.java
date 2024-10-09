import org.example.model.Movie;
import org.example.service.MovieService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void returnNoResultWhenTitleNotMatched() throws Exception{
        MovieService movieService = new MovieService();

        List<Movie> movieList = movieService.findByTitle("something");

        assertEquals(movieList.size(), 0);
    }
}
