import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { MatTabsModule } from '@angular/material/tabs';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { from } from 'rxjs';
import { HomeComponent } from './component/home/home.component';
import { CourseComponent } from './component/home/course/course.component';
import { TeacherComponent } from './component/home/teacher/teacher.component';
import { LessionComponent } from './component/lession/lession.component';
import { LessionDetailComponent } from './component/lession/lession-detail/lession-detail.component';
import { AuthenticationComponent } from './component/authentication/authentication.component';
import { AccountRegisterComponent } from './component/account-register/account-register.component';
import { SharingComponent } from './component/sharing/sharing.component';
import { RecruitmentComponent } from './component/recruitment/recruitment.component';
import { DocumentComponent } from './component/document/document.component';
import { YourPageComponent } from './component/your-page/your-page.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CourseComponent,
    TeacherComponent,
    LessionComponent,
    LessionDetailComponent,
    AuthenticationComponent,
    AccountRegisterComponent,
    SharingComponent,
    RecruitmentComponent,
    DocumentComponent,
    YourPageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    MatTabsModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
