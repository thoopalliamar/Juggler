package com.stackroute.juggler.recommendation.services;
import com.stackroute.juggler.recommendation.domain.Language;

public interface LanguageService {
	public Language findBylanguageName(String languageName);
}
