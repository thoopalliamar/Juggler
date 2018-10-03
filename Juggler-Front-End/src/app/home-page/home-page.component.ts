import { Component, OnInit } from "@angular/core";
import { SearchDataService } from "../search-data.service";
import { Router, ActivatedRoute, ParamMap } from "@angular/router";
import { Movie } from "../movie";
import { MovieDetailsService } from "../moviedetails.service";
import { MovieDisplay } from "../MovieDisplay";
import { SharingDataService } from "../sharing-data.service";

@Component({
  selector: "app-home-page",
  templateUrl: "./home-page.component.html",
  styleUrls: ["./home-page.component.scss"]
})
export class HomePageComponent implements OnInit {
  search;
  search_result;
  search_result1;
  city: string;
  movie: string;
  selectedName;
  selectedMovie: MovieDisplay;
  nameOfMovie: string;
  movieDataList;
  listMovie = [];
  data: Movie;

  // onResize(event) {
  //   const element = event.target.innerWidth;
  //   console.log(element);
  //   if (element < 950) {
  //     this.test = 2;
  //   }

  //   if (element > 950) {
  //     this.test = 3;
  //   }

  //   if (element < 750) {
  //     this.test = 1;
  //   }
  // }
  onResize(event) {}

  constructor(
    private cityService: SearchDataService,
    private movieDetailsService: MovieDetailsService,
    private route: Router,
    private router: ActivatedRoute
  ) {}

  searchMovies(Movie: string) {
    // this.dataa.currentMessage.subscribe(message => this.movie = message)
    console.log(this.movie);
    this.movie = Movie;
    this.cityService.searchMovie(this.movie).subscribe(data => {
      this.search_result1 = data;
    });
    console.log(this.search_result1);
  }

  ngOnInit() {
    this.router.paramMap.subscribe((params: ParamMap) => {
      const city = params.get("city");
      this.city = city;
      this.cityService.searchMoviebycity(this.city).subscribe(data => {
        this.search_result = data["movieList"];
      });
      console.log(this.search_result);
    });
    // this.dataa.currentMessage.subscribe(message => this.movie = message)
    // console.log(this.movie);
  }
  
  getMovieInfo(movieDetail) {
    this.selectedMovie = movieDetail;
    this.movieDetailsService.send(this.selectedMovie);
  }
}
