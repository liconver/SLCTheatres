import { Injectable } from '@angular/core';
import { PastPurchases } from '../purchase-page/purchases';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PurchaseService {

private url: string = "http://localhost:9005/SLKTheatres/ppapi/getallpurchases.app";

  constructor(private http: HttpClient) { }

  getPurchases(): Observable<any> {
    return this.http.get<PastPurchases>(this.url);
  }
}
