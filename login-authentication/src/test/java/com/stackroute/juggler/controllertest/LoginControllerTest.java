//package com.stackroute.juggler.controllertest;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.juggler.controller.UserController;
//import com.stackroute.juggler.kafka.domain.User;
//import com.stackroute.juggler.service.UserService;
//
////class to test LoginController
//@RunWith(SpringRunner.class)
//@WebMvcTest(UserController.class)
//public class LoginControllerTest {
//	private MockMvc mockMvc;
//	@InjectMocks
//	private UserController userController;
//	@MockBean
//	private UserService userService;
//	private User user;
//
//	@Before
//	public void setUp() throws Exception {
//		MockitoAnnotations.initMocks(this);
//		user = new User(1L, "vishnu", "123", null, "user", null);
//		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//	}
//
//	@Test
//	public void findByEmail() throws Exception {
//		when(userService.findByEmail("vishnu")).thenReturn(user);
//		mockMvc.perform(
//				post("/api/v1/juggler/user/login").contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//				.andExpect(status().isCreated()).andDo(print());
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