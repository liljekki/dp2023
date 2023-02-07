import { Injectable } from "@angular/core";
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Entity } from '../interfaces/entity';

@Injectable({
  providedIn: 'root'
})
export class Service1Service {
url:string="http://localhost:8800/lection1-web2/servlet"

  constructor(private http:HttpClient) { }

  getEntities():Observable<Entity[]>{
    return this.http.get<Entity[]>(this.url);
  }
  public updateMyEntity(name: Object, description: Object, ImgUrl: Object) {
    this.http.put(this.url + "?name="+name+"&description="+description+"&ImgUrl="+ImgUrl,ImgUrl).subscribe(data => {
      console.log(data);
    });
  }

}