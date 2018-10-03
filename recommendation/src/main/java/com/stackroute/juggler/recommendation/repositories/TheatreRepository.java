package com.stackroute.juggler.recommendation.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.stackroute.juggler.recommendation.domain.Theatre;

public interface TheatreRepository extends Neo4jRepository<Theatre, String>{

}
