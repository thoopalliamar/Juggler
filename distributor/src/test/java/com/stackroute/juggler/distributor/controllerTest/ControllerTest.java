//package com.stackroute.juggler.distributor.controllerTest;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.verifyNoMoreInteractions;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
////
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.List;
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
//import com.stackroute.juggler.distributor.controller.MovieController;
//import com.stackroute.juggler.distributor.domain.Movie;
//import com.stackroute.juggler.distributor.services.Services;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(MovieController.class)
//public class ControllerTest {
//
//	private MockMvc movieMockMvc;
//
//	@MockBean
//	private Services movieServices;
//
//	@InjectMocks
//	private MovieController movieController;
//
//	static List<Movie> movies;
//
//	@Before
//	public void setUp() throws Exception {
//
//		MockitoAnnotations.initMocks(this);
//		movieMockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
//		movies = new ArrayList<>();
//	}
//
//	@Test
//	public void testGetAllMovies() throws Exception {
//		String actors = "ranveer";
//		String actress = "deepika";
//		String directors = "rajkumar";
//		String genres = "romance";
//		String languages = "Telugu";
//		LocalTime localTime2 = LocalTime.of(21, 30, 59, 11001);
//		LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
//		Movie movie = new Movie("1", "RamLeela", "something.com", actors, actress, directors, genres,
//				"A heroine mad for hero fights against all the hurdles and losses him", "14D", languages, localTime2,
//				firstDay_2014);
//
//		when(movieServices.getAllMovies()).thenReturn(null);
//		movieMockMvc.perform(get("/api/v1/movies")).andExpect(status().isOk());
//		verify(movieServices, times(1)).getAllMovies();
//		verifyNoMoreInteractions(movieServices);
//
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
