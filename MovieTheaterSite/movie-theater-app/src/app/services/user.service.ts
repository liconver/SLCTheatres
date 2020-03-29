import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, } from '@angular/common/http';
import { User } from '../user';
import { MessageService } from './message.service';
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';




@Injectable({
  providedIn: 'root'
})
export class UserService {

  private signupUrl = 'http://localhost:8080/SLKTheatres/api/adduser.app';
  private loginUrl = 'http://localhost:8080/SLKTheatres/api/loginuser.app';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }
   // observe: new HttpObserve(),
   // responseType: 'json'
    )
  };

  constructor(private http: HttpClient, private messageService: MessageService) { }
  
  private log(message: string) {
    this.messageService.add(`UserService: ${message}`);
  }

  addUser(user: User): Observable<any> {
    console.log("in adduser");
    return this.http.post(this.signupUrl, user).pipe(
      tap((user: User) => this.log(`added user w/ username=${user.username}`)),
      catchError(this.handleError<User>('addUser'))
    );
  }

  /** GET movie by id. Will 404 if id not found */
  getUser(username: string): Observable<User> {
    const url = `${this.signupUrl}/${username}`;
    return this.http.get<User>(url).pipe(
      tap(_ => this.log(`fetched user username=${username}`)),
      catchError(this.handleError<User>(`getUser username=${username}`))
    );
  }

  /** POST login attempt  */
  loginUser(user: User): Observable<any> {
    return this.http.post(this.loginUrl, user);
  }

  /*
  //Check whether User is loggedIn or not.  
 isLoggedIn() {  
  // create an instance of JwtHelper class.  
  let jwtHelper = new JwtHelperService();  
  // get the token from the localStorage as we have to work on this token.  
  let token = localStorage.getItem('token');  
  // check whether if token have something or it is null.  
  if(!token)  {  
    return false;  
  }  
  // get the Expiration date of the token by calling getTokenExpirationDate(String) method of JwtHelper class. this method accepts a string value which is nothing but a token.  
  if(token)  {  
    let expirationDate = jwtHelper.getTokenExpirationDate(token);  
    // check whether the token is expired or not by calling isTokenExpired() method of JwtHelper class.  
    let isExpired = jwtHelper.isTokenExpired(token);  
    return !isExpired;      
  }     
  } 
  */

  /**
* Handle Http operation that failed.
* Let the app continue.
* param operation - name of the operation that failed
* param result - optional value to return as the observable result
*/
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      alert('http error');
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
