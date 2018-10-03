//package com.stackroute.juggler.distributor.repository;
//
//import static org.junit.Assert.assertThat;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.Month;
//
//
//import static org.assertj.core.api.Assertions.assertThat;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.stackroute.juggler.distributor.domain.Movie;
//import com.stackroute.juggler.distributor.repositary.MovieRepositary;
//
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//public class RepositoryTest {
//
//
//	private transient MovieRepositary movieRepositary;
//	@Autowired
//	public void setMovieRepositary(final MovieRepositary movieRepositary) {
//		this.movieRepositary = movieRepositary;
//	}
//
//	@Test
//	public void testSaveMovie() throws Exception {
//		String actors = "ranveer";
//		String actress = "deepika";
//		String directors = "rajkumar";
//		String genres = "romance";
//		String languages = "Telugu";
//		LocalTime localTime2 = LocalTime.of(21, 30, 59, 11001);
//		LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
//		movieRepositary.save(new Movie("1","RamLeela","something.com",actors,actress,directors,genres,"A heroine mad for hero fights against all the hurdles and losses him","14D",languages,localTime2,firstDay_2014));
//		final Movie movie = movieRepositary.getById("1");
//		assertThat(movie.getMovieName()).isEqualTo("RamLeela");
//	}
//
//}