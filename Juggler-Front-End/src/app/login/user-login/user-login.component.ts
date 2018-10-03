import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router, ActivatedRoute } from "@angular/router";
import { AuthenticationService } from "../user-login/../../authentication.service";
import { AlertService } from "../user-login/../../alert.service";
import { first } from "rxjs/operators";
import { SharingDataService } from "../../sharing-data.service";

@Component({
  selector: "app-user-login",
  templateUrl: "./user-login.component.html",
  styleUrls: ["./user-login.component.scss"]
})
export class UserLoginComponent implements OnInit {
  name:string;
  error = "";
  loginForm: FormGroup;
  loading = false;
  submitted = false;
  errormessage: Boolean = true;
  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService,
    private alertService: AlertService,
    private service:SharingDataService
  ) {}
  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: [null, Validators.required],
      password: [null, Validators.required]
    });
  }
  // convenience getter for easy access to form fields
  get f() {
    return this.loginForm.controls;
  }
  onSubmit() {
    this.name=this.service.sendCityName();
    this.submitted = true;
    // stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
    }
    console.log(this.f.email.value);
    this.loading = true;
    this.authenticationService
      .loginUser(this.f.email.value, this.f.password.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate(["home",this.name]);
          location.reload();
        },
        error => {
          this.alertService.error(error);
          this.loading = false;
          this.errormessage = false;
        }
      );
  }
}
