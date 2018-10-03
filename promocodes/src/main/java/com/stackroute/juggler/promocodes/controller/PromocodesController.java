package com.stackroute.juggler.promocodes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.juggler.promocodes.domain.Promocodes;
import com.stackroute.juggler.promocodes.service.PromocodesServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1")
public class PromocodesController {
	PromocodesServiceImpl promoservice;

	@Autowired
	public PromocodesController(PromocodesServiceImpl promoservice) {
		this.promoservice = promoservice;
	}

	@GetMapping(value = "/promocode/{code}")
	public ResponseEntity<?> getBycode(@PathVariable String code) {
		System.out.println("inside controller " + code);

		Promocodes prom = promoservice.getBycode(code);
		System.out.println("checking Promo code " + prom);
		if (prom == null) {
			return new ResponseEntity<String>("Promo Code is invalid ", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Promocodes>(prom, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/promocode", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> savePromocode(@RequestBody Promocodes promocode) {

		Promocodes promo = promoservice.save(promocode);
		return new ResponseEntity<Promocodes>(promo, HttpStatus.OK);
	}

	@RequestMapping(value = "/promocodes", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<?> getallpromocodes() {

		Iterable<Promocodes> promocodes = promoservice.getallpromocode();
		return new ResponseEntity<Iterable<Promocodes>>(promocodes, HttpStatus.OK);
	}

}
