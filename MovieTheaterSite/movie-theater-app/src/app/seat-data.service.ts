import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SeatDataService {

  constructor() { }

  private messageSource = new BehaviorSubject<number[]>([]);
  currentMessage = this.messageSource.asObservable();

  changeMessage(message:number[]){
    this.messageSource.next(message);

  }
}
