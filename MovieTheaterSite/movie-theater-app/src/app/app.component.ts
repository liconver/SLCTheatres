import { Component } from '@angular/core';
import { MessageService } from './services/message.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'SLC Theatres';
  isLoggedIn;

  constructor(private router: Router, private messageService: MessageService){
  }
  
  ngOnInit(): void {
    this.isLoggedIn = this.readLocalStorageValue('token');
   
  }
    readLocalStorageValue(key) {
      return sessionStorage.getItem(key);
  }

  logout() {
    // Remove the token from the localStorage.  
    sessionStorage.removeItem('token');
    window.location.reload();
    //this.router.navigate(['']);
    this.messageService.add('You Just Logged Out '+sessionStorage.getItem('token'));

    //setTimeout( window.location.reload(), 5000) ;
  }

    
  
}
