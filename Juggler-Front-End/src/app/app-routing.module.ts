import { BillingComponent } from "./billing/billing.component";
import { MoviedetailsFormComponent } from "./moviedetails-form/moviedetails-form.component";
import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { Routes, RouterModule } from "@angular/router";
import { LandingPageComponent } from "./landing-page/landing-page.component";
import { HomePageComponent } from "./home-page/home-page.component";
import { UserRegisterComponent } from "./register/user-register/user-register.component";
import { PartnerRegisterComponent } from "./register/partner-register/partner-register.component";
import { DistributionRegisterFormComponent } from "./distribution-registerform/distribution-registerform.component";
import { UserLoginComponent } from "./login/user-login/user-login.component";
import { PartnerLoginComponent } from "./login/partner-login/partner-login.component";
import { TheatreRegistrationComponent } from "./theatre-registration/theatre-registration.component";
import { ContactComponent } from "./contact/contact.component";
import { MovieScreeningComponent } from "./movie-screening/movie-screening.component";
import { ProfileComponent } from "./profile/profile.component";
import { TheatreDisplayComponent } from "./theatre-display/theatre-display.component";
import { RSVPEventComponent } from "./rsvp-event/rsvp-event.component";
import { SeatlayoutComponent } from "./seatlayout/seatlayout.component";
import { RsvpEventsListComponent } from "./rsvp-events-list/rsvp-events-list.component";
import { PaymentPageComponent } from "./payment-page/payment-page.component";
import { RsvpAcceptComponent } from "./rsvp-accept/rsvp-accept.component";
import { TestComponent } from "./test/test.component";
import { RecommondationThetareDisplayComponent } from "./recommondation-thetare-display/recommondation-thetare-display.component";
import { TicketBookedComponent } from "./ticket-booked/ticket-booked.component";
import { RecomondationMovieDisplayComponent } from "./recomondation-movie-display/recomondation-movie-display.component";

const routes: Routes = [
  { path: "", component: LandingPageComponent },
  { path: "home", component: HomePageComponent },
  { path: "home/:city", component: HomePageComponent },
  { path: "register-user", component: UserRegisterComponent },
  { path: "login-user", component: UserLoginComponent },
  { path: "register-partner", component: PartnerRegisterComponent },
  { path: "moviedetail", component: MoviedetailsFormComponent },
  { path: "login-partner", component: PartnerLoginComponent },
  { path: "distributor", component: DistributionRegisterFormComponent },
  { path: "screening/:email", component: MovieScreeningComponent },
  { path: "theatre/:email", component: TheatreRegistrationComponent },
  { path: "contact", component: ContactComponent },
  { path: "profile/:email", component: ProfileComponent },
  { path: "rsvp", component: RSVPEventComponent },
  { path: "display-theatre", component: TheatreDisplayComponent },
  { path: "seat-layout", component: SeatlayoutComponent },
  { path: "payment-page", component: PaymentPageComponent },
  { path: "rsvp/events", component: RsvpEventsListComponent },
  { path: "billing", component: BillingComponent },
  { path: "rsvp/accept", component: RsvpAcceptComponent },
  { path: "test", component: TestComponent },
  { path: "rec/movie", component: RecomondationMovieDisplayComponent },
  { path: "rec/theatre", component: RecommondationThetareDisplayComponent },
  { path: "ticket", component: TicketBookedComponent }
];

@NgModule({
  imports: [BrowserModule, RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule, BrowserModule]
})
export class AppRoutingModule {}

export const routingComponents = [
  LandingPageComponent,
  UserRegisterComponent,
  PartnerLoginComponent,
  UserLoginComponent,
  PartnerRegisterComponent,
  HomePageComponent,
  TheatreRegistrationComponent,
  DistributionRegisterFormComponent,
  MovieScreeningComponent,
  ProfileComponent,
  RSVPEventComponent,
  MoviedetailsFormComponent,
  TheatreDisplayComponent,
  SeatlayoutComponent,
  PaymentPageComponent,
  RsvpEventsListComponent,
  BillingComponent,
  RsvpAcceptComponent,
  RecomondationMovieDisplayComponent,
  RecommondationThetareDisplayComponent,
  TicketBookedComponent
];
