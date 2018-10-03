import { Injectable } from "@angular/core";
import { Http, Headers } from "@angular/http";
import { Observable } from "rxjs";
@Injectable({
  providedIn: "root"
})
// 10.20.1.15:9081
export class PaymentService {
  message: string;
  constructor(private http: Http) {}
  // movieName: string, showId: string
  chargeCard(
    token: string,
    amount: number,
    bookedSeats: number[],
    showId: string,
    theatreName: string,
    movieName: string,
    showTiming: string,
    email: string
  ) {
    const headers = new Headers({ token: token, amount: amount });
    // const head = new Headers({bookedSeats: bookedSeats});
    this.http
      .post(
        "http://13.232.51.70:9081/api/v1/payment/charge",
        {},
        { headers: headers }
      )
      .subscribe(resp => {
        console.log(resp);
        if (resp != null) {
          // this.http.post("http://localhost:9081/api/v1/payment/ticket", {bookingDetails});

          // console.log(head);

          this.http
            .post("http://13.232.51.70:9081/api/v1/payment/ticket", {
              bookedSeats: bookedSeats,
              showId: showId,
              movieName: movieName,
              theatreName: theatreName,
              showTiming: showTiming,
              email: email
            })
            .subscribe(response => {
              console.log(response);
            });

          // bookingDetails(movieName: string){
          //   this.http
          //           .post("http://localhost:9081/api/v1/payment/ticket", {})
          //           .subscribe(response => {
          //             console.log(response);
          //           });
          // }
        }
      });
  }

  // bookingDetails(movieName: string){
  //   this.http
  //           .post("http://localhost:9081/api/v1/payment/ticket", {})
  //           .subscribe(response => {
  //             console.log(response);
  //           });
  // }

  refundCard() {
    this.http
      .post("http://13.232.51.70:9081/api/v1/payment/refund", {})
      .subscribe(res => {
        console.log(res);
      });
  }
}
