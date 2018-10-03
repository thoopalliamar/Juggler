import { Injectable } from "@angular/core";
import { Movie } from "./movie";
import { MoviedetailsFormComponent } from "./moviedetails-form/moviedetails-form.component";
import { MovieDisplay } from "./MovieDisplay";
import { MovieDetails } from "./movieDetails";

@Injectable({
  providedIn: "root"
})
export class MovieDetailsService {
  public one: MoviedetailsFormComponent;
  public data: MovieDisplay;
  public movieData:MovieDetails;
  constructor() {
    console.log(this.data);
  }
  send(movie: MovieDisplay) {
    this.data = movie;
  }
  sendData(movieObject: MovieDetails) {
    this.movieData = movieObject;
    console.log(this.movieData);
  }
  receive() {
    console.log("receive" + this.data.movieName);
    return this.data;
  }
  receiveData() {
    console.log("receive" + this.movieData.name);
    return this.movieData;
  }
}