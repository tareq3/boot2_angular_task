import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
/*This is optional for this project as we have only one page*/
const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
