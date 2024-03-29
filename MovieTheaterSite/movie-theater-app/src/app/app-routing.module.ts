import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MoviesComponent } from './movies/movies.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MovieDetailComponent } from './movie-detail/movie-detail.component';
import { LogInComponent } from './log-in/log-in.component';
import { SignupComponent } from './signup/signup.component';
import { SeatsComponent} from './seats/seats.component';
import {CheckoutComponent } from './checkout/checkout.component';
import { PurchasePageComponent } from './purchase-page/purchase-page.component';
import { ForgotSiteComponent } from './forgot-site/forgot-site.component';
import { SplashComponent } from './splash/splash.component';


const routes: Routes = [
  { path: 'splash', component: SplashComponent},
  { path: 'purchases', component: PurchasePageComponent},
  { path: 'forgot', component: ForgotSiteComponent},
  { path: 'checkout', component: CheckoutComponent},
  { path: 'seats/:showingId', component: SeatsComponent},
  { path: 'movies', component: MoviesComponent },
  {path: 'dashboard', component: DashboardComponent },
  { path: '', redirectTo: '/dashboard', pathMatch: 'full'},
  { path: 'detail/:movieId', component: MovieDetailComponent},
  { path: 'login', component: LogInComponent},
  { path: 'signup', component: SignupComponent}
]


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
