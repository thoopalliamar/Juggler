//package com.stackroute.juggler.promocodes.controllerTest;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import org.springframework.http.MediaType;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.juggler.promocodes.controller.PromocodesController;
//import com.stackroute.juggler.promocodes.domain.Promocodes;
//import com.stackroute.juggler.promocodes.service.PromocodesService;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(PromocodesController.class)
//public class ControllerTest {
//	private MockMvc movieMockMvc;
//
//	@MockBean
//	private PromocodesService promoService;
//
//	@InjectMocks
//	private PromocodesController promoController;
//
//	private Promocodes promocode;
//
//	// static List<Theatre> theatres;
//
//	@Before
//	public void setUp() throws Exception {
//
//		MockitoAnnotations.initMocks(this);
//		String code = "FLAT100";
//
//		promocode = new Promocodes("802", code, code, code, 0);
//		movieMockMvc = MockMvcBuilders.standaloneSetup(promoController).build();
//	}
//	@Test
//	public void testSaveNewTheatre() throws Exception {
//
//		String code = "FLAT100";
//		promocode = new Promocodes("802", code, code, code, 0);
//
//		when(promoService.save(promocode)).thenReturn(promocode);
//		movieMockMvc
//				.perform(post("/api/v1/promo").contentType(MediaType.APPLICATION_JSON).content(asJsonString(promocode)))
//				.andExpect(status().isOk()).andDo(print());
//		verify(promoService, times(1)).save(Mockito.any(Promocodes.class));
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
