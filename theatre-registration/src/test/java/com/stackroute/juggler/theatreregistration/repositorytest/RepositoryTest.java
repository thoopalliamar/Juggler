//package com.stackroute.juggler.theatreregistration.repositorytest;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertEquals;
//
//import java.util.HashMap;
//import java.util.Map;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import com.stackroute.juggler.kafka.domain.Theatre;
//import com.stackroute.juggler.theatreregistration.repository.RegistrationRepository;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//
////class to test RegistrationRepository
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//
//public class RepositoryTest {
//
//	private transient RegistrationRepository repo;
//
//	// referencing RegistrationRepository object
//	@Autowired
//	public void setRegistrationRepository(final RegistrationRepository repo) {
//		this.repo = repo;
//	}
//
//	@Test
//	public void testSaveTheatre() throws Exception {
//		Map<String, Integer> map = new HashMap<>();
//		map.put("platinum", 50);
//		map.put("gold", 25);
//		map.put("silver", 25);
//		String[] sm = new String[] { "null value" };
//		String[] rm = new String[] { "null" };
//
//		repo.save(new Theatre("802", "koramangala-5-67", "chennai", "xyz", "7", "100", map, sm, rm, null));
//		final Theatre theatre = repo.getByTheatreName("xyz");
//		assertThat(theatre.getTheatreId()).isEqualTo("802");
//	}
//
//	@Test
//	public void testUpdateTheatre() throws Exception {
//		Map<String, Integer> map = new HashMap<>();
//		map.put("platinum", 50);
//		map.put("gold", 25);
//		map.put("silver", 25);
//		String[] sm = new String[] { "null value" };
//		String[] rm = new String[] { "null" };
//
//		repo.save(new Theatre("802", "koramangala-5-67", "chennai", "xyz", "7", "100", map, sm, rm, null));
//		final Theatre theatre = repo.getByTheatreName("xyz");
//		assertEquals(theatre.getTheatreId(), "802");
//		theatre.setTheatreName("pqrs");
//		// System.out.println(theatre.getComments());
//		repo.save(theatre);
//		final Theatre temp = repo.getByTheatreName("xyz");
//		assertEquals("pqrs", theatre.getTheatreName());
//	}
//
//	@Test
//	public void testGetTheatre() {
//		Map<String, Integer> map = new HashMap<>();
//		map.put("platinum", 50);
//		map.put("gold", 25);
//		map.put("silver", 25);
//		String[] sm = new String[] { "null value" };
//		String[] rm = new String[] { "null" };
//
//		repo.save(new Theatre("802", "koramangala-5-67", "chennai", "xyz", "7", "100", map, sm, rm, null));
//		final Theatre theatre = repo.getByTheatreName("xyz");
//		assertEquals(theatre.getTheatreId(), "802");
//	}
//
//}
