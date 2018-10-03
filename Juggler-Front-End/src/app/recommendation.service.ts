import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { MovieDetails } from "./movieDetails";
import { map } from "rxjs/operators";
@Injectable({
  providedIn: "root"
})
export class RecommendationService {
  private recommended_url = "http://13.232.51.70:9078/recommendation/api/v1/";
  private genrebasedmovies_url =
    "http://13.232.51.70:9078/api/v1/getGenreBasedMoviesForUser/";
  private languagebasedmovies_url =
    "http://13.232.51.70:9078/api/v1/getLanguageBasedMoviesForUser/";
  private languagegenrebased_url =
    "http://13.232.51.70:9078/api/v1/getGenreLanguageBasedMoviesForUser/";
  constructor(private http: HttpClient) {}

  getGenreBasedMovies(emailId): Observable<MovieDetails[]> {
    console.log("inside ngOnInit getRecommendationList swervice");
    return this.http.get<MovieDetails[]>(this.genrebasedmovies_url + emailId);
  }
  getLanguageBased(emailId): Observable<MovieDetails[]> {
    return this.http.get<MovieDetails[]>(
      this.languagebasedmovies_url + "/" + emailId
    );
  }
  getLanguageGenreBasedMovies(emailId): Observable<MovieDetails[]> {
    return this.http.get<MovieDetails[]>(
      this.languagegenrebased_url + "/" + emailId
    );
  }
}
