import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {Routes, RouterModule} from "@angular/router";
import {Profilesomponent} from "./home/profiles.component";
import {FacebookProfileComponent} from "./facebook/facebook.profile.component";
import {MapComponent} from "./map/map.component";
import { AgmCoreModule } from 'angular2-google-maps/core';
import {KeysPipe} from "./home/KeysPipe";
import {PostComponent} from "./post/post.component";

const routes: Routes = [
  { path: '', component: Profilesomponent},
  {path:'go/:id',component:FacebookProfileComponent},
  {path:'post/:id',component:PostComponent}
];


@NgModule({
  declarations: [
    AppComponent,
    Profilesomponent,
    FacebookProfileComponent,
    MapComponent,
    KeysPipe,
    PostComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AgmCoreModule.forRoot({
      apiKey:'AIzaSyDNjG3S7Vw1z7t3dI8cRyQLEO0LBPB5pVE'
    }),
    RouterModule.forRoot(routes, { useHash: false })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
