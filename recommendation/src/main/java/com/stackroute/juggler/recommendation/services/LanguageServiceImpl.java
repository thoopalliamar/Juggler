package com.stackroute.juggler.recommendation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.juggler.recommendation.domain.Language;
import com.stackroute.juggler.recommendation.repositories.LanguageRepository;

@Service
public class LanguageServiceImpl implements LanguageService {

	private LanguageRepository languageRepository;

	@Autowired
	public LanguageServiceImpl(LanguageRepository languageRepository) {
		super();
		this.languageRepository = languageRepository;
	}

	@Override
	public Language findBylanguageName(String languageName) {

		return languageRepository.findByName(languageName);
	}

}
