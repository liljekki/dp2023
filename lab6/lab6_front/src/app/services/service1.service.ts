import { Injectable } from "@angular/core";
import {HttpClient} from '@angular/common/http'
import { BehaviorSubject, Observable } from 'rxjs';
import { Entity } from '../interfaces/entity';

@Injectable({
  providedIn: 'root'
})
export class Service1Service {
  list = new BehaviorSubject<Entity[]>([])
url:string="http://localhost:1155/lab6/api/my_entity"

  constructor(private http:HttpClient) { }

  getEntities():Observable<Entity[]>{
    return this.http.get<Entity[]>(this.url + "/retrieve");
  }
  postEntities(entity:Entity):Observable<Entity[]>{
    return this.http.post<Entity[]>(this.url + '/create', entity);
  }

  putEntities(entity:Entity):Observable<Entity[]>{
    return this.http.put<Entity[]>(this.url + "/update" + `/${entity.id}`, entity);
  }

  deleteEntities(entity:Entity):Observable<Entity[]>{
      return this.http.delete<Entity[]>(this.url + "/delete" + `/${entity.id}`);
    }

  setList(list:Entity[]){
    this.list.next(list);
  }

}