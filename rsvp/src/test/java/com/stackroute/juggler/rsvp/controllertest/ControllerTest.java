//package com.stackroute.juggler.rsvp.controllertest;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.verifyNoMoreInteractions;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
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
//import com.stackroute.juggler.rsvp.controller.EventDetailsController;
//import com.stackroute.juggler.rsvp.domain.EventDetails;
//import com.stackroute.juggler.rsvp.service.EventDetailsService;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(EventDetailsController.class)
//public class ControllerTest {
//
//	private MockMvc movieMockMvc;
//
//	@MockBean
//	private EventDetailsService eventDetailsService;
//
//	@InjectMocks
//	private EventDetailsController eventDetailsController;
//
//	static List<EventDetails> eventDetails;
//
//	@Before
//	public void setUp() throws Exception {
//
//		MockitoAnnotations.initMocks(this);
//		movieMockMvc = MockMvcBuilders.standaloneSetup(eventDetailsController).build();
//		eventDetails = new ArrayList<>();
//	}
//
//	@Test
//	public void testGetAllEvents() throws Exception {
//		String id="1";
//		String creatorOfEvent="vv";
//		String eventName="2concert";
//		String eventType="live concert";
//		String []guestsofEvent=new String [] {"amarnath","saketh","eshu"};
//		String eventDate="31-09-2018";
//		int noOfDays=3;
//		String eventTime="18:00";
//		String duration="03:00";
//		String eventSynopsis="bvavmvXN,A";
//		String emailId="ler@gmail.com";
//		String []invitiesMail=new String [] {"amar@gmail.com","sai@gmail.com"};
//		double phoneNo=898989898D;
//	EventDetails EventDetails =new EventDetails("1","vv","2concert","live concert", new String [] {"amarnath","saketh","eshu"},"31-09-2018",3,"18:00",
//		"03:00","bvavmvXN,A","ler@gmail.com",new String [] {"amar@gmail.com","sai@gmail.com"},898989898D);
//
//		when((eventDetailsService.getDetails())).thenReturn(null);
//		movieMockMvc.perform(get("/api/v1/events")).andExpect(status().isOk());
//		verify(eventDetailsService, times(1)).getDetails();
//		verifyNoMoreInteractions(eventDetailsService);
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
