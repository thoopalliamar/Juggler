//package com.stackroute.juggler.promocodes.repositoryTest;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertThat;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import com.stackroute.juggler.promocodes.domain.Promocodes;
//import com.stackroute.juggler.promocodes.repository.PromocodeRepository;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//public class RepositoryTest {
//
//	private transient PromocodeRepository promoRepositary;
//
//	@Autowired
//	public void setMovieRepositary(final PromocodeRepository promoRepositary) {
//		this.promoRepositary = promoRepositary;
//	}
//
//	@Test
//	public void testSavePromo() throws Exception {
//
//		promoRepositary.save(new Promocodes("1", "FLAT100", null, null, 100));
//		final Promocodes promo = promoRepositary.getBycode("FLAT100");
//		assertThat(promo.getCode()).isEqualTo("FLAT100");
//	}
//}
