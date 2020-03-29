import { Component, OnInit } from '@angular/core';
import { SeatDataService } from '../seat-data.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  readonly ROOT_URL = "http://localhost:8080/SLKTheatres/purchaseapi/purchase.app";

  message:number[];
  val: any;
  seatService: SeatDataService = new SeatDataService;
  list = [];
  out = []; //This is what we will output to the checkout

  passenger: Passenger = new Passenger("Adult");

  titleArray: ValueAndText[] = [
    new ValueAndText("Adult", "Adult - $10"),
    new ValueAndText("Child", "Child - $5"),
    new ValueAndText("Senior", "Senior - $6")
  ];

  purchaseTickets() {
    console.log("output after purchase!");
    console.log(this.out);
    this.postPurchase();
  }

  setUpTypes() {

  }

  createFromList() {

  }

  async postPurchase() {

    let data= {
      "id":123,
      "totalCost":9.99,
      "seatData": "data"
      }

    return await new Promise((resolve, reject) => {
      this.httpClient.post(this.ROOT_URL, "something").subscribe((val) => {
        this.val = val;
        console.log("This is my data: ");
        console.log(this.val);
        resolve(this.val);
      });
    });
  }

  constructor(private data: SeatDataService, private httpClient: HttpClient) { }
  ngOnInit(): void {
    
    this.data.currentMessage.subscribe(message => this.message = message);
    console.log("My MESSAGE in CHECKOUT!");
    console.log(this.message);
    this.list = this.message;

    console.log(this.message.length);
    for (let i = 0; i < this.list.length; i++) {
      this.out.push({ seat: this.list[i], type: "Adult" });
    }
    console.log("my out");
    console.log(this.out);
  }

}

export class Quiz {
  constructor(public quizNum: number, public points: number) {

  }
}

export class TicketData {
  constructor(seat: number, type: string) { }
}

export class Passenger {
  constructor(public type: string) { };
}

export class ValueAndText {
  constructor(public Value: string, public Text: string) { }
}
