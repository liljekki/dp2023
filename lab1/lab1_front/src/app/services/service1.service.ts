import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Entity } from '../interfaces/entity';

@Injectable({
  providedIn: 'root'
})
export class Service1Service {
url:string="http://localhost:8900/lection1-web2/servlet"

  constructor(private http:HttpClient) { }

  getEntities():Observable<Entity[]>{
    return this.http.get<Entity[]>(this.url);
  }

}