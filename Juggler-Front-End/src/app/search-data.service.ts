import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";
import { map } from "rxjs/operators";

@Injectable({
  providedIn: "root"
})
export class SearchDataService {
  data: any;
  private url3="http://13.232.51.70:9077/api/v1/city";
  private url = "http:/13.232.51.70:9077/api/v1/movie";
  constructor(private http: HttpClient, private router: Router) {}

  searchMoviebycity(city: string) {
    return this.http
      .get(this.url3 + "/" + city)
      .pipe(map(res => (this.data = res)));
  }
  

  searchMovie(movie: string) {
    return this.http
      .get(this.url + "/" + movie)
      .pipe(map(res => (this.data = res)));
  }
}
