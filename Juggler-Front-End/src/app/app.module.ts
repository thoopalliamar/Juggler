import { BillingToPaymentService } from "./billing-to-payment.service";
import { BillingComponent } from "./billing/billing.component";
import { NgModule, NO_ERRORS_SCHEMA } from "@angular/core";
import {
  HashLocationStrategy,
  Location,
  LocationStrategy
} from "@angular/common";
import { MDBBootstrapModule } from "angular-bootstrap-md";
import { BrowserModule } from "@angular/platform-browser";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { HttpModule } from "@angular/http";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { AppRoutingModule, routingComponents } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { HeaderComponent } from "./header/header.component";
import { FooterComponent } from "./footer/footer.component";
import { UserLoginComponent } from "./login/user-login/user-login.component";
import { MoviedetailsFormComponent } from "./moviedetails-form/moviedetails-form.component";
import { AuthenticationService } from "./authentication.service";
import { AlertService } from "./alert.service";
import { MatGridListModule } from "@angular/material/grid-list";
import {
  MatDialogModule
} from "@angular/material/dialog";
import { MatAutocompleteModule, MatExpansionModule } from "@angular/material";
import { MatCardModule, MatNativeDateModule } from "@angular/material";
import { MatStepperModule } from "@angular/material/stepper";
import { MatButtonModule } from "@angular/material/button";
import { MaterialsModule } from "./materials";
import { MatInputModule } from "@angular/material/input";
import { MatFormFieldModule } from "@angular/material/form-field";
import { PartnerLoginComponent } from "./login/partner-login/partner-login.component";
import { TheatreRegistrationComponent } from "./theatre-registration/theatre-registration.component";
import { SearchDataService } from "./search-data.service";
import { TheatreService } from "./theatre.service";
import { UserService } from "./user.service";
import { ContactComponent } from "./contact/contact.component";
import { DistributionRegisterFormComponent } from "./distribution-registerform/distribution-registerform.component";
import { DialogComponentComponent } from "./landing-page/dialog-component/dialog-component.component";
import { LandingPageComponent } from "./landing-page/landing-page.component";
import { HomePageComponent } from "./home-page/home-page.component";
import { MovieScreeningComponent } from "./movie-screening/movie-screening.component";
import { MovieScreeningService } from "./movie-screening.service";
import { MovieDetailsService } from "./moviedetails.service";
import { RecommendationComponent } from "./recommendation/recommendation.component";
import { ProfileComponent } from "./profile/profile.component";
import { ProfileService } from "./profile.service";
import { TheatreDisplayComponent } from "./theatre-display/theatre-display.component";
import { MatDividerModule } from "@angular/material/divider";
import { MatTableModule } from "@angular/material/table";
import { RSVPEventComponent } from "./rsvp-event/rsvp-event.component";
import { PaymentPageComponent } from "./payment-page/payment-page.component";
import { PaymentService } from "./paymentservice";
import { RsvpEventsListComponent } from "./rsvp-events-list/rsvp-events-list.component";
import { PromocodeService } from "./promocode.service";
import { RsvpAcceptComponent } from "./rsvp-accept/rsvp-accept.component";
import { RecMovDisplayComponent } from "./rec-mov-display/rec-mov-display.component";
import { TestComponent } from "./test/test.component";
import { LayoutToBillingService } from "./layout-to-billing.service";
import { PaymentToTicketService } from "./payment-to-ticket.service";
import { NgxSpinnerModule } from "ngx-spinner";

// import { MatToolbarModule, MatSidenavModule, MatIconModule, MatListModule, MatCardModule } from '@angular/material';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    routingComponents,
    UserLoginComponent,
    MoviedetailsFormComponent,
    DistributionRegisterFormComponent,
    PartnerLoginComponent,
    TheatreRegistrationComponent,
    ContactComponent,
    DialogComponentComponent,
    LandingPageComponent,
    HomePageComponent,
    MovieScreeningComponent,
    RecommendationComponent,
    ProfileComponent,
    TheatreDisplayComponent,
    RSVPEventComponent,
    RsvpEventsListComponent,
    PaymentPageComponent,
    BillingComponent,
    RsvpAcceptComponent,
    RecMovDisplayComponent,
    TestComponent
  ],

  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    HttpModule,
    BrowserAnimationsModule,
    MDBBootstrapModule.forRoot(),
    AppRoutingModule,
    ReactiveFormsModule,
    MaterialsModule,
    MatCardModule,
    MatButtonModule,
    MatStepperModule,
    MatInputModule,
    MatFormFieldModule,
    MatGridListModule,
    MatDialogModule,
    MatExpansionModule,
    MatNativeDateModule,
    MatAutocompleteModule,
    MatDividerModule,
    MatTableModule,
    NgxSpinnerModule
  ],
  providers: [
    AuthenticationService,
    AlertService,
    SearchDataService,
    TheatreService,
    UserService,
    MovieScreeningService,
    MovieDetailsService,
    PaymentService,
    ProfileService,
    PromocodeService,
    Location,
    { provide: LocationStrategy, useClass: HashLocationStrategy }
  ],
  bootstrap: [AppComponent],
  entryComponents: [DialogComponentComponent],
  schemas: [NO_ERRORS_SCHEMA]
})
export class AppModule {}
