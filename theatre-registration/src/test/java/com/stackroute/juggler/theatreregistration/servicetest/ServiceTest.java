//package com.stackroute.juggler.theatreregistration.servicetest;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.io.File;
//import java.util.HashMap;
//import java.util.Map;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.stackroute.juggler.kafka.domain.Theatre;
//import com.stackroute.juggler.theatreregistration.repository.RegistrationRepository;
//import com.stackroute.juggler.theatreregistration.services.RegistrationService;
//import com.stackroute.juggler.theatreregistration.services.RegistrationServiceImpl;
//
//@RunWith(SpringRunner.class)
////@SpringBootTest
////@RunWith(MockitoJUnitRunner.class)
//public class ServiceTest {
//
//	@Mock
//	private RegistrationRepository theatreRepo;
//
//	@InjectMocks
//	private RegistrationServiceImpl theatreServiceImpl;
//
//	private Theatre theatre;
//
//	@Before
//	public void setupMock() {
//		MockitoAnnotations.initMocks(this);
//
//	}
//
//	@Test
//	public void testMockCreation() {
//
//		Map<String, Integer> map = new HashMap<>();
//		map.put("platinum", 50);
//		map.put("gold", 25);
//		map.put("silver", 25);
//
//		String[] sm = new String[] { "temper","billa" };
//		String[] rm = new String[] { "geetha govindham","Antman" };
//
//		theatre = new Theatre("802", "koramangala-5-67", "chennai", "xyz", "7", "100", map, sm, rm, null);
//		
//		 assertNotNull(theatre);
//		assertNotNull("jpaRepository creation fails: use @injectMocks on movieServicempl", theatreRepo);
//	}
////
////	@Test
////	public void testSaveTheatreSuccess() throws Exception {
////		Map<String, Integer> map = new HashMap<>();
////		map.put("platinum", 50);
////		map.put("gold", 25);
////		map.put("silver", 25);
////		String[] sm = new String[] { "temper", "billa" };
////		String[] rm = new String[] { "geetha govindham", "Antman" };
////		File seating = new File("layout");
////		Theatre theatre = new Theatre("802", "koramangala-5-67", "chennai", "xyz", "7", "100", map, sm, rm,
////				seating);
////		when(theatreRepo.save(theatre)).thenReturn(theatre);
////		Theatre returnedtheatre = theatreServiceImpl.saveTheatre(theatre);
////		assertEquals(returnedtheatre, theatre);
////		 verify(theatreRepo, times(1)).save(theatre);
////
//////	verify(theatreRepo, times(1)).findById(theatre.getId());
////	}
////	
//
//	
////	@Test
////	public void testGetTheatre() {
////		Map<String, Integer> map = new HashMap<>();
////		map.put("platinum", 50);
////		map.put("gold", 25);
////		map.put("silver", 25);
////		String[] sm = new String[] { "temper", "billa" };
////		String[] rm = new String[] { "geetha govindham", "Antman" };
////		File seating = new File("layout");
////		Theatre theatre = new Theatre("802", "koramangala-5-67", "chennai", "xyz", "7", "100", map, sm, rm,
////				seating);
////		
////		theatreRepo.save(theatre);
////		when(theatreRepo.existsByTheatreName("xyz")).thenReturn(true);
////		Theatre theatre1 =theatreServiceImpl.getByTitle("xyz");
////		assertEquals("fetching theatre by name failed", theatre1, theatre);
////		verify(theatreRepo, times(1)).existsByTheatreName(theatre.getTheatreName());
////	}
//
//	
//	
//	
//	
//
//}
