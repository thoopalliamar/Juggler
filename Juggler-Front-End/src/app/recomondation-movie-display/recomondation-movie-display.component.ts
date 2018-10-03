import { Component, OnInit } from "@angular/core";
import { MovieDetails } from "../movieDetails";
import { MovieDetailsService } from "../moviedetails.service";

@Component({
  selector: "app-recomondation-movie-display",
  templateUrl: "./recomondation-movie-display.component.html",
  styleUrls: ["./recomondation-movie-display.component.scss"]
})
export class RecomondationMovieDisplayComponent implements OnInit {
  movieObject: MovieDetails;
  constructor(private movieDetailsService: MovieDetailsService) {}

  ngOnInit() {
    console.log("jyothirmayi");
    this.movieObject = this.movieDetailsService.receiveData();
    console.log(this.movieObject + "abcdefg");
  }
}
