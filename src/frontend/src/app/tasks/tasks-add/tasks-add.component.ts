import { Component, OnInit } from '@angular/core';
import {TaskService} from "../task.service";
import {Task} from "../task.model";

@Component({
  selector: 'app-tasks-add',
  templateUrl: './tasks-add.component.html',
  styleUrls: ['./tasks-add.component.css']
})
export class TasksAddComponent implements OnInit {
  addTaskValue: string=null;

  constructor(private taskService: TaskService) { }

  ngOnInit() {
  }

  /*on pressing enter we will call this method and create new task*/
  onTaskAdd( $event ){
    let task=new Task($event.target.value, false, "01/25/2019");
    /*addTask returns observable*/
    this.taskService.addTask(task).subscribe(
      /*on next retuns task callback*/
      (newTask: Task)=> {
      //clear the input
        this.addTaskValue= ' ';
        /*onTaskAdded is an event we are trigerring an event */
        this.taskService.onTaskAdded.emit(newTask);// we are emitting this event with task as package
    });
  }

}
