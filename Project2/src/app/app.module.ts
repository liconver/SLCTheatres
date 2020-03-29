import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SeatsComponent } from './seats/seats.component';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router'
import { CheckoutComponent } from './checkout/checkout.component';
import { SeatDataService } from './seat-data.service';
import { HttpClientModule } from '@angular/common/http';
import { ShowingComponent } from './showing/showing.component';

@NgModule({
  declarations: [
    AppComponent,
    SeatsComponent, 
    CheckoutComponent, ShowingComponent, 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path: "checkout", component:CheckoutComponent},
      {path: "seats", component:SeatsComponent}
    ])
  ],
  providers: [SeatDataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
