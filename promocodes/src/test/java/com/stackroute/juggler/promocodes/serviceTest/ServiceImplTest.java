//package com.stackroute.juggler.promocodes.serviceTest;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.stackroute.juggler.promocodes.domain.Promocodes;
//import com.stackroute.juggler.promocodes.repository.PromocodeRepository;
//import com.stackroute.juggler.promocodes.service.PromocodesServiceImpl;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//// @RunWith(MockitoJUnitRunner.class)
//public class ServiceImplTest {
//
//	@Mock
//	private PromocodeRepository promoRepo;
//
//	@InjectMocks
//	private PromocodesServiceImpl promoServiceImpl;
//
//	private Promocodes promocode;
//
//	@Before
//	public void setupMock() {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@Test
//	public void testMockCreation() {
//		Promocodes promocode=new Promocodes("1","FLAT100", null, null, 100);
//		 assertNotNull(promocode);
//		assertNotNull("jpaRepository creation fails: use @injectMocks on promoServiceImpl", promoRepo);
//	}
//
//	@Test
//	public void testSavePromocodeSuccess() throws Exception {
//		String code = "FLAT100";
//		int amount = 100;
//
//		Promocodes promocode = new Promocodes("1", code, null, null, amount);
//
//		when(promoRepo.save(promocode)).thenReturn(promocode);
//		Promocodes returnedpromo = promoServiceImpl.save(promocode);
//
//		assertEquals(returnedpromo, promocode);
//		verify(promoRepo, times(1)).save(promocode);
//
//		verify(promoRepo, times(1)).findById(promocode.getCodeId());
//
//	}
//}
