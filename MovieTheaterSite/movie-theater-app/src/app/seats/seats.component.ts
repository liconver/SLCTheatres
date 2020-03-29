import { Component, OnInit, Input } from '@angular/core';
import { SeatDataService } from '../seat-data.service';
import { HttpClient } from '@angular/common/http';
import { ShowingService } from '../services/showing.service';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Showing } from '../showing';


@Component({
  selector: 'app-seats',
  templateUrl: './seats.component.html',
  styleUrls: ['./seats.component.css']
})
export class SeatsComponent implements OnInit {
  //Seats component retrieves a showing object from the database
  @Input() showing: Showing;

  SHOWING_ID: number = 7;
  readonly ROOT_URL = "http://localhost:8080/SLKTheatres/seatapi/seatsshowing.app";
  posts: any;
  val: any;
  isDataAvailable: boolean = false;
  seatService: SeatDataService = new SeatDataService;
  selected: number[] = [];

  checkout = {
    btn: false,
  };

  seats = [];
  constructor(private showingService: ShowingService, private data: SeatDataService, 
              private httpClient: HttpClient, private route: ActivatedRoute) { }

  sendSeats() {

    console.log("These are my selected seats!");
    let list = [];
    for (let i = 0; i < this.seats.length; i++) {
      if (this.seats[i].selected) {
        list.push({
          seatId:this.val[i].seatId,
          seatName: this.val[i].seatName,
        });
      }
    }
    console.log("List of seats to buy!");
    console.log(list);

    this.data.changeMessage(list);

  }

  async getSeatsRequest() {
    return await new Promise((resolve, reject) => {
      const showingId = +this.route.snapshot.paramMap.get('showingId');
      this.httpClient.get(this.ROOT_URL + "?id=" + showingId).subscribe((val) => {
        this.val = val;
        console.log("This is my data: ");
        console.log(this.val);
        resolve(this.val);
      });
    });
  }

  // sendPostRequest() {

  //   this.posts = this.httpClient.get("http://localhost:8080/SLKTheatres/api/login.app?username=testuser2&password=testpass");

  //   console.log(this.posts.json());
  // }

  ngOnInit() {
    this.setUpSeatSelected();
    this.getShowing();
    this.getSeatsRequest().then(() => {
      this.setUpSeatData();
      this.isDataAvailable = true;
    });

  }

  getShowing(): void {
    const showingId = +this.route.snapshot.paramMap.get('showingId');
    this.showingService.getShowing(showingId).subscribe( showing => this.showing = showing);
  }

  setUpSeatSelected() { //here we want to se
    for (let i = 1; i <= 50; i++) {

      this.seats.push({
        selected: false,
        number: i,
        taken: false
      });

      console.log("CHECKING VAL HERE");
      console.log(this.val);

    }

    console.log(this.seats);
  }

  setUpSeatData() {
    console.log("In setup data");

    for (let i = 0; i < this.val.length; i++) {
      // console.log(this.val[i]);
      if(this.val[i].status != 0){
        this.seats[i].taken = true;
      }

    }

  }

}
