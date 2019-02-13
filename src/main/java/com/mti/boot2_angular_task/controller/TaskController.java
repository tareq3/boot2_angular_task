package com.mti.boot2_angular_task.controller;

import com.mti.boot2_angular_task.domain.Task;

import com.mti.boot2_angular_task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//controller communicate with service

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    //Injecting Interface as uncle bob's law, instead of concreate class interface should be injected
    //make sure concrete class has the component// or service annotation
    private TaskService mTaskService; // as we need TestServiceImpl we will use TestServiceImpl's Interface as uncle bob

    @Autowired //optional
    public TaskController(TaskService mTaskService) {
        this.mTaskService = mTaskService;
    }

    //Get default call
    @GetMapping( value = {"", "/"})
    public Iterable<Task> list(){
        return this.mTaskService.list();
    }

    //save the task
    @PostMapping("/save")
    public Task saveTask(@RequestBody Task task )//as request body will have the task data
    {
        return this.mTaskService.save(task);
    }


}
