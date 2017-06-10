import {Component, OnInit} from '@angular/core';
import {FacebookService} from "../facebook/facebook.service";
import {ActivatedRoute} from "@angular/router";


@Component({
  templateUrl: './facebook.profile.component.html',
  providers: [FacebookService]

})
export class FacebookProfileComponent implements OnInit {
  loaded=false;
  profileDetails: any;

  constructor(private route: ActivatedRoute, private facebookService: FacebookService) {

  }

  ngOnInit(): void {
    this.route.params.subscribe(param => {
      this.getProfile(param['id']);
    });

  }

  getProfile(id: string) {
    this.facebookService.getProfile(id).subscribe(
      profile => {
        this.profileDetails = profile;
        console.log(this.profileDetails);
        this.loaded=true;
      }
    )
  }

}
