import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountRegisterComponent } from './component/account-register/account-register.component';
import { AuthenticationComponent } from './component/authentication/authentication.component';
import { DocumentComponent } from './component/document/document.component';
import { HomeComponent } from './component/home/home.component';
import { LessionDetailComponent } from './component/lession/lession-detail/lession-detail.component';
import { LessionComponent } from './component/lession/lession.component';
import { RecruitmentComponent } from './component/recruitment/recruitment.component';
import { SharingComponent } from './component/sharing/sharing.component';
import { UserBookmarkComponent } from './component/your-page/user-bookmark/user-bookmark.component';
import { UserChangePasswordComponent } from './component/your-page/user-change-password/user-change-password.component';
import { UserExerciseComponent } from './component/your-page/user-exercise/user-exercise.component';
import { UserNotificationComponent } from './component/your-page/user-notification/user-notification.component';
import { UserProfileComponent } from './component/your-page/user-profile/user-profile.component';
import { YourPageComponent } from './component/your-page/your-page.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'authenticate', component: AuthenticationComponent },
  { path: 'register', component: AccountRegisterComponent },
  { path: 'course/:course-id', component: LessionComponent },
  { path: 'lession/:lession-id', component: LessionDetailComponent },
  { path: 'sharing', component: SharingComponent },
  { path: 'recruitment', component: RecruitmentComponent },
  { path: 'document', component: DocumentComponent },
  { 
    path: 'your-page', 
    component: YourPageComponent,
    children: [
      {
        path: 'user-profile',
        component: UserProfileComponent,
      },
      {
        path: 'change-password',
        component: UserChangePasswordComponent,
      },
      {
        path: 'exercise',
        component: UserExerciseComponent,
      },
      {
        path: 'bookmark',
        component: UserBookmarkComponent,
      },
      {
        path: 'notification',
        component: UserNotificationComponent,
      }
    ]
  },
  { path: '', redirectTo: '/home', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
