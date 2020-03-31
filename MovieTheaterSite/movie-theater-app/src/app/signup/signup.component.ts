import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserService } from '../services/user.service';
import { MessageService } from '../services/message.service';
import { User } from '../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})

export class SignupComponent implements OnInit {

  constructor(private router: Router , private userService: UserService, private messageService: MessageService) { }

  get UserName() {
    return this.form.get('username');
  }

  get Email() {
    return this.form.get('email');
  }

  get FirstName() {
    return this.form.get('firstname');
  }

  get LastName() {
    return this.form.get('lastname');
  }

  get Password() {
    return this.form.get('password');
  }

  get ConfirmPassword() {
    return this.form.get('confirmpassword');
  }

  private signUpUser = new User('', '');

  // create the form object
   form = new FormGroup({
    username: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
    firstname: new FormControl('', Validators.required),
    lastname: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    confirmpassword: new FormControl('', Validators.required),

  });

  SignUpForm(signupinfo) {
    let pass = this.Password.value;
    let confirmPass = this.ConfirmPassword.value;

    if(pass ==confirmPass) {
      this.signUpUser.username = this.UserName.value;
      this.signUpUser.email = this.Email.value;
      this.signUpUser.firstName = this.FirstName.value;
      this.signUpUser.lastName = this.LastName.value;
      this.signUpUser.password = this.Password.value;

      // console.log(this.signUpUser)
      this.userService.addUser(this.signUpUser).subscribe(
        response => {
          let result = response;
          console.log(result);
          if(result >0){
            //sends back to login
            this.router.navigate(['/login']);
          } else {
            alert("error has occured while registering user. Please try again later");
          }
        }
      );
    } else {
      alert("The passwords you entered don't match!");
    }
  }

  ngOnInit(): void {
  }



 



}
