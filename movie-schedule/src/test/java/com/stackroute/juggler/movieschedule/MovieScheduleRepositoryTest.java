//package com.stackroute.juggler.movieschedule;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import java.util.HashMap;
//import java.util.Map;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.stackroute.juggler.kafka.domain.Movie;
//import com.stackroute.juggler.kafka.domain.MovieSchedule;
//import com.stackroute.juggler.kafka.domain.TicketPrices;
//import com.stackroute.juggler.movieschedule.repository.MovieScheduleRepository;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//public class MovieScheduleRepositoryTest {
//
//	private transient MovieScheduleRepository movieRepositary;
//	@Autowired
//	public void setMovieRepositary(final MovieScheduleRepository movieRepositary) {
//		this.movieRepositary = movieRepositary;
//	}
//	@Test
//	public void testSaveMovie() throws Exception {
//		String theatreId = new String("1");
//		String theatreName = new String("PVR");
//		String theatreLocation = new String("Koramangala");
//		String theatreCity = new String("Bangalore");
//		String theatreLicenseNo = new String("L100A");
//		String numberOfSeats = new String("100");
//		Map<String, Integer> seats = new HashMap<String, Integer>();
//		seats.put("Platinum", 40);
//		seats.put("Gold", 60);
//		String[] screenedmovies = new String[] { "abcd", "Avengers" };
//		String[] runningmovies = new String[] { "Batman" };
//		Movie movie = new Movie("1", "Batman", "url", "bcd", "abcd", "xyz", "action", "aeiou",
//				"2D", "English", "02:00:00", "2018-08-29");
//		int showNumbers = 4;
//		String showTimings = new String ("10:00, 13:00, 18:00, 22:00");
//		TicketPrices ticketPrices = new TicketPrices(150, 100);
//		movieRepositary.save(
//				new MovieSchedule(theatreId, theatreName, theatreLocation, theatreCity, theatreLicenseNo, numberOfSeats,
//						seats, screenedmovies, runningmovies, movie, showNumbers, showTimings, ticketPrices));
//		final MovieSchedule movie1 = movieRepositary.getByTheatreName(theatreName);
//		assertThat(movie1.getTheatreName()).isEqualTo(theatreName);
//	}
//
//}
