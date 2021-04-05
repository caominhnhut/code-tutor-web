import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { HeroService } from 'src/app/service/hero.service';
import { Hero } from './model/hero'
import { HEROES } from './model/mock-heroes'

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  constructor(private heroService: HeroService) { }

  ngOnInit(): void {
    this.getHeroes();
  }

  hero: Hero = {
    id: 1,
    name: 'Windstorm'
  };

  heroes: Hero[] = [];

  selectedHero?: Hero;

  onSelect(hero: Hero): void {
    this.selectedHero = hero;
  }

  getHeroes(): void {
    this.heroService.getHeroes().subscribe(heroesRespone => this.heroes = heroesRespone);
  }

}
