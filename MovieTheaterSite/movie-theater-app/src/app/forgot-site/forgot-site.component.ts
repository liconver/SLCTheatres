import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ForgotServiceService } from '../services/forgot-service.service';
import { EmailDetail } from './email';

@Component({
  selector: 'app-forgot-site',
  templateUrl: './forgot-site.component.html',
  styleUrls: ['./forgot-site.component.css']
})
export class ForgotSiteComponent implements OnInit {

  ROOT_URL = 'http://localhost:9005/SLKTheatres/forgotpassword/recover.app';
  loading = false;
  private emailDetail = new EmailDetail();

  forgotForm = new FormGroup({
    email1: new FormControl('', Validators.required),
    email2: new FormControl('', Validators.required)
  });

  constructor(private fServ: ForgotServiceService, private router: Router) {
  }

  onSubmit(event) {
    const email = this.Email.value;
    const confirmEmail = this.ConfirmEmail.value;

    if (email == confirmEmail) {
      this.emailDetail.email1 = this.Email.value;
      this.emailDetail.email2 = this.ConfirmEmail.value;

      this.router.navigate(['login']);

      this.fServ.submitEmail(this.emailDetail).subscribe( 
        response => {

          const result = response;
          console.log(result);

          if (result > 0) {
            console.log('Email send to Controller!')
          }
          else {
            alert('Error occured while submitting. Please try again later.');
          }
        },
        error => {
          alert('Error occured while submitting. Please try again later.');
        }
      );
    }
    else {
      alert('Emails do not match! Please retry.');
    }
  }

  get Email() {
    return this.forgotForm.get('email1');
  }

  get ConfirmEmail() {
    return this.forgotForm.get('email2');
  }

  ngOnInit(): void {}
}
