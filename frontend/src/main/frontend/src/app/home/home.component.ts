import {Component, Pipe, PipeTransform, OnInit} from '@angular/core';
import {FacebookService} from "../facebook/facebook.service";
import {Router} from "@angular/router";

@Component({
  selector: 'home',
  templateUrl: 'home.component.html',
  providers:[FacebookService],

})
export class HomeComponent implements OnInit{
  facebookProfiles: any;
  wordsMap: any;
  search:string;
  foundPosts: string[];

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
  setSearch(item:any){
    this.search=item.key;
  }
  searchWord(word:string){
    console.log(word);
    this.facebookService.searchWord(word).subscribe(
      posts=>{
        this.foundPosts=posts;
      }
    );
  }

}

