//package com.stackroute.juggler.userprofile;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.Optional;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import com.stackroute.juggler.kafka.domain.InputUser;
//import com.stackroute.juggler.userprofile.repository.UserRepository;
//import com.stackroute.juggler.userprofile.service.UserServiceImpl;
//
//public class UserProfileServiceTest {
//	
//	@Mock
//	private UserRepository userRepo;
//
//	@InjectMocks
//	private UserServiceImpl userServiceImpl;
//
//	private InputUser user;
//
//	Optional<InputUser> options;
//
//	@Before
//	public void setupMock() {
//		MockitoAnnotations.initMocks(this);
//		// movieServiceImpl = new MovieServiceImpl(movieRepo);
//		user = new InputUser("1", null, null, 0, null, null, null, null, null, null, null, null);
//		options = Optional.of(user);
//
//	}
//
//	@Test
//	public void testMockCreation() {
//		assertNotNull(user);
//		assertNotNull("jpaRepository creation fails: use @injectMocks on movieServicempl", userRepo);
//	}
//
//	@Test
//	public void testSaveMovieSuccess() throws Exception {
//		when(userRepo.save(user)).thenReturn(user);
//		InputUser flag = userServiceImpl.saveUser(user);
//		assertEquals( flag.getUserId(),user.getUserId());
//		verify(userRepo, times(1)).save(user);
//		verify(userRepo, times(1)).findByUserId(user.getUserId());
//	}
//
//
//}
