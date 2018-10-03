package com.stackroute.juggler.promocodes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.promocodes.domain.Promocodes;
import com.stackroute.juggler.promocodes.repository.PromocodeRepository;

@Service
public class PromocodesServiceImpl implements PromocodesService {

	private PromocodeRepository reomocoderepo;

	@Autowired
	public PromocodesServiceImpl(PromocodeRepository reomocoderepo) {
		this.reomocoderepo = reomocoderepo;

	}

	@Override
	public Promocodes save(Promocodes promocode) {
		Promocodes codes = reomocoderepo.save(promocode);
		return codes;
	}

	@Override
	public Promocodes getBycode(String code) {
		Promocodes codess = reomocoderepo.getBycode(code);
		return codess;
	}

	@Override
	public Iterable<Promocodes> getallpromocode() {
		Iterable<Promocodes> promocodes = reomocoderepo.findAll();
		return promocodes;
	}

//	@Override
//	public String delete(String code) {
//    reomocoderepo.deleteById(code);
//		return "deleted";
//	}

}
