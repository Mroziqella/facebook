import {PipeTransform, Pipe} from "@angular/core";
@Pipe({name: 'keys'})
export class KeysPipe implements PipeTransform
{
  transform(value, args:string[]) : any {
    let keys = [];
    for (let key in value) {
      if(key.length>3) {
        keys.push({key: key, value: value[key]});
      }
    }

    keys.sort((n1,n2) =>n2.value- n1.value)


    return keys.slice(0,10);
  }
}
