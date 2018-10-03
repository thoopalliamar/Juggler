//package com.stackroute.juggler.theatreregistration.controllertest;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.verifyNoMoreInteractions;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.juggler.theatreregistration.controller.RegistrationController;
//import com.stackroute.juggler.kafka.domain.Theatre;
//
//import com.stackroute.juggler.theatreregistration.services.RegistrationService;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(RegistrationController.class)
//public class ControllerTest {
//
//	private MockMvc theatreMockMvc;
//
//	@MockBean
//	private RegistrationService registrationService;
//
//	@InjectMocks
//	private RegistrationController registrationController;
//
//	private Theatre theatre;
//
//	static List<Theatre> theatres;
//
//	@Before
//	public void setUp() throws Exception {
//
//		MockitoAnnotations.initMocks(this);
//		Map<String, Integer> map = new HashMap<>();
//		map.put("platinum", 50);
//		map.put("gold", 25);
//		map.put("silver", 25);
//
//		String[] sm = new String[] { "null value" };
//		String[] rm = new String[] { "null" };
//
//		theatre = new Theatre("802", "koramangala-5-67", "chennai", "xyz", "7", "100", map, sm, rm, null);
//		theatreMockMvc = MockMvcBuilders.standaloneSetup(registrationController).build();
//		theatres = new ArrayList<>();
//		theatre = new Theatre("802", "koramangala-5-67", "chennai", "ABC", "7", "100", map, sm, rm, null);
//		theatres.add(theatre);
//		theatre = new Theatre("802", "koramangala-5-67", "chennai", "LMN", "7", "100", map, sm, rm, null);
//		theatres.add(theatre);
//	}
//
//	@Test
//	public void testSaveNewTheatre() throws Exception {
//		Map<String, Integer> map = new HashMap<>();
//		map.put("platinum", 50);
//		map.put("gold", 25);
//		map.put("silver", 25);
//
//		String[] sm = new String[] { "null value" };
//		String[] rm = new String[] { "null" };
//
//		theatre = new Theatre("802", "koramangala-5-67", "chennai", "xyz", "7", "100", map, sm, rm, null);
//
//		when(registrationService.saveTheatre(theatre)).thenReturn(theatre);
//		theatreMockMvc
//				.perform(post("/api/v1/theatre").contentType(MediaType.APPLICATION_JSON).content(asJsonString(theatre)))
//				.andExpect(status().isOk()).andDo(print());
//		verify(registrationService, times(1)).saveTheatre(Mockito.any(Theatre.class));
//	}
//
//	@Test
//	public void testFetchTheatreByName() throws Exception {
//
//		Map<String, Integer> map = new HashMap<>();
//		map.put("platinum", 50);
//		map.put("gold", 25);
//		map.put("silver", 25);
//
//		String[] sm = new String[] { "temper", "billa" };
//		String[] rm = new String[] { "geetha govindham", "Antman" };
//
//		theatre = new Theatre("802", "koramangala-5-67", "chennai", "xyz", "7", "100", map, sm, rm, null);
//
//		when(registrationService.getByTitle("xyz")).thenReturn(theatres.get(0));
//		theatreMockMvc.perform(get("/api/v1/theatre/{TheatreTitle}", "xyz")).andExpect(status().isOk());
//		verify(registrationService, times(1)).getByTitle("xyz");
//		verifyNoMoreInteractions(registrationService);
//	}
//
//	@Test
//	public void testUpdateTheatreByName() throws Exception {
//
//		Map<String, Integer> map = new HashMap<>();
//		map.put("platinum", 50);
//		map.put("gold", 25);
//		map.put("silver", 25);
//
//		String[] sm = new String[] { "temper", "billa" };
//		String[] rm = new String[] { "geetha govindham", "Antman" };
//
//		theatre = new Theatre("802", "koramangala-5-67", "chennai", "xyz", "7", "100", map, sm, rm, null);
//
//		when(registrationService.updateTheatre(theatre)).thenReturn(theatre);
//		theatreMockMvc.perform(put("/api/v1/theatre").contentType(MediaType.APPLICATION_JSON)
//				.content(asJsonString(theatre))).andExpect(status().isOk()).andDo(print());
//		// verify(registrationService, times(1)).updateTheatre(theatre);
//		// verifyNoMoreInteractions(registrationService);
//	}
//
//	public static String asJsonString(final Object obj) {
//		try {
//			return new ObjectMapper().writeValueAsString(obj);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//}
