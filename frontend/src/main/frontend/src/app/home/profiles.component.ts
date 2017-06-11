import {Component, Pipe, PipeTransform, OnInit} from '@angular/core';
import {FacebookService} from "../facebook/facebook.service";
import {Router} from "@angular/router";

@Component({
  selector: 'home',
  templateUrl: 'profiles.component.html',
  providers:[FacebookService],

})
export class Profilesomponent implements OnInit{
  facebookProfiles: any;
  wordsMap: any;

  constructor(private router:Router,private facebookService: FacebookService) {
    this.facebookProfiles=facebookService.getFacebooksProfile();
  }

  goToDetalis(id){
    this.router.navigate(['go',id]);
  }

  ngOnInit(): void {
      this.getWords();

  }

  getWords() {
    this.facebookService.getWordsMap().subscribe(
      words => {
        this.wordsMap = words;
      }
    )
  }

}

