import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { purchase } from './purchase';
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';


@Component({
  selector: 'app-purchase-page',
  templateUrl: './purchase-page.component.html',
  styleUrls: ['./purchase-page.component.css']
})
export class PurchasePageComponent implements OnInit {

  public PastPurchases = [];

  ROOT_URL = 'http://localhost:8082/SLKTheatres/ppapi/getallpurchases.app';
  userIdUrl = 'http://localhost:8082/SLKTheatres/ppapi/getallpurchase';
  purchases: purchase[];
  userId;
  constructor(private http: HttpClient,private route: ActivatedRoute) { }


  ngOnInit(): void {
     //this.getPurchases();
     let uID = +this.readLocalStorageValue('token');
     console.log(uID);
     this.getPurchases(uID);
  }

  // async getSeatsRequest() {
  //   return await new Promise((resolve, reject) => {
  //     const showingId = +this.route.snapshot.paramMap.get('showingId');
  //     this.http.get(this.ROOT_URL /* + "?id=" + showingId */).subscribe((val) => {
  //      this.PastPurchases = this.val;
  //      console.log('This is my data: '+this.PastPurchases);
  //      console.log(this.val);
  //      resolve(this.val);
  //     });
  //   });
  // }
  getPastPurchases(): Observable<any[]> {
     return this.http.get<any[]>(this.ROOT_URL)
       .pipe(
        tap(_ => this.log('fetched past purchase')),
         catchError(this.handleError<any[]>('getpastpurchases', []))
       );
   }


   getPastPurchasesById(userId: number): Observable<any[]> {
    const url = `${this.userIdUrl}/${userId}.app`;
    return this.http.get<any[]>(url)
       .pipe(
        tap(_ => this.log('fetched past purchase')),
         catchError(this.handleError<any[]>('getpastpurchases', []))
       );
   }

   readLocalStorageValue(key) {
    return sessionStorage.getItem(key);
}






   private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  private log(message: string) {
    //this.messageService.add(`MovieService: ${message}`);
  }

  getPurchases(userId: number): void {
    this.getPastPurchasesById(userId).subscribe(purchases => this.purchases = purchases);
  }

}



