import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { EmailDetail } from '../forgot-site/email';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ForgotServiceService {

  ROOT_URL = 'http://localhost:9005/SLKTheatres/forgotpassword/recover.app';

  constructor(private http: HttpClient, private router: Router) { }

  submitEmail(emailD: EmailDetail): Observable<any> {
    const url = this.ROOT_URL;
    return this.http.post(url, emailD.email1);
  }
}
