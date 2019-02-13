import { Component, OnInit } from '@angular/core';
import {Task} from "../task.model";
import {TaskService} from "../task.service";

@Component({
  selector: 'app-tasks-list', /*html tag selector*/
  templateUrl: './tasks-list.component.html',
  styleUrls: ['./tasks-list.component.css']
})
export class TasksListComponent implements OnInit {

  tasks: Task[]=[]; /*Array for task*/

/*Injecting task service for doing http jobs*/
  constructor(private taskService : TaskService) { }

/*On initialize we want to see all tasks*/
  ngOnInit() {
    /*getTasks() from taskService is a observable so by subscribing this we can get the result on next callbacks*/
      this.taskService.getTasks().subscribe(
        /*on Next callbacks returns tasks array*/
        (tasks: any[]) => {
        this.tasks=tasks; /*setting the class tasks value */
      },
        /*on error callbacks returns error*/
        (error1 => console.log(error1)  /*consoling error ; for single line we don't need to use return */     )
      );

      //subscribing event and update ui
      this.taskService.onTaskAdded.subscribe(
        /*on next callback returns task */
        (task : Task) => this.tasks.push(task)  /*then add the task to tasks list*/);
  }

  /*on changing task check status */
  onTaskChange($event, task){

    /*saveTask ovservable doesn't provide any result so we don't need  next or error */
    this.taskService.saveTask(task, $event.target.checked).subscribe(); /*we don't need to return anything cz this is a void method*/
}

/*this method returns badge color for bootstrap class*/
  getDueDateBadge(task :Task){
    /*if task completed change the bootstrap badge color to secondary */
  return task.completed ? 'badge-secondary' : 'badge-primary';
  }
}
