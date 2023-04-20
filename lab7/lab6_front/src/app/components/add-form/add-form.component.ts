import { Component, OnInit } from '@angular/core';
import { Entity } from 'src/app/interfaces/entity';
import { Service1Service } from 'src/app/services/service1.service';

@Component({
  selector: 'app-add-form',
  templateUrl: './add-form.component.html',
  styleUrls: ['./add-form.component.scss']
})
export class AddFormComponent  implements OnInit {

  title:string="List";
  elemList:Entity[]=[];
  showAddForm:boolean=false;
  selectedElem?:Entity;


  constructor(private service:Service1Service){}

  ngOnInit(): void{
    this.updateElem();
    this.service.list.subscribe(
      (list:Entity[])=>{this.elemList=list}
    );
  }
  updateElem() {
    this.service.getEntities().subscribe(
      (elements)=>{
        this.elemList = elements._embedded.entities;
      }
    );
    
  }
  addElem(elem:Entity){
    this.service.postEntities(elem).subscribe(
      (elements)=>{
        this.updateElem();
      }
    );
   
  }
  onSelect(elem:Entity){
    if (this.selectedElem && elem.id==this.selectedElem.id){
      this.selectedElem=undefined;
    }
    else{
      this.selectedElem=elem;
    }
  }
  deleteElem(elem:Entity){
    this.service.deleteEntities(elem).subscribe(
      ()=>{
        this.updateElem();
      }
    );
    
  }

  refreshPage(): void{
    window.location.reload();
  }

}
