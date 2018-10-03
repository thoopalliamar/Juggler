//package com.stackroute.juggler.userprofile;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;import com.stackroute.juggler.kafka.domain.InputUser;
//import com.stackroute.juggler.userprofile.repository.UserRepository;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//public class UserProfileRepoTest {
//
//	private transient UserRepository userrepo;
//
//	@Autowired
//	public void setMovieRepositary(final UserRepository userrepo) {
//		this.userrepo = userrepo;
//	}
//
//	@Test
//	public void testSaveUser() throws Exception {
//		userrepo.save(new InputUser("1", null, null, 0, null, null, null, null, null, null, null, null));
//		final InputUser user = userrepo.findByUserId("1");
//		assertThat(user.getUserId()).isEqualTo("1");
//	}
//
//
//}
