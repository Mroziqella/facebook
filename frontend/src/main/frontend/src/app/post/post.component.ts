import {Component, OnInit} from '@angular/core';
import {FacebookService} from "../facebook/facebook.service";
import {ActivatedRoute} from "@angular/router";


@Component({
  templateUrl: 'post.component.html',
  providers: [FacebookService]

})
export class PostComponent implements OnInit {

  constructor(private route: ActivatedRoute, private facebookService: FacebookService) {

  }

  ngOnInit(): void {

  }



}
