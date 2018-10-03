//package com.stackroute.juggler.repositorytest;
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
//import com.stackroute.juggler.kafka.domain.User;
//import com.stackroute.juggler.repository.UserDao;
//
//// class to test Login Repository
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@SpringBootTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//public class LoginRepositoryTest {
//
//	@Autowired
//	private transient UserDao repo;
//
//	public void setRepo(final UserDao repo) {
//		this.repo = repo;
//	}
//
//	@Test
//	public void testSaveUser() throws Exception {
//
//		repo.save(new User(1L, "vishnu", "123", null, "user", null));
//		final User user = repo.findByEmail("vishnu");
//		assertThat(user.getPassword()).isEqualTo("123");
//
//	}
//
//}
