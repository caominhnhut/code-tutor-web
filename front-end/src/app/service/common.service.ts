import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  constructor() { }

  public scrollToElement(elementId: string): void {
    let element = document.getElementById(elementId);
    if(element != null){
		  element.scrollIntoView({behavior:"smooth"});
    }
  }
}
