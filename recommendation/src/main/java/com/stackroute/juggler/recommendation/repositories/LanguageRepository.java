package com.stackroute.juggler.recommendation.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.recommendation.domain.Language;

@Repository
public interface LanguageRepository extends Neo4jRepository<Language, Long> {
	public Language findByName(String name);
}
