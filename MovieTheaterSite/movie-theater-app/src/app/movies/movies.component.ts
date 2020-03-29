import { Component, OnInit } from '@angular/core';
import { Movie } from '../movie';
import { MovieService } from '../services/movie.service';
import { MessageService } from '../services/message.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {
  movies: Movie[];

  imagewidth = 200;
  imagemargin = 2;

  constructor(private movieService: MovieService, private messageService: MessageService) { }
  
  ngOnInit(): void {
    this.getMovies();
  }

  getMovies(): void {
    this.movieService.getMovies().subscribe(movies => this.movies = movies);
  }

}
