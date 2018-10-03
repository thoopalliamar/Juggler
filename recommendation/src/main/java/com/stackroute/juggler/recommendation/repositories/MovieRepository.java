package com.stackroute.juggler.recommendation.repositories;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.recommendation.domain.Movie;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Long> {
//	Movie findByMovieTitle(String name);
//	@Query("match (u:User{userName})-[:FOLLOWS]->(Genre{genreName})<-[:IS_OF_TYPE]-(m1:Movie),(u)-[:LIVES_IN]->(City{cityName})<-[:RELEASED_IN]-(m1:Movie) where u.age<13 return m1")
//	List<Movie> getByGenreAgeCity(@Param("userName") String userName,@Param("genreName")String genreName,@Param("cityName")String cityName);
//	Movie saveMovie(Movie movie);
//	List<Movie> findByGenres(String genres);
//	@Query("MATCH (m:Movie) WHERE m.name ={name} RETURN m")
//	Movie findByName(@Param("name") String name);

//	@Query("Match (m:Movie) WHERE m.id ={id} RETURN m")
//	Movie findById(@Param("id") int id);

//	@Query("Match (c:City) ,(m:Movie) where c.name={name} and m.name={movieName} with m,c merge (m)-[releasedIn]->(c)")
//	void releasedIn(@Param("name") String name, @Param("name") String movieName);
	@Query("Match (u:User)-[:follows]->(g:Genre)<-[:isTypeOf]-(r:Movie) where u.emailId={emailId} Match (r)-[:releasedIn]->(c:City)<-[:livesIn]-(u) return (r)")
	List<Movie> getGenreBasedMoviesForUser(@Param("emailId") String emailId);

//	@Query("MATCH (m:Movie)-[r:isTypeOf]->(g:Genre) where g.name={genreName} RETURN m")
//	List<Movie> getMoviesByGenre(@Param("genreName") String genreName);
//
//	@Query("MATCH (m:Movie)-[r:releasedIn]->(c:City) where c.name={cityName} RETURN m")
//	List<Movie> getMoviesByCity(@Param("cityName") String cityName);
//
//	@Query("MATCH (c:City)<- [:releasedIn]-(m:Movie)-[:isTypeOf]->(g:Genre) where g.name={genreName} and  c.name={cityName} RETURN m")
//	List<Movie> getMovieByCityGenre(@Param("cityName") String cityName, @Param("genreName") String genreName);
//
//	@Query("MATCH (c:City)<- [:releasedIn]-(m:Movie)-[:languageType]->(l:Language) where l.name={languageName} and  c.name={cityName} RETURN m")
//	List<Movie> getMovieByCityLanguage(@Param("cityName") String cityName, @Param("languageName") String languageName);
//
//	@Query("MATCH (g:Genre)<- [:isTypeOf]-(m:Movie)-[:languageType]->(l:Language) where g.name={genreName} and l.name={languageName} MATCH (m)-[:releasedIn]->(c:City)where c.name={cityName} RETURN m")
//	List<Movie> getMovieByCityGenreLanguage(@Param("cityName") String cityName, @Param("genreName") String genreName,
//			@Param("languageName") String languageName);
	@Query("Match (u:User)-[:follows]->(g:Genre)<-[:isTypeOf]-(r:Movie) where u.emailId={emailId} Match (r)-[:releasedIn]->(c:City)<-[:livesIn]-(u)  Match (r)-[:LanguageType]->(l:Language)<-[:preferredLanguage]-(u) return (r)")
    public List<Movie> getGenreLanguageBasedMoviesForUser(@Param("emailId") String emailId);
	@Query("Match (u:User)-[:preferredLanguage]->(l:Language)<-[:LanguageType]-(r:Movie) where u.emailId={emailId} Match (r)-[:releasedIn]->(c:City)<-[:livesIn]-(u) return (r)")
	List<Movie> getLanguageBasedMoviesForUser(@Param("emailId") String emailId);

	@Query("MATCH (m:Movie) WHERE m.name ={name} RETURN m")
	Movie findByName(@Param("name") String name);
}
