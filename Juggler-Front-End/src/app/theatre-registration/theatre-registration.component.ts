import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from "@angular/core";
import {
FormControl,
FormGroup,
FormBuilder,
Validators
} from "@angular/forms";
import { Theatre } from "../theatre";
import { TheatreService } from "../theatre.service";
import { Router, ActivatedRoute, ParamMap } from "@angular/router";
import { MatDialog } from "@angular/material";
import { Seats } from "../Seats";


@Component({
selector: "app-theatre-registration",
templateUrl: "./theatre-registration.component.html",
styleUrls: ["./theatre-registration.component.scss"]
})
export class TheatreRegistrationComponent implements OnInit {
seatTypes: string[];
seatCount: number[];
json=[];
city=[];
// options: string[] = [
//   "Bangalore",
//   "Chennai",
//   "Hyderabad",
//   "Jaipur",
//   "Kolkata",
//   "Lucknow",
//   "Mangalore",
//   "Mumbai",
//   "Pune"
// ];
json1=[];
country=[];
seats = new Seats();
email: string;
showFiller = false;
isLinear = true;
firstFormGroup: FormGroup;
secondFormGroup: FormGroup;
thirdFormGroup: FormGroup;
myControl = new FormControl();


theatre = new Theatre();
seatObj = new Seats();
// theatreWithSeats = new TheatreSets();
constructor(
  private theatreService: TheatreService,
  private _formBuilder: FormBuilder,
  private router: Router,
  public dialog: MatDialog,
  private route: ActivatedRoute,
  private http:HttpClient
) {}
ngOnInit() {

  this.http.get('./assets/city.json').subscribe(
    result => { this.json = result as string[];
      // console.log(result);
      this.city[0]=this.json[0].name;
      this.city[1]=this.json[1].name;
      this.city[2]=this.json[2].name;
      this.city[3]=this.json[3].name;
      
      console.log(this.json);
      console.log(this.city+ "anmisha");
     });
  

       

  this.firstFormGroup = this._formBuilder.group({
    theatreName: ["", Validators.required],
    licenseNo: ["", Validators.required],
    City: ["", Validators.required],
    Capacity: ["", Validators.required]
  });
  
  this.secondFormGroup = this._formBuilder.group({
    Address: ["", Validators.required],
    City: ["", Validators.required],
    State: ["", Validators.required],
    Zip: ["", Validators.required],
    Country: ["", Validators.required]
  });

  this.http.get('./assets/country.json').subscribe(
    result1 => { this.json1 = result1 as string[];
      // console.log(result);
      this.country[0]=this.json1[0].name;
      this.country[1]=this.json1[1].name;
      this.country[2]=this.json1[2].name;
      this.country[3]=this.json1[3].name;
      this.country[4]=this.json1[4].name;
      this.country[5]=this.json1[5].name;
      this.country[6]=this.json1[6].name;
    
      console.log(this.json1);
      console.log(this.country+ "anmisha");
     });
  this.thirdFormGroup = this._formBuilder.group({
    type1: ["", Validators.required],
    type2: ["", Validators.required],
    type3: ["", Validators.required],
    n1: [Number, Validators.required],
    n2: [Number, Validators.required],
    n3: [Number, Validators.required]
  });
  this.route.paramMap.subscribe((params: ParamMap) => {
    console.log(params.get("email"));
    const ttName = params.get("email");
    console.log(ttName);
    this.email = ttName;
    console.log(this.email);
  });
 


}
openDialog() {
  this.theatre.email = this.email;
  this.theatre.theatreCity = this.f.City.value;
  this.theatre.theatreLicenseNo = this.f.licenseNo.value;
  this.theatre.theatreLocation =
    this.f1.Address.value +
    "," +
    this.f1.City.value +
    "," +
    this.f1.State.value +
    "," +
    this.f1.Zip.value +
    "," +
    this.f1.Country.value;
  this.theatre.theatreName = this.f.theatreName.value;
  this.seatTypes = [
    this.f2.type1.value,
    this.f2.type2.value,
    this.f2.type3.value
  ];
  this.seatCount = [this.f2.n1.value, this.f2.n2.value, this.f2.n3.value];
  this.theatre.typesOfSeats = this.seatTypes;
  this.theatre.numberOfSeats = this.seatCount;
  this.theatre["seatLayout"] = this.seats;
  this.seatObj = this.theatre["seatLayout"];
  console.log(this.seatObj.totalCol);
  console.log(this.seatObj.totalRow);
  console.log(this.seats);
  console.log(this.theatre.theatreName);
  console.log("maddy", this.theatre.seatLayout);
  this.theatreService
    .saveTheatre(this.theatre, this.email)
    .subscribe(res => console.log("Saved theatre"));
  this.router.navigate(["/profile", this.email]);

  console.log("hi", this.theatre);
}
get f() {
  return this.firstFormGroup.controls;
}
get f1() {
  return this.secondFormGroup.controls;
}
get f2() {
  return this.thirdFormGroup.controls;
}
}
