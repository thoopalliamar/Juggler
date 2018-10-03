import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router, ActivatedRoute } from "@angular/router";
import { AuthenticationService } from "../user-login/../../authentication.service";
import { AlertService } from "../user-login/../../alert.service";
import { first } from "rxjs/operators";

@Component({
  selector: "app-partner-login",
  templateUrl: "./partner-login.component.html",
  styleUrls: ["./partner-login.component.scss"]
})
export class PartnerLoginComponent implements OnInit {
  loginForm: FormGroup;
  loading = false;
  submitted = false;
  // returnUrl: string;

  role: string;
  errormessage: Boolean = true;
  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService,
    private alertService: AlertService
  ) {}

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: ["", Validators.required],
      password: ["", Validators.required]
    });

    // reset login status
    this.authenticationService.logout();

    // get return url from route parameters or default to '/'
    // this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  // convenience getter for easy access to form fields
  get f() {
    return this.loginForm.controls;
  }

  onSubmit() {
    this.submitted = true;
    // stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
    }
    console.log(this.f.email.value);
    console.log(this.role);
    this.loading = true;
    this.authenticationService
      .loginPartner(this.f.email.value, this.f.password.value, this.role)
      .pipe(first())
      .subscribe(
        data => {
          if (this.role == "Distributor") {
            this.router.navigate(["/distributor"]);
            location.reload();
          } else if (this.role == "Theatre Owner") {
            this.router.navigate(["/profile", this.f.email.value]);
            location.reload();
          } else if (this.role == "Event Producer"){
            this.router.navigate(["rsvp/events"]);
            location.reload();
          }
        },
        error => {
          this.alertService.error(error);
          this.loading = false;
          this.errormessage = false;
        }
      );
  }
}
