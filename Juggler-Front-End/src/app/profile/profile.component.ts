import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router, ParamMap } from "@angular/router";

@Component({
  selector: "app-profile",
  templateUrl: "./profile.component.html",
  styleUrls: ["./profile.component.scss"]
})
export class ProfileComponent implements OnInit {
  email: string;

  constructor(private router: Router, private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.paramMap.subscribe((params: ParamMap) => {
      console.log(params.get("email"));
      const email = params.get("email");
      console.log(email);
      this.email = email;
      console.log(this.email);
    });
  }
  addTheatre() {
    this.router.navigate(["/theatre", this.email]);
  }
  addMovie() {
    this.router.navigate(["/screening", this.email]);
  }
}
