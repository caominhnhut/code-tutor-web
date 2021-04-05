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
  { path: 'your-page', component: YourPageComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
