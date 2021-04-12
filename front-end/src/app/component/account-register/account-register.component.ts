import { Component, OnInit } from '@angular/core';
import { BUTTON_CONTACT_ME } from 'src/app/constant/common';
import { CommonService } from 'src/app/service/common.service';

@Component({
  selector: 'app-account-register',
  templateUrl: './account-register.component.html',
  styleUrls: ['./account-register.component.css']
})
export class AccountRegisterComponent implements OnInit {

  constructor(private commonService: CommonService) { }

  ngOnInit(): void {
    this.scrollToElement(BUTTON_CONTACT_ME);
  }

  private scrollToElement(elementId: string): void {
    this.commonService.scrollToElement(elementId);
  }

}
