import { Component } from "@angular/core";
import { MovieDetailsService } from "../moviedetails.service";
import { Theatre } from "../theatre";
import { Movie } from "../movie";
import { MovieDisplay } from "../MovieDisplay";
import { FullBookingDetails } from "../FullBookingDetails";
import { BookingDetailsService } from "../booking-details.service";
import { Router } from "@angular/router";
import { BookingLayoutService } from "../booking-layout.service";
import { SharingDataService } from "../sharing-data.service";
@Component({
  selector: "app-theatre-display",
  templateUrl: "./theatre-display.component.html",
  styleUrls: ["./theatre-display.component.scss"]
})
export class TheatreDisplayComponent {
  movieObject2: MovieDisplay;
  theatreList: Theatre;
  selectedDetails = new FullBookingDetails();
  today: number;
  Id:string;
  tomorrow = [];
  count: number;
  dateValue: number;
  validDate: string;
  shows = [];
  noOfShows: number;
  prices = [];
  priceSeats = [];
  seats = [];
  i: number;
  weekday: boolean;
  weekend: boolean;
  dateYear: string;
  flag: boolean;
  a = [];
 valueDate:string;
  minDate:Date;
  maxDate:Date;
  public devWidth;
  constructor(
    private movieDetailsService: MovieDetailsService,
    private detailService: BookingDetailsService,
    private bookingLayoutService:BookingLayoutService,
    private service: SharingDataService,
    private router:Router
  ) {}

  ngOnInit() {
    var width = window.innerWidth;
    console.log(width);
    this.movieObject2 = this.movieDetailsService.receive();
    console.log(this.movieObject2);

    this.validDate = this.movieObject2.movieReleasedate;
    this.a = this.validDate.split("/");
    //this.dateYear=this.a[2]+"-"+this.a[1]+"-"+this.a[0];
    //console.log(this.a+"bnds c");
    const year = Number(this.a[2]);
    const month = Number(this.a[1]);
    const day = Number(this.a[0]);
    var startDate = new Date(year, month-1, day);
    var onDate=new Date();
    console.log(startDate);
    var endDate = new Date(startDate.getTime() + 7 * 24 * 60 * 60 * 1000);
    // if(startDate<onDate)
    // this.minDate = onDate;
    // else
    this.minDate=startDate
    
    // this.minDate = new Date(2000, 0, 1);
    // this.maxDate = new Date(2020, 0, 1);
    console.log(this.minDate,this.maxDate);
   this.maxDate=endDate;
 
    console.log(year,month,day);
    console.log(startDate, endDate);
    this.theatreList = this.movieObject2["theatres"];
    console.log(this.theatreList);
    this.shows = this.theatreList["showTimings"];

    //this.today = this.validDate.now();
    //Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
    var a = new Date();
    this.today = endDate.getTime();
    console.log(a.getTime(), this.today);
    this.count = 0;
    this.dateValue = a.getTime();
    

    while (this.count < 7) {
      this.tomorrow[this.count] = this.dateValue;
 if(this.today>this.dateValue){
      this.dateValue = this.dateValue + 24 * 60 * 60 * 1000;
    }
      this.count++;
    }
    console.log(this.tomorrow);
  }
  determineDay(day) {
    if (day === "Sat" || day === "Sun") this.weekend = true;
    else this.weekend = false;
    return this.weekend;
  }
  checkValid(everyday) {
    if (this.today > everyday) {
      this.flag = true;
    } else {
      this.flag = false;
    }
    console.log(this.flag);
    return this.flag;
  }

  saveShow(theatre, showtime: string, Selecteddate) {
   this.valueDate= String(Selecteddate.getDate())+"/"+String(Selecteddate.getMonth())+"/"+String(Selecteddate.getFullYear());
  
   console.log(this.valueDate+"sai");
    this.selectedDetails.nameOfMovie = this.movieObject2.movieName;
    this.selectedDetails.moviePoster = this.movieObject2.moviePoster;
    this.selectedDetails.synopsis = this.movieObject2.synopsis;
    this.selectedDetails.movieReleasedate = this.movieObject2.movieReleasedate;
    this.selectedDetails.movieDuration = this.movieObject2.movieDuration;
    this.selectedDetails.format = this.movieObject2.format;
    this.selectedDetails.movieGenre = this.movieObject2.movieGenre;
    this.selectedDetails.languages = this.movieObject2.languages;
    this.selectedDetails.theaterName = theatre.theatreName;
    this.selectedDetails.theatreLocation = theatre.theatreLocation;
    this.selectedDetails.screeningTime = showtime;
    this.selectedDetails.selectedDate=this.valueDate;
    console.log(
      this.selectedDetails.nameOfMovie,
      this.selectedDetails.theaterName,
      this.selectedDetails.screeningTime
    );
    this.Id=this.selectedDetails.theaterName+""+Selecteddate.getDate()+""+this.selectedDetails.screeningTime+""+this.service.sendCityName()
    this.selectedDetails.showId=this.Id;
    this.selectedDetails.selectedDate=this.valueDate;
    
    this.bookingLayoutService.saveTickeDetails(this.Id)
    .subscribe(res => console.log("Saved event"));
    console.log(this.selectedDetails);
    this.detailService.send(this.selectedDetails);
  }
}
