import { Component, OnInit } from '@angular/core';
import { MovieDataService } from '../movie-data.service';
import { MovieDetailsService } from '../moviedetails.service';
import { Movie } from "../movie";
import { MovieDisplay } from '../MovieDisplay';

@Component({
  selector: 'app-moviedetails-form',
  templateUrl: './moviedetails-form.component.html',
  styleUrls: ['./moviedetails-form.component.scss']
})
export class MoviedetailsFormComponent implements OnInit {
  movie: any;
  movieObject:MovieDisplay;
  constructor(private movieService: MovieDataService, private movieDetailsService: MovieDetailsService) { }

  getMovieInfo() {
    this.movieService.getMovieByTitle().subscribe(data => {
      this.movie = data;
    });
  }
  bookTicket() {}

  ngOnInit() {
    this.movieObject = this.movieDetailsService.receive();
    };

}

