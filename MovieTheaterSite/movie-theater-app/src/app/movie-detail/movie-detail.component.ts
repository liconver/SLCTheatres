import { Component, OnInit, Input } from '@angular/core';
import { Movie } from '../movie';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { MovieService } from '../services/movie.service';

@Component({
  selector: 'app-movie-detail',
  templateUrl: './movie-detail.component.html',
  styleUrls: ['./movie-detail.component.css']
})
export class MovieDetailComponent implements OnInit {
  @Input() movie: Movie;

  constructor(private route: ActivatedRoute,
              private movieService: MovieService,
              private location: Location) { }

  ngOnInit(): void {
    this.getMovie();
  }

  goBack(): void {
    this.location.back();
  }

  getMovie(): void {
    const movieId = +this.route.snapshot.paramMap.get('movieId');
    this.movieService.getMovie(movieId).subscribe( movie => this.movie = movie);
  }

}
