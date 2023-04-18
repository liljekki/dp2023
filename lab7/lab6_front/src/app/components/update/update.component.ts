import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Entity } from 'src/app/interfaces/entity';
import { Service1Service } from 'src/app/services/service1.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit {
  @Input() entity?:Entity
  @Output() updated:EventEmitter<null> = new EventEmitter();
  constructor(private service:Service1Service) {}

  ngOnInit(): void {
  }

  updateEntities(){
    if(this.entity){
      this.service.putEntities(this.entity).subscribe(
        ()=>{this.updated.emit();}
      );
    }
    this.refreshPage();
  }

  refreshPage(): void{
     window.location.reload();
   }
}
