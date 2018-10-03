//package com.stackroute.juggler.servicestest;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import com.stackroute.juggler.kafka.domain.User;
//import com.stackroute.juggler.repository.UserDao;
//import com.stackroute.juggler.service.impl.UserServiceImpl;
//
////class to test Login Service
//public class LoginServicesTest {
//
//	@Mock
//	private UserDao userDao;
//	@InjectMocks
//	private UserServiceImpl userServiceImpl;
//	private User user;
//
//	@Before
//	public void setupMock() {
//		MockitoAnnotations.initMocks(this);
//		user = new User(1L, "vishnu", "123", null, "user", null);
//	}
//
//	@Test
//	public void test() throws Exception {
//		when(userDao.findByEmail("vishnu")).thenReturn(user);
//		User user = userServiceImpl.findByEmail("vishnu");
//		assertEquals("123", user.getPassword());
//	}
//}