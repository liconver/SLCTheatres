import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PurchasePageComponent } from './purchase-page/purchase-page.component';
import { ForgotSiteComponent } from './forgot-site/forgot-site.component';


const routes: Routes = [
  { path: 'purchases', component: PurchasePageComponent},
  { path: 'forgot', component: ForgotSiteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [PurchasePageComponent, ForgotSiteComponent];
