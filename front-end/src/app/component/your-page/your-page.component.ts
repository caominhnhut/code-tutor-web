import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-your-page',
  templateUrl: './your-page.component.html',
  styleUrls: ['./your-page.component.css']
})
export class YourPageComponent implements OnInit {

  index: number = 1;
  
  constructor() { }

  ngOnInit(): void {
  }

}
