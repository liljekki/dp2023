import { Component } from '@angular/core';
import { Entity } from 'src/app/interfaces/entity';
import { Service1Service } from '../../services/service1.service';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.scss']
})
export class ButtonComponent {
  title = 'lab1_front';
  entityList: Entity[] = [];

  constructor(private service: Service1Service) { }

  getEntities(): void {
    this.service.getEntities().subscribe(
      (entities) => {
        this.entityList = entities;
      }
    )
  }

}
