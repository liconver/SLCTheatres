import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../services/user.service';
import { MessageService } from '../services/message.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  submitted = false;
  signUp = false;
  // TODO: CHANGE this when we're done
  model1: User;

  constructor(private router: Router, private userService: UserService, private messageService: MessageService) {

    
   }

  ngOnInit(): void {
    // if(this.userService.isLoggedIn()) {
    //  this.router.navigate(['/']);
    // } ;
   this.model1 = new User('', '');
  }


  LoginSubmit(form) {
    console.log(form.value);
    this.submitted = true;
    this.userService.loginUser(this.model1).subscribe(
      response => {
        let result = response;
        console.log(result);
        if (result > 0) {
          sessionStorage.setItem('token', result);
          
          window.location.reload();
          this.messageService.add('You just logged in');
          this.router.navigate(['']);
          
        } else {
          this.model1 = new User('', '');
          alert('incorrect login credentials');
        }
      },
      error => {
        console.log("Error in authentication");
      }
    );
  }




  // TODO: Remove this when we're done
  get diagnostic() { return 'Hi '+ this.model1.username; }


}
