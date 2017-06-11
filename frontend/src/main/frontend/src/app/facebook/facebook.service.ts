import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import {Observable} from "rxjs";


@Injectable()
export class FacebookService {
  constructor(private http: Http) {
  }

  getFacebooksProfile():Observable<any> {
    return this.http.get("/api/getAll")
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }
  getProfile(id:string):Observable<any>{
    return this.http.get("/api/go/"+id)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }
  getWordsMap():Observable<any> {
    return this.http.get("/api/getWords")
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

}
