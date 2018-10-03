import { Component } from "@angular/core";
import { MovieDetailsService } from "../moviedetails.service";
import { BookingDetailsService } from "../booking-details.service";
import { MovieDetails } from "../movieDetails";
import { Theatre } from "../theatre";
import { FullBookingDetails } from "../FullBookingDetails";

@Component({
  selector: "app-recommondation-thetare-display",
  templateUrl: "./recommondation-thetare-display.component.html",
  styleUrls: ["./recommondation-thetare-display.component.scss"]
})

export class RecommondationThetareDisplayComponent {
  movieObject2: MovieDetails;
  i:number;
  j:number;
  theatreList: Theatre;
  selectedDetails = new FullBookingDetails();
  today: number;
  tomorrow = [];
  count: number;
  dateValue: number;
  validDate: string;
  shows = [];
  noOfShows: number;
  prices = [];
  priceSeats = [];
  seats = [];
 
  weekday: boolean;
  weekend: boolean;
  movieGenre: string = "";
  movieLang: string = "";
  constructor(
    private movieDetailsService: MovieDetailsService,
    private detailService: BookingDetailsService
  ) {}

  ngOnInit() {
    this.movieObject2 = this.movieDetailsService.receiveData();
    console.log(this.movieObject2+"abcdefghijkl");

    // this.validDate = this.movieObject2.movieReleasedate;
    // var date = new Date("this.validDate");
    // console.log(date.toDateString());

    this.theatreList = this.movieObject2["theatres"];
    console.log(this.theatreList+"67676");
    this.shows = this.theatreList["showTimings"];

    //this.today = this.validDate.now();
    //Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
    this.today = Date.now();
    // console.log(this.today);
    this.count = 0;
    this.dateValue = this.today;

    // this.tomorrow[j]=this.today[i]+(24*60*60*1000);
    while (this.count < 7) {
      this.tomorrow[this.count] = this.dateValue;

      this.dateValue = this.dateValue + 24 * 60 * 60 * 1000;
      this.count++;
    }
  }
  determineDay(day) {
    if (day === "Sat" || day === "Sun") this.weekend = true;
    else this.weekend = false;
    return this.weekend;
  }

  saveShow(theatre, showtime: string) {
    console.log("avh,ng", showtime);
    this.selectedDetails.nameOfMovie = this.movieObject2.name;
    this.selectedDetails.moviePoster = this.movieObject2.moviePoster;
    this.selectedDetails.synopsis = this.movieObject2.synopsis;
    this.selectedDetails.movieReleasedate = this.movieObject2.movieReleasedate;
    this.selectedDetails.movieDuration = this.movieObject2.movieDuration;
    this.selectedDetails.format = this.movieObject2.format;
    while(this.movieObject2.movieGenres[this.i]!=null)  {
      this.movieGenre =
        this.movieGenre + " " + this.movieObject2.movieGenres[this.i];
    }
    while(this.movieObject2.movielanguage[this.j]!=null)
     {
      this.movieLang = this.movieLang + " " + this.movieObject2.languages[this.j];
    }
    this.selectedDetails.movieGenre = this.movieGenre;
    this.selectedDetails.languages = this.movieLang;
    this.selectedDetails.theaterName = theatre.theatreName;
    this.selectedDetails.theatreLocation = theatre.theatreLocation;
    this.selectedDetails.screeningTime = showtime;
    console.log(
      this.selectedDetails.nameOfMovie,
      this.selectedDetails.theaterName,
      this.selectedDetails.screeningTime
    );
    console.log(this.selectedDetails);
    this.detailService.send(this.selectedDetails);
  }
}
