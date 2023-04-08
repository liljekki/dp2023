import { Component } from '@angular/core';
import { Entity } from 'src/app/interfaces/entity';
import { Service1Service } from 'src/app/services/service1.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent {
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
