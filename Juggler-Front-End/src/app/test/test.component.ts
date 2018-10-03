import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.scss']
})
export class TestComponent implements OnInit {


  constructor(private httpService: HttpClient) { }
  json = [];
  city = [];
  ngOnInit() {

    this.httpService.get('./assets/cities.json').subscribe(
      result => { this.json = result as string[];
        // console.log(result);
        this.city[0]=this.json[0].name;
        this.city[1]=this.json[1].name;
        console.log(this.json);
        console.log(this.city+ "anmisha");
       });
  }
 }

