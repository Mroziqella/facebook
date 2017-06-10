import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {Routes, RouterModule} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {FacebookProfileComponent} from "./facebook/facebook.profile.component";


const routes: Routes = [
  { path: '', component: HomeComponent},
  {path:'go/:id',component:FacebookProfileComponent}
];


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FacebookProfileComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(routes, { useHash: false })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
