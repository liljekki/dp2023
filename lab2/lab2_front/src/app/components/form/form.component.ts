import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Service1Service } from 'src/app/services/service1.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class EditFormComponent {
  constructor(private service: Service1Service) { }

  name: string = '';
  description: string = '';
  ImgUrl: string = '';

  getName(val: string) {
    console.warn(val)
    this.name = val
  }
  getImg(val: string) {
    console.warn(val)
    this.ImgUrl = val
  }
  getDescription(val: string) {
    console.warn(val)
    this.description = val
  }

  OnClick(): void {
    console.log(this.name)
    console.log(this.ImgUrl)
    console.log(this.description)
    this.service.updateMyEntity(this.name,  this.description, this.ImgUrl);
  }

}
