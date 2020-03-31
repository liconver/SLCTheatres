import { Component, OnInit, ViewChild } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import { PurchaseService } from '../services/purchase.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { PastPurchases } from './purchases';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';



@Component({
  selector: 'app-purchase-page',
  templateUrl: './purchase-page.component.html',
  styleUrls: ['./purchase-page.component.css'],
  providers: [PurchaseService]
})
export class PurchasePageComponent implements OnInit {

  public PastPurchases = [];

  ROOT_URL = 'http://localhost:9005/SLKTheatres/ppapi/getallpurchases.app';
  val: any;

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  displayedColumns: string[] = ['purchase', 'movie', 'showtime', 'seats', 'cost'];
  dataSource = new MatTableDataSource(this.PastPurchases);

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  constructor(private myPurchaseServ: PurchaseService, private http: HttpClient,  private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    this.myPurchaseServ.getPurchases()
        .subscribe(pdata => this.PastPurchases = pdata);
    // this.getSeatsRequest();
  }

  async getSeatsRequest() {
    return await new Promise((resolve, reject) => {
      const showingId = +this.route.snapshot.paramMap.get('showingId');
      this.http.get(this.ROOT_URL /* + "?id=" + showingId */).subscribe((val) => {
       this.PastPurchases = this.val;
       console.log('This is my data: ');
       console.log(this.val);
       resolve(this.val);
      });
    });
  }
}



