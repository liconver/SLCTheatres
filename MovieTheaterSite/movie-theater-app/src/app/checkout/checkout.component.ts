import { Component, OnInit } from '@angular/core';
import { SeatDataService } from '../seat-data.service';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { ifError } from 'assert';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  readonly ROOT_URL = "http://localhost:8082/SLKTheatres/purchaseapi/purchase.app";

  message: number[]; 
  val: any;
  seatService: SeatDataService = new SeatDataService;
  list = [];
  out = []; //This is what we will output to the checkout
  totalCost: number;
  ticketJSON: any = [];
  isLoggedIn;

  titleArray: TicketTypes[] = [
    new TicketTypes("Adult", "Adult - $12.99", 1),
    new TicketTypes("Child", "Senior - $8.99", 2),
    new TicketTypes("Senior", "Child - $6.99", 3)
  ];

  checkTotalCost() {
    this.totalCost = 0;
    for (var i = 0; i < this.out.length; i++) {
      if (this.out[i].type == "Adult") {
        this.totalCost += 12.99;
      } else if (this.out[i].type == "Senior") {
        this.totalCost += 8.99;
      } else if (this.out[i].type == "Child") {
        this.totalCost += 6.99;
      }
    }
    //console.log(this.totalCost);
  }

  createTicketPayload() {
    for (var i = 0; i < this.out.length; i++) {
      if (this.out[i].type == "Adult") {
        this.ticketJSON.push({
          id: this.out[i].seat,
          typeId: 1
        });
      } else if (this.out[i].type == "Senior") {
        this.ticketJSON.push({
          id: this.out[i].seat,
          typeId: 2
        });
      } else if (this.out[i].type == "Child") {
        this.ticketJSON.push({
          id: this.out[i].seat,
          typeId: 3
        });
      }
    }
    //console.log("my payload");
    //console.log(this.ticketJSON);
  }

  removePurchases(){
    localStorage.removeItem('seats');
    this.data.changeMessage([]);
  }

  tellToLogIn(){
    alert("Log in before you make a purchase");
  }
  async postPurchase() {

    

    this.createTicketPayload();
    this.checkTotalCost();

    let options = {
      headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')
    };
    let userId = this.readLocalStorageValue('token');
    let body = `id=${userId}&totalCost=${this.totalCost}&seatData=${JSON.stringify(this.ticketJSON)}`;

    return await new Promise((resolve, reject) => {
      this.httpClient.post(this.ROOT_URL, body, options).subscribe((val) => {
        this.val = val;
        //console.log("This is my data: ");
        //console.log(this.val);
        resolve(this.val);
      });
    });

  }

  constructor(private data: SeatDataService, private httpClient: HttpClient) { }
  ngOnInit(): void {

    this.data.currentMessage.subscribe(message => this.message = message);
    //console.log("My MESSAGE in CHECKOUT!");
    //console.log(this.message);
    this.list = this.message;
    this.isLoggedIn = this.readLocalStorageValue('token');
    //console.log(this.isLoggedIn);
    //THis

    
    if (this.list.length == 0) { //if list is empty, check the storage
      let temp = JSON.parse(localStorage.getItem('seats'));
        if(temp != null){
        this.list = temp;
        }

    } else {
      // console.log("Not empty mate, storing");
      localStorage.setItem('seats', JSON.stringify(this.list));
    }

    //console.log(this.message.length);
    for (let i = 0; i < this.list.length; i++) {
      // this.out.push({ seat: this.list[i], type: "Adult" });
      this.out.push(new Out(this.list[i].seatId, "Adult", this.list[i].seatName));
    }
    //console.log("my out ");
    //console.log(this.out);

  }
  readLocalStorageValue(key) {
    return sessionStorage.getItem(key);
}

}

export class TicketTypes {
  constructor(public Value: string, public Text: string, public TypeId: number) { }
}

export class Out {
  constructor(public seat: number, public type: string, public name: string) { }
}
