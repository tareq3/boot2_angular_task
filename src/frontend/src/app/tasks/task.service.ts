import {EventEmitter, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";
import {Task} from "./task.model";

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  //Event is great

  onTaskAdded=new EventEmitter<Task>(); //this event will carry task

  constructor(private http: HttpClient) {
  }

  /*get tasks using http from any api*/
  getTasks() {
    return this.http.get('/api/tasks');
  }

  /*save task*/
  saveTask(task : Task, checked: boolean){
    task.completed=checked;

    return this.http.post('/api/tasks/save', task);
  }

  /*add task*/
  addTask(task : Task){
    return this.http.post('/api/tasks/save',task);
  }
  }
