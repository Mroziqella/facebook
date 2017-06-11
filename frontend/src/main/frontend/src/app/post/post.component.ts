import {Component, OnInit, Input} from '@angular/core';
import {FacebookService} from "../facebook/facebook.service";
import {ActivatedRoute} from "@angular/router";


@Component({
  selector:'post',
  templateUrl: 'post.component.html',
  providers: [FacebookService]
})


export class PostComponent implements OnInit {
  @Input() id: string;
  post:any;

  constructor(private route: ActivatedRoute, private facebookService: FacebookService) {

  }

  ngOnInit(): void {
    this.facebookService.getPost(this.id).subscribe(
      post=>{
        this.post=post;
        console.log(this.post)
      }
    )
  }



}
