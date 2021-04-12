import { Component } from '@angular/core';
import { CommonService } from './service/common.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'code-tutor';

  constructor(private commonService: CommonService){};

  public scrollToElement(elementId: string): void {
    this.commonService.scrollToElement(elementId);
  }
}
