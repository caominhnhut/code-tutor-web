import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Hero } from '../component/heroes/model/hero';
import { HEROES } from '../component/heroes/model/mock-heroes';

@Injectable({
  providedIn: 'root'
})
export class HeroService {

  constructor() { }

  getHeroes(): Observable<Hero[]> {

    const heroes = of(HEROES);

    return heroes;
  }
}
