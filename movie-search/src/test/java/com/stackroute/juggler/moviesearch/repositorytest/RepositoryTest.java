//package com.stackroute.juggler.moviesearch.repositorytest;
//import static org.junit.Assert.assertThat;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.Month;
//import static org.assertj.core.api.Assertions.assertThat;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.stackroute.juggler.moviesearch.domain.Movie;
//import com.stackroute.juggler.moviesearch.repository.MovieRepository;
//
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//public class RepositoryTest {
//    private transient MovieRepository movieRepositary;
//    @Autowired
//    public void setMovieRepositary(final MovieRepository movieRepositary) {
//        this.movieRepositary = movieRepositary;
//    }
//    @Test
//    public void testSaveMovie() throws Exception {
//        String[] actors = new String [] {"sathwik"};
//        String[] actress = new String [] {"leela"};
//        String[] directors = new String [] {"sai"};
//        String[] genres = new String [] {"romance"};
//        String[] languages = new String [] {"Telugu"};
//       
//        assertThat(movie.getMovieName()).isEqualTo("RamLeela");
//    }
//}

