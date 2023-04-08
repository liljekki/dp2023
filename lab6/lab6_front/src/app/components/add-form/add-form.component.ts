import { Component, OnInit } from '@angular/core';
import { Entity } from 'src/app/interfaces/entity';
import { Service1Service } from 'src/app/services/service1.service';

@Component({
  selector: 'app-add-form',
  templateUrl: './add-form.component.html',
  styleUrls: ['./add-form.component.scss']
})
export class AddFormComponent implements OnInit{

  title:string="Our Products:";
  entitityList:Entity[]=[];
  showAddForm:boolean=false;
  selectedEntity?:Entity;

  constructor(private service:Service1Service) {}

  ngOnInit(): void{
    this.updateEntities();
    this.service.list.subscribe(
      (list:Entity[])=>{this.entitityList=list}
    );
  }

  updateEntities(){
    this.service.getEntities().subscribe(
      (entities)=>{
        this.service.setList(entities);
      }
    );
  }

  addEntities(entity:Entity){
    this.service.postEntities(entity).subscribe(
      (entities)=>{
        this.updateEntities();
      }
    );
    this.refreshPage();
  }

  onSelect(entity:Entity){
    if(this.selectedEntity && entity.id==this.selectedEntity.id){
      this.selectedEntity=undefined;
    } else{
      this.selectedEntity=entity;
    }
  }

  deleteEntities(entity:Entity){
    this.service.deleteEntities(entity).subscribe(
      ()=>{
        this.updateEntities();
      }
    );
    this.refreshPage();
  }

  refreshPage(): void{
    //window.location.reload();
  }
}
