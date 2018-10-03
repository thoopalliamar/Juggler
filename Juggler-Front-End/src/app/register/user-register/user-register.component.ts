import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from "@angular/core";
import { UserService } from "../../user.service";
import {
  FormGroup,
  FormBuilder,
  Validators,
  FormControl
} from "@angular/forms";
import { User } from "../../user";
import { Router } from "@angular/router";
export interface Language {
  name: string;
}

@Component({
  selector: "app-user-register",
  templateUrl: "./user-register.component.html",
  styleUrls: ["./user-register.component.scss"]
})
export class UserRegisterComponent implements OnInit {
  isLinear = true;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  fourthFormGroup: FormGroup;
  languageCtrl = new FormControl;
  genderGroup: string[] = ["Male", "Female"];
  gender;
  genre = new FormControl();
  genreList = [
    {id:1, name:"Thriller", card:"card1", click:"card1", img:"assets/images/Thriller.jpeg"},
    {id:2,name:"Fiction", card:"card2", click:"card2", img:"assets/images/Fiction.jpeg" },
    {id:3,name:"Horror", card:"card3", click:"card3", img:"assets/images/Horror.jpeg"},
    {id:4,name:"Romance", card:"card4", click:"card4", img:"assets/images/Romance.jpeg"},
    {id:5,name:"Drama", card:"card5", click:"card5", img:"assets/images/Drama.png"},
    {id:6,name:"Crime", card:"card6", click:"card6", img:"assets/images/Crime.jpeg"},
    {id:7,name:"Action", card:"card7", click:"card7", img:"assets/images/Action.jpeg"},
    {id:8,name:"SuperHeroes", card:"card8", click:"card8", img:"assets/images/Super-Heroes.jpeg"}
];
  genreOutoutList: Array<string> = []; 
json=[];
city=[];
json1=[];
cit=[];
  user = new User();
  // languages: string[] = [
  //   "Bengali",
  //   "English",
  //   "Hindi",
  //   "Kannada",
  //   "Malyalam",
  //   "Telugu",
  //   "Tamil"
  // ];

  constructor(
    private userService: UserService,
    private _formBuilder: FormBuilder,
    private router: Router,
    private http:HttpClient
  ) { }
  // onGenreCardSelect(genre: any) {
  //   this.genreOutoutList.push(genre);
  //   console.log(this.genreOutoutList);
  // }
  onclick(id,card,genres){ 
    if(document.getElementById(card).style.opacity == "0.3"){
      document.getElementById(card).style.opacity= "1";
      this.genreOutoutList.pop();
    }
    else{
      document.getElementById(card).style.opacity="0.3";
      this.genreOutoutList.push(genres)
}
console.log(this.genreOutoutList);
}
  ngOnInit() {
    this.http.get('./assets/city.json').subscribe(
      result => { this.json1 = result as string[];
        // console.log(result);
        this.city[0]=this.json1[0].name;
        this.city[1]=this.json1[1].name;
        this.city[2]=this.json1[2].name;
        this.city[3]=this.json1[3].name;
        
        console.log(this.json);
        console.log(this.city+ "anmisha");
       });
    this.firstFormGroup = this._formBuilder.group({
      userName: ["", Validators.required],
      email: ["", Validators.email],
      password: ["", Validators.required],
      mobileNo: ["", Validators.required]
    });

    
    this.secondFormGroup = this._formBuilder.group({
      address: ["", Validators.required]
    });
    
    this.http.get('./assets/languages.json').subscribe(
      result => { this.json = result as string[];
        // console.log(result);
        this.cit[0]=this.json[0].name;
        this.cit[1]=this.json[1].name;
        this.cit[2]=this.json[2].name;
        this.cit[3]=this.json[3].name;
        this.cit[4]=this.json[4].name;
        this.cit[5]=this.json[5].name;
        this.cit[6]=this.json[6].name;
        this.cit[7]=this.json[7].name;
        console.log(this.json);
        console.log(this.cit+ "anmisha");
       });

  }

  get f() {
    return this.firstFormGroup.controls;
  }
  get f1() {
    return this.secondFormGroup.controls;
  }

  addUser() {
    this.user.userName = this.f.userName.value;
    this.user.emailId = this.f.email.value;
    this.user.password = this.f.password.value;
    this.user.mobileNo = this.f.mobileNo.value;
    this.user.location = this.f1.address.value;
    this.user.languagesKnown = this.languageCtrl.value;
    this.user.genre = this.genreOutoutList;
    // this.user.gender = this.gender.value;
    console.log(this.genreOutoutList);
    console.log(this.user.userName);
    console.log(this.user);
    this.userService
      .saveUser(this.user)
      .subscribe(res => console.log("Saved User"));
    this.router.navigate(["/login-user"]);
   

  }

}
