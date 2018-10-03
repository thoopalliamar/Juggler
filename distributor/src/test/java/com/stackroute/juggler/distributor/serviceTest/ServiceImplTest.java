//package com.stackroute.juggler.distributor.serviceTest;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.Month;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.stackroute.juggler.distributor.domain.Movie;
//import com.stackroute.juggler.distributor.repositary.MovieRepositary;
//import com.stackroute.juggler.distributor.services.Services;
//import com.stackroute.juggler.distributor.services.ServicesImpl;
//
//@RunWith(SpringRunner.class)
//// @RunWith(MockitoJUnitRunner.class)
//public class ServiceImplTest {
//
//	@Mock
//	private MovieRepositary movieRepo;
//
//	@InjectMocks
//	private ServicesImpl movieServiceImpl;
//
//	private Movie movie;
//
//	@Before
//	public void setupMock() {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@Test
//	public void testMockCreation() {
//		// assertNotNull(movie);
//		assertNotNull("jpaRepository creation fails: use @injectMocks on movieServicempl", movieRepo);
//	}
//
//	@Test
//	public void testSaveMovieSuccess() throws Exception {
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
//		when(movieRepo.save(movie)).thenReturn(movie);
//		Movie returnedmovie = movieServiceImpl.saveMovie(movie);
//
//		assertEquals("saving movie failed , the call to movieDAOImpl is returning false ,check this method", movie,
//				returnedmovie);
//		verify(movieRepo, times(1)).save(movie);
//
//	}
//
//}
