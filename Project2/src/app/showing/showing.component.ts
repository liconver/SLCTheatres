import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-showing',
  templateUrl: './showing.component.html',
  styleUrls: ['./showing.component.css']
})
export class ShowingComponent implements OnInit {

  readonly ROOT_URL = "http://localhost:8080/SLKTheatres/seatapi/seatsshowing.app";

  constructor() { }

  ngOnInit(): void {
  }

}
