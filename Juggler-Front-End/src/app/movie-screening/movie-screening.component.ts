import { Component, OnInit } from "@angular/core";
import { ScreeningDetails } from "../screening-details";
import { Validators, FormGroup, FormBuilder } from "@angular/forms";
import { MovieScreeningService } from "../movie-screening.service";
import { Router, ParamMap, ActivatedRoute } from "@angular/router";

@Component({
 selector: "app-movie-screening",
 templateUrl: "./movie-screening.component.html",
 styleUrls: ["./movie-screening.component.scss"]
})
export class MovieScreeningComponent implements OnInit {
 title: string;
 isLinear = true;
 firstFormGroup: FormGroup;
 secondFormGroup: FormGroup;
 email: string;
 movies = [];
 weekendsPrice: number[];
 weekdaysPrice: number[];
 screening = new ScreeningDetails();

 constructor(
   private screeningService: MovieScreeningService,
   private _formBuilder: FormBuilder,
   private route: Router,
   private router: ActivatedRoute
 ) {}

 addMve(mve){
   this.screening.id = mve.id;
   this.screening.movieName = mve.movieName;
   this.screening.moviePoster = mve.moviePoster;
   this.screening.movieReleaseDate = mve.movieReleaseDate;
   this.screening.movieDuration = mve.movieDuration;
   this.screening.synopsis = mve.synopsis;
   this.screening.format = mve.format;
   this.screening.movieGenres = mve.movieGenres;
   this.screening.languages = mve.languages;
   this.screening.actors = mve.actors;
   this.screening.actress = mve.actress;
   this.screening.directors = mve.directors;
   console.log(this.screening.movieName);
 }
 onSubmit() {
   this.screening.showNumbers = this.f.show_Numbers.value;
   this.screening.showTimings = this.f.show_Timings.value;
   this.weekdaysPrice = [this.f.n1.value, this.f.n2.value, this.f.n3.value];
   this.screening.weekdays_Price = this.weekdaysPrice;
   this.weekendsPrice = [this.f.n4.value, this.f.n5.value, this.f.n6.value];
   this.screening.weekends_Price = this.weekendsPrice;
   console.log(this.screening.id);

   console.log(this.screening);
   console.log(this.email);
   // console.log(this.screening.moviePoster);
   this.screeningService
     .saveScreening(this.screening, this.email)
     .subscribe(res => console.log("Saved screening details"));
     this.route.navigate(["/profile", this.email]);
 }
 clickOk() {
  
  
 }
 getMovie(title: string) {
   this.screeningService.getMovies(title).then(re => (this.movies = re));
 }
 ngOnInit() {
   this.secondFormGroup = this._formBuilder.group({
     show_Numbers: ["", Validators.required],
     show_Timings: ["", Validators.required],
     n1: [Number, Validators.required],
     n2: [Number, Validators.required],
     n3: [Number, Validators.required],
     n4: [Number, Validators.required],
     n5: [Number, Validators.required],
     n6: [Number, Validators.required]
   });
   this.router.paramMap.subscribe((params: ParamMap) => {
     console.log(params.get("email"));
     const email = params.get("email");
     console.log(email);
     this.email = email;
     console.log(this.email);
   });
 }
 get f() {
   return this.secondFormGroup.controls;
 }
}