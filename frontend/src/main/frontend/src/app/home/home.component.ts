import { Component } from '@angular/core';
import {FacebookService} from "../facebook/facebook.service";
import {Router} from "@angular/router";

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  providers:[FacebookService]
})
export class HomeComponent {
  facebookProfiles: any;

  constructor(private router:Router,private facebookService: FacebookService) {
    this.facebookProfiles=facebookService.getFacebooksProfile();
  }

  goToDetalis(id){
    this.router.navigate(['go',id]);
  }

}
