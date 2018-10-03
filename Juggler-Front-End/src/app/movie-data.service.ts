import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Movie } from './movie';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieDataService {
  private url2 = 'http://13.232.51.70:9070/api/v1/movie/';
  constructor(private http: HttpClient) { }

  setDistributorMovies() {
      return this.http.get('http://13.232.51.70:9070/api/v1/movie/');
  }
  getMovie() {
    return this.http.get('http://13.232.51.70:9070/api/v1/movie');
  }
  getMovieByTitle() {
     return this.http.get('http://13.232.51.70:9070/api/v1/movie/');
  }
  addMovie(movie: Movie): Observable<Movie> {
    return this.http.post<Movie>(this.url2 , movie);
  }
}

