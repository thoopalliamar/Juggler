package com.stackroute.juggler.promocodes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.stackroute.juggler.promocodes.domain.Promocodes;
import com.stackroute.juggler.promocodes.repository.PromocodeRepository;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

	PromocodeRepository promoRepository;

	@Autowired
	public CommandLineAppStartupRunner(PromocodeRepository promoRepository) {

		this.promoRepository = promoRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Promocodes promo1 = new Promocodes(1, "FLAT200",
				"https://image.ibb.co/bVnJ2U/pepperfry_Flat_Rs_200_off_on_Rs_400.jpg",
				"It is applicable from 1000Rs on ticket", 200);

		Promocodes promo2 = new Promocodes(2, "FLAT100",
				"http://4.bp.blogspot.com/-A3aLFetzU34/VhVklMdjOcI/AAAAAAAAASs/xPSWi_SyPuk/s1600/Untitled1865-358x256.png",
				"It is applicable from 500Rs on Ticket", 100);

		Promocodes promo3 = new Promocodes(3, "FLAT50", "https://image.ibb.co/cbhMp9/C6_JIlx_PWc_AAu_Kb_A_1.jpg",
				"It is applicable from 300Rs on ticket", 50);

		promoRepository.save(promo1);
		promoRepository.save(promo2);
		promoRepository.save(promo3);

	}
}
