import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";
import { map } from "rxjs/operators";
@Injectable({
  providedIn: "root"
})
export class PromocodeService {
  data: any;
  private url = "http://13.232.51.70:9080/api/v1/promocodes";
  private url1 = "http://13.232.51.70:9080/api/v1/promocode";

  constructor(private http: HttpClient, private router: Router) {}

  amount: number;
  
  
  getpromos() {
    return this.http.get(this.url).pipe(map(res => (this.data = res)));
  }
  // getbyname(code:string){
  //   return this.http.get(this.url1 + '/' + code)
  //   .pipe( map(res => this.data = res));
  // }
  getbyname(code: string) {
    return this.http
      .get(this.url1 + "/" + code);
  }
}
