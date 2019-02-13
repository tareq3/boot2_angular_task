package com.mti.boot2_angular_task.service;

import com.mti.boot2_angular_task.domain.Task;
//A service interface, Remember a service can have multiple impl
public interface TaskService {

    /*Iterable is just like array list but only has two method */
    Iterable<Task> list();

    Task save(Task task);
}
