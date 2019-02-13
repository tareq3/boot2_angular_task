package com.mti.boot2_angular_task.service;

import com.mti.boot2_angular_task.domain.Task;
import com.mti.boot2_angular_task.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// service communicate with repository and provide it to controller

//as service is a spring component
@Service
public class TaskServiceImp implements TaskService {

    private TaskRepository taskRepository; // Repository needed for getting data from database

    @Autowired //auto wiring is optional as spring constructor wiring done by default it needed for setter and property dependency Injection
    public TaskServiceImp(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //for getting tasks
    @Override
    public Iterable<Task> list() { //iterable has two method hesnext() and next()
        return this.taskRepository.findAll();// get all Task using crud operation
    }

    //for setting task
    @Override
    public Task save(Task task) {
        return this.taskRepository.save(task);
    }
}
