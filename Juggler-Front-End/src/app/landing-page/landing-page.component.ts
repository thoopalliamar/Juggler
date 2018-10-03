import { Component, OnInit } from "@angular/core";
import { SearchDataService } from "../search-data.service";
import { Router } from "@angular/router";
import { MatDialog } from "@angular/material";
import { DialogComponentComponent } from "./dialog-component/dialog-component.component";

@Component({
  selector: "app-landing-page",
  templateUrl: "./landing-page.component.html",
  styleUrls: ["./landing-page.component.scss"]
})
export class LandingPageComponent implements OnInit {
  movies = [
    {
      movieTitle: "Gold",
      movieposter:
        "https://assetscdn.paytm.com/images/cinema/MovieIcons/Gold-web-poster-updated.jpg"
    },
    {
      movieTitle: "Geeta Govindam",
      movieposter:
        "https://assetscdn.paytm.com/images/cinema/MovieIcons/Geetha-Govindam-web-poster.jpg"
    },
    // tslint:disable-next-line:max-line-length
    {
      movieTitle: "Happy Phir bhag jayeghi",
      movieposter:
        "https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/images/cinema/Happy-phirr-bhag-jayegi-web-poster-214c1486-e7e3-4f94-bd64-bbeaadf6f3ff.jpg"
    },
    {
      movieTitle: "Mile22",
      movieposter:
        "https://assetscdn1.paytm.com/images/catalog/view_item/195582/1535023771411.jpg"
    }
  ];

  constructor(public dialog: MatDialog) {}

  ngOnInit() {
    const dialogRef = setTimeout(() =>
      this.dialog.open(DialogComponentComponent, {
        width: "85%",
        height: "45%",
        position: { top: "10%", left: "10%" }
      })
    );
    // dialogRef.afterClosed().subscribe(result => {
    //   console.log('The dialog was closed ${result}');
    // });
  }
}
