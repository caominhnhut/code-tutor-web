import { Component, OnInit } from '@angular/core';
import { BUTTON_CONTACT_ME } from 'src/app/constant/common';
import { CommonService } from 'src/app/service/common.service';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css']
})
export class AuthenticationComponent implements OnInit {

  constructor(private commonService: CommonService) { }

  ngOnInit(): void {
    this.scrollToElement(BUTTON_CONTACT_ME);
  }

  private scrollToElement(elementId: string): void {
    this.commonService.scrollToElement(elementId);
  }
}
