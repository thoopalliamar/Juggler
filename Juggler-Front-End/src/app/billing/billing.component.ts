import { PromocodeService } from "./../promocode.service";
import { Component, OnInit } from "@angular/core";
import { LayoutToBillingService } from "../layout-to-billing.service";
import { FullBookingDetails } from "../FullBookingDetails";



// export interface result {
//   id:number;
//   code:string;
//   image:string;
//   description:string;
//   amount:string;
// }
@Component({
  selector: "app-billing",
  templateUrl: "./billing.component.html",
  styleUrls: ["./billing.component.scss"]
})
export class BillingComponent implements OnInit {
   result:any;
  promos: string;
  value: number;
  flag: boolean;
  show: boolean = true;
  result1 = null;
  bool;
  value1:number
  bookingDetails: FullBookingDetails;
  

  constructor(private promoService: PromocodeService, private payment: PromocodeService,private layouttobilling: LayoutToBillingService) {}
  ngOnInit() {
   
    this.result1=null;
    this.promoService.getpromos().subscribe(data => {
      this.result = data;
      this.bool = false;
      // console.log(this.bool);
    });
     console.log(this.result);
     this.bookingDetails=this.layouttobilling.getAtBilling();
     console.log(this.bookingDetails.emailId+ "anmisha");

  }

  promo(code) {
    this.result1=null;
    this.promos = code;
    this.promoService.getbyname(code).subscribe(
      data => {
        this.result1 = data;
        console.log("data is ", data);
      },
      error => {
        console.log("error is ", error);
        this.bool = true;
      }
    );
     console.log("data is ", this.result1);
  }

  formula( value3:number,value2: number) {
    this.value1=this.bookingDetails.totalAmount;
    console.log(this.value1);
    switch (value2) {
      case 200:
        if (this.value1 >= 1000) {
          this.flag = true;
        } else {
          this.flag = false;
        }
        break;
      case 100:
        if (this.value1 >= 500) {
          this.flag = true;
        } else {
          this.flag = false;
        }
        break;
      case 50:
        if (this.value1 >= 300) {
          this.flag = true;
        } else {
          this.flag = false;
        }
        break;
      case 20:
        if (this.value1 >= 200) {
          this.flag = true;
        } else {
          this.flag = false;
        }
        break;
      case 10:
        if (this.value1 >= 100) {
          this.flag = true;
        } else {
          this.flag = false;
        }
        break;
      default:
        this.flag = false;
    }

    if (this.flag == true) {
      this.value = this.value1 - value2;
    }
    else
    {
      this.value=this.value1;
      
    }
    this.payment.amount = this.value;
    console.log(this.value);
    
    return this.flag;
  }
  // openVerticallyCentered(content) {
  //   this.modalService.open(content, { centered: true });
  // }
  email(email:string){
    console.log(email);
    this.bookingDetails.emailId=email;
  }
  onclick(){
    console.log(this.value);
    this.bookingDetails.Finalamount=this.value;
    console.log(this.bookingDetails.emailId+ "madhusri");
    this.layouttobilling.sendToBilling(this.bookingDetails);
  }
  
}
