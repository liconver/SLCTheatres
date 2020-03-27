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
  signUp =false;
  // TODO: CHANGE this when we're done
  model1 = new User('', '');
  
  constructor( private router: Router, private userService: UserService, private messageService: MessageService) { }

  ngOnInit(): void {
  }


  LoginSubmit(form) {
  console.log(form.value);
  this.submitted = true;
  this.userService.loginUser(this.model1).subscribe(
    response => {
      let result = response;
      console.log(result);
      if(result > 0) {
        this.router.navigate([''],)
     } else{
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
  get diagnostic() { return JSON.stringify(this.model1); }


}
