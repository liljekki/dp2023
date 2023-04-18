import { Injectable } from "@angular/core";
import {HttpClient} from '@angular/common/http'
import { BehaviorSubject, Observable } from 'rxjs';
import { Entity } from '../interfaces/entity';
import { Http } from '../interfaces/rest.interfaces/http';

@Injectable({
  providedIn: 'root'
})
export class Service1Service {
  url: string = "http://localhost:1155/things"
  
  list = new BehaviorSubject<Entity[]>([])

  constructor(private http:HttpClient) { }

  getEntities():Observable<Http>{
    return this.http.get<Http>(this.url);
  }
  postEntities(entity:Entity):Observable<Entity>{
    return this.http.post<Entity>(this.url, entity);
  }

  putEntities(entity:Entity):Observable<Entity[]>{
    return this.http.put<Entity[]>(this.url + `/${entity.id}`, entity);
  }

  deleteEntities(entity:Entity):Observable<Entity[]>{
      return this.http.delete<Entity[]>(this.url + `/${entity.id}`);
    }

  setList(list:Entity[]){
    this.list.next(list);
  }

}