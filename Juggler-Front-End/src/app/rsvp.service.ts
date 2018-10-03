import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { map } from "rxjs/operators";

import { Event } from "./event";
import { EmailDetails } from "./emailDetails";
@Injectable({
  providedIn: "root"
})
export class RsvpService {
  data: any;
  private _url = "http://13.232.122.240:9075/api/v1/event";
  movies_url = "http://13.232.122.240:9075/api/v1/event/get/?emailId=";
  email_url = "http://13.232.122.240:9076/api/v1/email/sendEmail";

  constructor(private http: HttpClient) {}

  saveEvent(event: Event): Observable<Event> {
    return this.http.post<Event>(this._url, event);
  }

  sendEmail() {
    return this.http.post<EmailDetails>(this.email_url, null);
  }

  searchEvent(email: string) {
    console.log(email + " in service");
    console.log("data is " + this.data);
    return this.http
      .get(this.movies_url + email)
      .pipe(map(res => (this.data = res)));
  }
}
