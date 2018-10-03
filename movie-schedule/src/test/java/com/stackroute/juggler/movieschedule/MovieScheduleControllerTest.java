//package com.stackroute.juggler.movieschedule;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.verifyNoMoreInteractions;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.juggler.kafka.domain.Movie;
//import com.stackroute.juggler.kafka.domain.MovieSchedule;
//import com.stackroute.juggler.kafka.domain.TicketPrices;
//import com.stackroute.juggler.movieschedule.controller.MovieScheduleController;
//import com.stackroute.juggler.movieschedule.service.MovieScheduleService;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(MovieScheduleController.class)
//public class MovieScheduleControllerTest {
//
//	private MockMvc movieMockMvc;
//
//	@MockBean
//	private MovieScheduleService movieService;
//
//	@InjectMocks
//	private MovieScheduleController movieController;
//
//	private MovieSchedule moviee;
//	static List<MovieSchedule> movies;
//
//	@Before
//    public void setUp() throws Exception {
//
//        MockitoAnnotations.initMocks(this);
//        movieMockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
//        movies = new ArrayList<>();
//    }
//
//	@Test
//	public void testSaveNewMovie() throws Exception {
//		String theatreId = new String("1");
//		String theatreName = new String("PVR");
//		String theatreLocation = new String("Koramangala");
//		String theatreCity = new String("Bangalore");
//		String theatreLicenseNo = new String("L100A");
//		String numberOfSeats = new String("100");
//		Map<String, Integer> seats = new HashMap<String, Integer>();
//		seats.put("Platinum", 40);
//		seats.put("Gold", 60);
//		String[] screenedmovies = new String[] {"abcd", "Avengers"};
//		String[] runningmovies = new String[] {"Batman"}; 
//		Movie movie = new Movie("1", "Batman", "url", "bcd", "abcd", "xyz", "action", "aeiou", "2D", "English", "02:00:00", "2018-08-29");
//		int showNumbers = 4;
//		String showTimings = new String ("10:00, 13:00, 18:00, 22:00");
//		TicketPrices ticketPrices = new TicketPrices(150, 100);
//		
//		moviee = new MovieSchedule(theatreId, theatreName, theatreLocation, theatreCity, theatreLicenseNo, numberOfSeats, seats, screenedmovies, runningmovies, movie, showNumbers, showTimings, ticketPrices);
//		when(movieService.addMovieSchedule(moviee)).thenReturn(moviee);
//		movieMockMvc.perform(post("/api/v1/add").contentType(MediaType.APPLICATION_JSON).content(asJsonString(movie)))
//				.andExpect(status().isOk()).andDo(print());
//		verify(movieService, times(1)).addMovieSchedule(Mockito.any(MovieSchedule.class));
//		when(movieService.getMoviesSchedule()).thenReturn(null);
//        movieMockMvc.perform(get("/api/v1/show")).andExpect(status().isOk());
//        verify(movieService, times(1)).getMoviesSchedule();
//        verifyNoMoreInteractions(movieService);
//	}
//
//	public static String asJsonString(final Object obj) {
//		try {
//			return new ObjectMapper().writeValueAsString(obj);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//}
