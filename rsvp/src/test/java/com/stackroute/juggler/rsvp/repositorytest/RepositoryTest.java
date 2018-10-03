//
//package com.stackroute.juggler.rsvp.repositorytest;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.stackroute.juggler.rsvp.domain.EventDetails;
//import com.stackroute.juggler.rsvp.repository.EventRepository;
//
//
//// class to test Login Repository
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//public class RepositoryTest {
//
//	@Autowired
//	private transient EventRepository repo;
//
//	public void setRepo(final EventRepository repo) {
//		this.repo = repo;
//	}
//
//	@Test
//	public void testSaveEvent() throws Exception {
//
//		repo.save(new EventDetails("1","vv","3concert","live concert", new String [] {"amarnath","saketh","eshu"},"31-09-2018",3,"18:00",
//				"03:00","bvavmvXN,A","hai@gmail.com",new String [] {"amar@gmail.com","sai@gmail.com"},898989898D));
//		final EventDetails eventDetails = repo.getByEmailId("ler@gmail.com");
//		assertThat(eventDetails.getEventName()).isEqualTo("2concert");
//
//	}
//
//}
