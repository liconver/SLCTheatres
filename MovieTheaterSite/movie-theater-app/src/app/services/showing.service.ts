import { Injectable } from '@angular/core';
import { Showing } from '../showing';
import { Observable, of } from 'rxjs';
import { MessageService } from './message.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ShowingService {

  private showingsUrl = 'http://localhost:8082/SLKTheatres/api/getshowings';
  private showingUrl = 'http://localhost:8082/SLKTheatres/api/getshowing';

  constructor(private http: HttpClient, private messageService: MessageService ) { }


  
  /** GET showings by movieid. Will 404 if id not found */
  getShowings(movieId: number): Observable<Showing[]> {
    // send the message _after_ fetching the movie
    this.messageService.add(`ShowingService: fetched showings with movieId=${movieId}`);
    const url = `${this.showingsUrl}/${movieId}.app`;
    return this.http.get<Showing[]>(url).pipe(
      tap(_ => this.log(`fetched showings movieId=${movieId}`)),
      catchError(this.handleError<Showing[]>(`getShowings movieId=${movieId}`))
    );
  }

  /** GET showing by showingid. Will 404 if id not found */
  getShowing(showingId: number): Observable<Showing> {
    // send the message _after_ fetching the movie
    this.messageService.add(`ShowingService: fetched showing showingId=${showingId}`);
    const url = `${this.showingUrl}/${showingId}.app`;
    return this.http.get<Showing>(url).pipe(
      tap(_ => this.log(`fetched movieId=${showingId}`)),
      catchError(this.handleError<Showing>(`getMovie movieId=${showingId}`))
    );
  }

  private log(message: string) {
    this.messageService.add(`MovieService: ${message}`);
  }

   /**
 * Handle Http operation that failed.
 * Let the app continue.
 * param operation - name of the operation that failed
 * param result - optional value to return as the observable result
 */
private handleError<T>(operation = 'operation', result?: T) {
  return (error: any): Observable<T> => {

    // TODO: send the error to remote logging infrastructure
    console.error(error); // log to console instead

    // TODO: better job of transforming error for user consumption
    this.log(`${operation} failed: ${error.message}`);

    // Let the app keep running by returning an empty result.
    return of(result as T);
  };
}

}
