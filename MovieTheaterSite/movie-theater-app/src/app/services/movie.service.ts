import { Injectable } from '@angular/core';
import { Movie } from '../movie';
import { Observable, of } from 'rxjs';
import { MessageService } from './message.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  //private moviesUrl = 'http://localhost:9025/api/getmovies.app';
  //private movieIdUrl = 'http://localhost:9025/api/getmovie'

  private moviesUrl = 'http://localhost:8082/SLKTheatres/api/getmovies.app';
  private movieIdUrl = 'http://localhost:8082/SLKTheatres/api/getmovie'

  constructor(private http: HttpClient, private messageService: MessageService) { }

  private log(message: string) {
    //this.messageService.add(`MovieService: ${message}`);
  }

  /** GET movie by id. Will 404 if id not found */
  getMovie(movieId: number): Observable<Movie> {
    // send the message _after_ fetching the movie
   // this.messageService.add(`MovieService: fetched movie movieId=${movieId}`);
    const url = `${this.movieIdUrl}/${movieId}.app`;
    return this.http.get<Movie>(url).pipe(
      //tap(_ => this.log(`fetched movieId=${movieId}`)),
      catchError(this.handleError<Movie>(`getMovie movieId=${movieId}`))
    );
  }

  getMovies(): Observable<Movie[]> {
   // this.messageService.add('MovieService: fetched movies');
    return this.http.get<Movie[]>(this.moviesUrl)
      .pipe(
        tap(_ => this.log('fetched movies')),
        catchError(this.handleError<Movie[]>('getMovies', []))
      );
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
      // console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}




